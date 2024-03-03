
import java.util.Scanner;

public class Calculator_II_V2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input:");
        String expressionWithQuotes = scanner.nextLine();

        String expressionWithoutGaps = expressionWithQuotes.replaceAll("\\s*(\\-|\\+|\\*|\\/)\\s*", "$1");
        String expressionWithoutQuotes = expressionWithoutGaps.replaceAll("\"", "");// Удаление кавычек

        String[] operators = {"-", "+", "/", "*"};
        String[] operators_for_split = {"\"-", "\\+", "/", "\\*"};

        int operator_index = -1;
        for (int i = 0; i < operators.length; i++) {
            if (expressionWithoutGaps.contains(operators[i])) {
                operator_index = i;
                break;
            }
        }
        if (operator_index == -1) {
            throw new IllegalArgumentException("т.к. оператор не найден в строке (+, -, /, *)");
        }

        String a, b;
        if(operator_index >= 1) {
            a = expressionWithoutQuotes.split(operators_for_split[operator_index])[0];
            b = expressionWithoutQuotes.split(operators_for_split[operator_index])[1];

        }else {
            a = expressionWithoutGaps.split(operators_for_split[operator_index])[0];
            b = expressionWithoutGaps.split(operators_for_split[operator_index])[1];
        }

        switch (operators[operator_index]) {
            case "-":
                perfomSubtraction( a, b);
                break;
            case "+":
                perfomAddition( a, b);
                break;
            case "/":
                perfomDivision( a, b);
                break;
            case "*":
                perfomMult( a, b);
                break;
            default:
                throw new IllegalArgumentException("т.к. строка не является операцией");
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    static void perfomSubtraction(String a, String b) {

        String aWithoutQuotes = a.replaceAll("\"", "");
//        String aWithoutGaps = aWithoutQuotes.replaceAll(" ", "");
        if ((aWithoutQuotes.length() <= 0) || (aWithoutQuotes.length() > 10)) {
            throw new IllegalArgumentException("т.к. первый операнд не в диопазоне 1-10");
        }
        String bWithoutQuotes = b.replaceAll("\"", "");
     //   String bWithoutGaps = bWithoutQuotes.replaceAll(" ", "");
        if ((bWithoutQuotes.length() <= 0) || (bWithoutQuotes.length() > 10)) {
            throw new IllegalArgumentException("т.к. второй операнд не в диопазоне 1-10");
        }
        String replacement = "";
        String wordToRemove = bWithoutQuotes;

        String finalResult = aWithoutQuotes.replaceFirst(wordToRemove, "");

        System.out.println("Output: " + "\"" + finalResult +"\"");
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    static void perfomAddition(String a, String b) {

        int numberString1 = a.length();
        int numberString2 = b.length();

        String finalResult = (a.substring(0,numberString1))+(b.substring(0,numberString2));

        System.out.println("Output: " + "\"" + finalResult +"\"");
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    static void perfomDivision(String a, String b) {
        int number = 0;
        if (a.matches(".*\\d.*")) {
            throw new IllegalArgumentException("т.к. первый оперант не строка");
        }
        if ((a.length() <= 0) || (a.length() > 10)) {
            throw new IllegalArgumentException("т.к. первый операнд не в диопазоне 1-10");
        }
        try {
            number = Integer.parseInt(b);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("т.к. используются недопустимая операция");
        }
        if ((number < 1) || (number > 10)) {
            throw new IllegalArgumentException("т.к. число не в диопазоне 1-10");
        }
        int numberString = 0;
        for(int i = 0; i < a.length(); i++) {
            numberString = i + 1;
        }
        int numberResult = numberString / number;
        String finalResult = (a.substring(0,numberResult));

        System.out.println("Output: " + "\"" + finalResult + "\"");
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////
    static void perfomMult(String a, String b) {
        int number = 0;

        if (a.matches(".*\\d.*")) {
            throw new IllegalArgumentException("т.к. первый оперант не строка");
        }
        if ((a.length() <= 0) || (a.length() > 10)) {
            throw new IllegalArgumentException("т.к. первый операнд не в диопазоне 1-10");
        }
        try {
            number = Integer.parseInt(b);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("т.к. используются недопустимая операция");
        }
        if ((number < 1) || (number > 10)) {
            throw new IllegalArgumentException("т.к. число не в диопазоне 1-10");
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < number; i++ ) {
            result.append(a);
        }
        String finalResult = result.toString();
        if(finalResult.length() > 40) {
            finalResult = finalResult.substring(0, 40) + "...";
        }
        System.out.println("Output: " + "\"" + finalResult + "\"");
    }
}
