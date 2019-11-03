/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jium.mkula.model;
import static java.lang.Math.PI;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.util.Pair;

/**
 * Model for calcluating Pi for Pi_MonteCarlo
 * @author Mateusz Kula {matekul734@student.polsl.pl}
 * @version 1.0.2
 */
public class Model {
    /**
     * List of points pseudo-randomly generated
     */
    private List<Pair<Float,Float>> posList;
    /**
     * Pseudo-random generator
     */
    private Random generator = new Random();
    
    /**
     * Enum for desciption of points in posList
     */
    public enum Position {
    PosX,
    PosY
    }
    
    /**
     * Check if point XY is in circle 
     * @param posList list of pseudo-random points
     * @return number of points in circle
     */
    private long getNumberOfDotsInsideCircle(){
        long circleCount=0;
        for(Pair<Float,Float> positionXY : posList){
            if(positionXY.getKey()*positionXY.getKey()+positionXY.getValue()*positionXY.getValue()<=1){
                circleCount++;
            }
        }
        return circleCount;
    }
    
    /**
     * Calculate Pi using MonteCarlo method
     * @param accuracy count of guesses, higher=better
     * @return pi calculated using MonteCarlo
     * @throws CalculatedPiDiffersException exception when differs much from Math.Pi
     */
    public float calculatePi(long accuracy) throws CalculatedPiDiffersException{
        posList = new ArrayList<Pair<Float,Float>>();  
        float posX,posY;
        if(accuracy > 0){
            for(long i=1; i<=accuracy; i++){
                posX = (float)generator.nextInt(Integer.MAX_VALUE)/Integer.MAX_VALUE;
                posY = (float)generator.nextInt(Integer.MAX_VALUE)/Integer.MAX_VALUE;
                posList.add(new Pair(posX,posY));
            };

            float pi = 4 * (float)getNumberOfDotsInsideCircle()/accuracy;
            if((abs(pi - PI)) > (PI/100)){
                throw new CalculatedPiDiffersException("Pi: " + pi + " Difference: " + abs(pi - PI));
            }
            return pi;
        }
        return 0;
    }
    
    
    /**
     * Calculate Pi using MonteCarlo method [Deprecated]
     * @param accuracy count of guesses, hgher=better
     * @return pi calculated using MonteCarlo
     * @throws CalculatedPiDiffersException exception when differs much from Math.Pi
     */
    @Deprecated
    public float calculatePiDeprecated(long accuracy) throws CalculatedPiDiffersException{
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
