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
public class Manupulation {

    public static String charArrayToString(char[] character, int start, int end) {
     //   System.out.print("charArrayToString:: "+start);
        String string = "";
        for (; start <= end; start++) {
            string += character[start];
        }
      //  System.out.print(" " + string + " "  + " " + " " + end+" ");
     //   System.out.println(character);
        return string;
    }

    public static String cutFromString(String string, int leftPosition, int rightPosition) {
        if (leftPosition > rightPosition) {
          //  System.out.println("Left position is greater than right");
            return "";
        }
        if (!(string.length() > rightPosition)) {
          //  System.out.println("Right Position value problem");
            return "";
        }
        char[] stringArray = string.toCharArray();
        String newString = "";

        for (int i = leftPosition; i <= rightPosition; i++) {
            newString = newString + stringArray[i];
        }
        return newString;
    }

    public static String addToString(String oldString, String addingPart, int atIndex) {
        String newString;
        newString = addingPart + cutFromString(oldString, atIndex + 1, oldString.length() - 1);
        newString = cutFromString(oldString, 0, atIndex) + newString;
        return newString;
    }

    public static String removeFromString(String oldString, int leftPosition, int rightPosition) {
        String newString;
        newString = cutFromString(oldString, 0, leftPosition - 1)
                + cutFromString(oldString, rightPosition + 1, oldString.length() - 1);
        return newString;
    }
}
