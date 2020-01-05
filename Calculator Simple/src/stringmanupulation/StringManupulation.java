/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringmanupulation;

/**
 *
 * @author Labnan
 */
public class StringManupulation {

    /**
     * @param args the command line arguments
     */
       public static void main(String[] args) {
       
      String s = "0123456789",t;
      t=Manupulation.cutFromString(s, 2, 7);
           System.out.println(t);
        
    }
    
}
