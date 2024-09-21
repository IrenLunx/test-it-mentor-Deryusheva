package src;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char[] operations = {'*', '/', '-', '+'};
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();

        while (true) {
            System.out.println("Введите арифметическое выражение (числа от 1 до 10 включительно)");
            System.out.println(
                    "Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами");

            String input = scanner.nextLine();
            CharactersInfo charactersInfo = new CharactersInfo(operations, input);

            if (charactersInfo.getCountOperations() == 1) {
                char operation = charactersInfo.getExistingChar();

                input = input.replaceAll("\\s","");
                String[] values = input.split("\\" + operation);

                for (String s : values) {
                    if (Integer.parseInt(s) > 10 || Integer.parseInt(s) < 1) {
                        try {
                            throw new IOException();
                        } catch (IOException e) {
                            System.out.println("Числа не соотвествует заданному диапазону (1 - 10)");
                            throw new RuntimeException(e);
                        }
                    }
                }

                switch (operation) {
                    case '*' -> System.out.println(arithmeticOperations.multiplication
                            (Integer.parseInt(values[0]), Integer.parseInt(values[1])));
                    case '/' -> System.out.println(arithmeticOperations.division
                            (Integer.parseInt(values[0]), Integer.parseInt(values[1])));
                    case '-' -> System.out.println(arithmeticOperations.subtraction
                            (Integer.parseInt(values[0]), Integer.parseInt(values[1])));
                    case '+' -> System.out.println(arithmeticOperations.addition
                            (Integer.parseInt(values[0]), Integer.parseInt(values[1])));
                }
            }
            else {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println
                            ("Неверный формат математической операции - два операнда и один оператор (+, -, /, *)");
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
