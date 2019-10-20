/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jium.mkula.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Console view for Pi_MonteCarlo
 * @author MATIK
 * @version 1.0.0
 */
public class View {
    
    /**
     * Show custom message
     * @param msg message to show
     */
    public void ShowMsg(String msg){
        System.out.print(msg);       
    }
    
    /**
     * Show accuracy query to user
     */
    public void ShowAccuracyQuery(){
        System.out.print("Podaj ilosc punktów do wylosowania (0 aby wyjsc)\n");       
    }
    
    /**
     * Clear console
     */
    public void ClearConsole(){
        try{
            Runtime.getRuntime().exec("cls");            
        }catch(IOException ex){
            Logger.getLogger(View.class.getName()).log(Level.FINE, null, ex);  
        }
    }

}
