/**
 * Containing input data and calculation result for the calculator
 */


package com.github.iot1009.midterm_calculator;

public class Data {
    private static String expression;

    // init expression string. Setting it to empty at the start
    public static void InitData() {
        expression = "";
    }

    public static String getExpression() {
        return expression;
    }
    public static void setExpression(String symbol) {
        expression = expression + symbol;
    }

    // set expression string to empty
    public static void clearExpression() {
        expression = "";
    }
}
