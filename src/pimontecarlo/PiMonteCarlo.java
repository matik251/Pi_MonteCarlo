/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pimontecarlo;

import jium.mkula.controller.Controller;

/**
 * Simple Java calculatof for PI using Monte Carlo random method
 * @author Mateusz Kula {matekul734@student.polsl.pl}
 * @version 1.0.2
 */
public class PiMonteCarlo {
    /**
     * @author Mateusz Kula {matekul734 at student.polsl.pl}
     * @param args the command line arguments
     * args[0] -c    
     * args[1] number of guesses 
     */
    
    /**
     * Run program
     * @param args -c  nubmer
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        if(args.length == 0){
            controller.run();
        }else{
            controller.runWithParams(args);
        }
    }
    
}
