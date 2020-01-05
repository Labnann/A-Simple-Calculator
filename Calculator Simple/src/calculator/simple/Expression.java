/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.simple;

import stringmanupulation.Manupulation;
//import sun.security.util.Length;


public class Expression {

    String expression;

    //  String result;
    simpleUnit termCalculator = new simpleUnit();

    public String getResult() {
        return termCalculator.getResult();
    }

    public void setExpression(String expression) {
        this.expression = "(" + expression + ")";
    }

    public void calculate() {
        // while(keepSimplifying());
        
//        for(int i=0;i<7;i++){
//            calculateOperator(expression);
//        }
        keepSimplifying();
    }

    private void keepSimplifying() {
       // calculateOperator(expression);
        System.out.println(expression);
        String shortenedExpression;
        int rightBracePosition = findRightBrace();
        if (rightBracePosition == -1) {
            return;
        }

        int leftBracePosition = findOppositeBrace(rightBracePosition);
        if (leftBracePosition != -1) {
            shortenedExpression = Manupulation.cutFromString(expression, leftBracePosition + 1, rightBracePosition - 1);
            expression = Manupulation.removeFromString(expression, leftBracePosition, rightBracePosition);
            termCalculator.calculateTerms(shortenedExpression);
            shortenedExpression = termCalculator.getResult();
            expression = Manupulation.addToString(expression, shortenedExpression, leftBracePosition - 1);
        } else {
            return;
        }
        keepSimplifying();

        //   return true;
    }

    private int findRightBrace() {
        char[] expressionArray = expression.toCharArray();
        for (int i = 0; i < expression.length(); i++) {
            if (expressionArray[i] == ')') {
                return i;
            }
        }
        return -1;
    }

    private int findOppositeBrace(int rightBracePosition) {
        char[] expressionArray = expression.toCharArray();
        for (int i = rightBracePosition; i >= 0; i--) {
            if (expressionArray[i] == '(') {
                return i;
            }
        }
        return -1;
    }
}