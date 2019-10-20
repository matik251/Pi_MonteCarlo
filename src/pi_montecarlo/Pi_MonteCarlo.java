/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_montecarlo;

import jium.mkula.controller.Controller;

/**
 * Simple Java calculatof for PI using Monte Carlo random method
 * @author MATIK
 * @version 1.0.0
 */
public class Pi_MonteCarlo {
    /**
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
            controller.Run();
        }else{
            controller.RunWithParams(args);
        }
    }
    
}
