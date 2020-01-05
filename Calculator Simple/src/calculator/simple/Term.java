/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.simple;

/**
 *
 * @author Labnan
 */
public class Term {

    String stringValue;
    char operator;

    private double numberValue;

    public Term(char operator) {
        if ((operator == '+') || (operator == '-')) {
            this.operator = operator;
        }
    }

    public void setStringValue(String stringValue) {
        this.stringValue = "*" + stringValue + "*";
        //       System.out.println("Set stringValue: "+stringValue);
    }

    public Term() {
    }

    void operate() {
        char[] charValue = stringValue.toCharArray();
        int scanStart = 0;
        double sum = 1;

      //  System.out.print("Operate:: " + " ");
      //  System.out.println(charValue);
        for (int i = 0; i < charValue.length; i++) {
            if (((charValue[i] == '*') || (charValue[i] == '/')) && (i != 0)) {
                if (charValue[scanStart] == '*') {
                    String number = (charArrayToString(charValue, scanStart + 1, i - 1));
                    if (number != "") {
                        sum *= Double.valueOf(number);
                    }
                    scanStart = i;
                } else if (charValue[scanStart] == '/') {
                    sum /= Double.valueOf(charArrayToString(charValue, scanStart + 1, i - 1));
                    scanStart = i;
                }
            }
        }
        if (operator == '+') {
            numberValue = sum;
        } else {
            numberValue = -sum;
        }

    }

    public double getNumberValue() {
        return numberValue;
    }

    private String charArrayToString(char[] character, int start, int end) {
        String string = "";
        for (; start <= end; start++) {
            string += character[start];
        }
        //  System.out.println("calculator.simple.Term.charArrayToString()"+string);
        return string;
    }

}
