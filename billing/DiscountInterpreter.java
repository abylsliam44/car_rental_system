package billing;

import java.util.Stack;

public class DiscountInterpreter {
    // Интерпретатор для вычисления сложных скидок на основе выражений
    public double interpret(String expression) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        
        for (String token : tokens) {
            if (isOperator(token)) {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(applyOperator(token, a, b));
            } else {
                stack.push(Double.parseDouble(token));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private double applyOperator(String operator, double a, double b) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b != 0) {
                    return a / b;
                } else {
                    throw new IllegalArgumentException("Cannot divide by zero.");
                }
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
