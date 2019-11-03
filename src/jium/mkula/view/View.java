/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jium.mkula.view;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import jium.mkula.model.Model;
import jium.mkula.model.Model.Position;

/**
 * Console view for Pi_MonteCarlo
 * @author Mateusz Kula {matekul734@student.polsl.pl}
 * @version 1.0.2
 */
public class View {
    
    /**
     * Show custom message
     * @param msg message to show
     */
    public void showMsg(String msg){
        System.out.print(msg);       
    }
    
    /**
     * Show accuracy query to user
     */
    public void showAccuracyQuery(){
        System.out.print("Podaj ilosc punktów do wylosowania (0 aby wyjsc)\n");       
    }
    
    /**
     * Clear console
     */
    public void clearConsole(){
        try{
            Runtime.getRuntime().exec("cls");            
        }catch(IOException ex){
            Logger.getLogger(View.class.getName()).log(Level.FINE, null, ex);  
        }
    }
    
    /**
     * Show all pseudo-random points 
     * @param posList list of psuedo-random points
     */
    public void showAllPsRandomPoints(List<Pair<Float,Float>> posList){
        Model.Position key = Position.PosX;    
        Model.Position value = Position.PosY;

        System.out.println(key +","+ value);
        posList.forEach(n -> System.out.println(n.getKey() + "," + n.getValue() + "\n"));        
    }

}
