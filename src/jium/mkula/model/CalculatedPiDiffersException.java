/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jium.mkula.model;

/**
 * Exception class for Pi_MonteCarlo
 * @author Mateusz Kula {matekul734@student.polsl.pl}
 * @version 1.0.2
 */
public class CalculatedPiDiffersException extends Exception { 
    
    /**
    * Exception for sygnalizing huge difference in result
    * @param errorMessage message describing exception
    */
    public CalculatedPiDiffersException(String errorMessage) {
        super(errorMessage);
    }

}
