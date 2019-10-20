/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jium.mkula.model;
import static java.lang.Math.PI;
import static java.lang.Math.abs;
import java.util.Random;

/**
 * Model for calcluating Pi for Pi_MonteCarlo
 * @author MATIK
 * @version 1.0.0
 */
public class Model {
    
    /**
     * Calculate Pi using MonteCarlo method
     * @param accuracy count of guesses, hgher=better
     * @return pi calculated using MonteCarlo
     * @throws CalculatedPiDiffersException exception when differs much from Math.Pi
     */
    public float CalculatePi(long accuracy) throws CalculatedPiDiffersException{
        Random generator = new Random();
        float posX,posY;
        int circleCount=0;
        for(long i=1; i<=accuracy; i++){
            posX = (float)generator.nextInt(Integer.MAX_VALUE)/Integer.MAX_VALUE;
            posY = (float)generator.nextInt(Integer.MAX_VALUE)/Integer.MAX_VALUE;
            if(posX*posX+posY*posY<=1){
                circleCount++;
            }
        };
        
        float pi = 4 * (float)circleCount/accuracy;
        if((abs(pi - PI)) > (PI/100)){
            throw new CalculatedPiDiffersException("Pi: " + pi + " Difference: " + abs(pi - PI));
        }
        return pi;
    }
    
}
