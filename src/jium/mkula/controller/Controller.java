/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jium.mkula.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import jium.mkula.model.CalculatedPiDiffersException;
import jium.mkula.model.Model;
import jium.mkula.view.View;

/**
 * Controller for PiMonteCarlo
 * @author Mateusz Kula {matekul734@student.polsl.pl}
 * @version 1.0.2
 */
public class Controller {
    View view;
    Model model;
    public Controller(){
        view = new View();
        model = new Model();
    }
    
    /**
     * Get number from user, larger=better
     * @return number of guesses, larger=better
     */
    private long getAccuracy(){
        long accuracyInput = 0;
        String userInput = "";
        view.showAccuracyQuery();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try{
            userInput = in.readLine();
        }catch(IOException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.FINE, null, ex);            
        }
        try{            
            accuracyInput = Long.parseLong(userInput);
        }catch(NumberFormatException nfe){
            accuracyInput = 0;
            Logger.getLogger(Controller.class.getName()).log(Level.FINE, null, nfe);
        }	
        return accuracyInput;
    }
    
    /**
     * Run without args
     */
    public void run(){
        long temp = getAccuracy();
        do{
            view.clearConsole();
            if(temp != 0){
                try {
                    view.showMsg("Pi: " + model.calculatePi(temp) + "\n");
                } catch (CalculatedPiDiffersException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.FINE, null, ex);
                    view.showMsg(ex.getMessage());
                }
                temp = getAccuracy();
            }
        }while(temp != 0);
    }
    
    /**
     * Run with args
     * @param args command line args
     */
    public void runWithParams(String[] args){
        if(args[0].contains("-c")){
            if(args[1].length() > 0){
                long accuracy;
                try{            
                    accuracy = Long.parseLong(args[1]);
                }catch(NumberFormatException nfe){
                    accuracy = 0;
                    Logger.getLogger(Controller.class.getName()).log(Level.FINE, null, nfe);
                }	
                try {
                    view.showMsg("Pi: " + model.calculatePi(accuracy) + "\n");
                } catch (CalculatedPiDiffersException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
