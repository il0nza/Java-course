package ru.gachegova.utils;
import java.util.Scanner;

public class Input {
    public int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                sc.nextLine();
                return value;
            } else {
                System.out.println("Ошибка: введите целое число.");
                sc.next();
            }
        }
    }

    public int readInt(Scanner sc, String prompt, int min, int max) {
        while (true) {
            int value = readInt(sc, prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Ошибка: число должно быть в диапазоне от " + min + " до " + max);
        }
    }

    
    public String readString(Scanner sc, String prompt, boolean canBeEmpty) {
        while (true) {
            System.out.print(prompt);
            String text = sc.nextLine().trim();

            if (text.equals("-") || text.isEmpty()) {
                if (canBeEmpty) {
                    return "";
                } else {
                    System.out.println("Ошибка: параметр не может быть пустым.");
                    continue;
                }
            }

            boolean hasDigits = false;
            for (char c : text.toCharArray()) {
                if (Character.isDigit(c)) {
                    hasDigits = true;
                    break;
                }
            }

            if (hasDigits) {
                System.out.println("Ошибка: в этом поле не должно быть цифр!");
            } else {
                return text;
            }
        }
    }

    public String readText(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public double readDouble(Scanner sc, String prompt) {
    while (true) {
        System.out.print(prompt);
        if (sc.hasNextDouble()) {
            double value = sc.nextDouble();
            sc.nextLine();
            return value;
        } else {
            System.out.println("Ошибка: введите число (например, 5 или 3.5).");
            sc.next();
        }
    }
}
}