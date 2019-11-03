/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jium.mkula.model.test;

import jium.mkula.model.CalculatedPiDiffersException;
import jium.mkula.model.Model;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.rules.ExpectedException;

/**
 * Test case for model of PiMonteCarlo
 * @author Mateusz Kula {matekul734 at student.polsl.pl}
 * @version 1.0.2
 */
public class ModelTest {
    
    Model model;
     
    @Before
    public void setup(){
        model = new Model();
    }
    
    /**
     * Test for calculatePiTest checking its results depending on number of points in parameter
     */
    @Test
    public void calculatePiTest(){
        float result = 0;
        try{
            result = model.calculatePi(0);
            assertEquals("No points, result = 0", result, (float)0, 0.01);
        }catch(CalculatedPiDiffersException e){
        }
        
        try{
            result = model.calculatePi(-100);
            assertEquals("Negative nubmer of points, result = 0", result, (float)0, 0.01);
        }catch(CalculatedPiDiffersException e){
        }
        
        try{
            result = model.calculatePi(1);
            fail("Exception should be thrown when number of points is not sufficient");
        }catch(CalculatedPiDiffersException e){
        }
        
        try{
            result = model.calculatePi(10000);
            assertEquals("100 points, result bad Pi", result, (float)3, 0.2);
        }catch(CalculatedPiDiffersException e){
        }
    }
    
    /**
     * Test for CalculatedPiDiffersException checking if the exception is thrown, and its message
     */
    @Test
    public void calculatedPiDiffersExceptionTest(){
        float result = 0;
        try {
            result = model.calculatePi(1);
            fail("An exception should be thrown with low amount of points");
        } catch (CalculatedPiDiffersException e) {
            assertEquals("Balance shouldn't be changed!", result, (float)0, 10);
            assertTrue("Message!", e.getMessage().contains("Difference:"));
        }
    }    
}
