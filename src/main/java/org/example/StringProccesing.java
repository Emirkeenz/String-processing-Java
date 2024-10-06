package org.example;
import java.util.Stack;

public class StringProccesing {
    public boolean isStrongPassword(String password) {
        if (password.length() < 8 || password == null) return false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowerCase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecialChar = true;
            }
        }

        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }

    public int calculateDigits(String sentence) {
        int amountOfDigits = 0;
        if (sentence != null) {
            for (char ch : sentence.toCharArray()) {
                if (Character.isDigit(ch)) {
                    amountOfDigits++;
                }
            }
        }
        return amountOfDigits;
    }

    public int calculateWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) return 0;
        int amountOfWords = 0;
        boolean isWord = false;

        for (int i = 0; i < sentence.length(); i++) {
            char currentChar = sentence.charAt(i);

            // Если символ не пробел, то это часть слова
            if (!Character.isWhitespace(currentChar)) {
                if (!isWord) {
                    amountOfWords++;  // Начало нового слова
                    isWord = true;
                }
            } else {
                // Если символ пробел, это конец слова
                isWord = false;
            }
        }
        return amountOfWords;
    }

    public int calculateExpression(String expression) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // Skip spaces
            if (ch == ' ') continue;

            // If the character is a digit, read the full number and push to the operand stack
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + Character.getNumericValue(expression.charAt(i));
                    i++;
                }
                i--; // Adjust index after inner loop
                operands.push(num);
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    operands.push(applyOperation(operators.pop(), operands.pop(), operands.pop()));
                }
                operators.pop(); // Remove '(' from operators stack
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operators.isEmpty() && hasPrecedence(ch, operators.peek())) {
                    operands.push(applyOperation(operators.pop(), operands.pop(), operands.pop()));
                }
                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            operands.push(applyOperation(operators.pop(), operands.pop(), operands.pop()));
        }

        return operands.pop();
    }

    // Helper method to check precedence of operators
    private boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false;
        return true;
    }

    // Helper method to apply an operation on two operands
    private int applyOperation(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': if (b == 0) throw new ArithmeticException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }
}
