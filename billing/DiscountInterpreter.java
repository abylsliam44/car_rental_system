package billing;

import java.util.Stack;

public class DiscountInterpreter {

    
    public double interpret(String expression) {
        Stack<Double> values = new Stack<>();   
        Stack<Character> operators = new Stack<>(); 

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);


            if (ch == ' ') continue;

            
            if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder();

                
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                i--; 
                values.push(Double.parseDouble(sb.toString()));
            }
            
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                
                while (!operators.isEmpty() && hasPrecedence(ch, operators.peek())) {
                    values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
                }
                
                operators.push(ch);
            }
        }

        
        while (!operators.isEmpty()) {
            values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
        }

        
        return values.pop();
    }

    
    private boolean hasPrecedence(char op1, char op2) {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    
    private double applyOperation(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Cannot divide by zero");
                return a / b;
            default:
                throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }
}
