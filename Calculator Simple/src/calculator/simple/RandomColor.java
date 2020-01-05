/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.simple;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
public class RandomColor {
   static int number=0;
public Paint getColor()
{
    number++;
    (number)%=7;
    switch (number){
        case 0: return Color.DARKVIOLET;
        case 1: return Color.BLUE;
        case 2: return Color.BROWN;
        case 4: return Color.GREEN;
        case 5: return  Color.PINK;
        case 6: return Color.ORANGE;
        case 7: return Color.RED;
        default: return Color.WHITE;
    }
    
}
}
