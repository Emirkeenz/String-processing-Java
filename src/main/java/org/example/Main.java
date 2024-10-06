package org.example;

public class Main {
    public static void main(String[] args) {
        StringProccesing processor = new StringProccesing();

        // Проверка метода isStrongPassword
        String password = "Abcdef@1";
        System.out.println("Is the password '" + password + "' strong? " + processor.isStrongPassword(password));

        // Проверка метода calculateDigits
        String sentenceWithDigits = "Hello123 World456";
        System.out.println("Number of digits in the sentence '" + sentenceWithDigits + "': " + processor.calculateDigits(sentenceWithDigits));

        // Проверка метода calculateWords
        String sentenceWithWords = "This is a simple test.";
        System.out.println("Number of words in the sentence '" + sentenceWithWords + "': " + processor.calculateWords(sentenceWithWords));

        // Проверка метода evaluateExpression
        String expression = "2+3*(4-1)";
        System.out.println("The result of the expression '" + expression + "' is: " + processor.calculateExpression(expression));
    }
}