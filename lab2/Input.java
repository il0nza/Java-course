import java.util.Scanner;

public class Input {
    public int readInt(Scanner sc, String p, int min, int max) {
        while (true) {
            System.out.print(p);
            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                sc.nextLine();
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Ошибка: число должно быть в диапазоне от " + min + " до " + max);
                }
            } else {
                System.out.println("Ошибка: введите целое число.");
                sc.next();
            }
        }
    }

    public String readString(Scanner sc, String prompt, boolean canBeEmpty) {
        while (true) {
            System.out.print(prompt);
            String name = sc.nextLine();

            if (name.equals("-") && canBeEmpty) {
                return "";
            }

            else if ((name.equals("-") || name.isEmpty()) && !canBeEmpty) {
                System.out.println("Ошибка: параметр не может быть пустым");
                continue;
            }

            boolean hasDigits = false;
            for (char c : name.toCharArray()) {
                if (Character.isDigit(c)) {
                    hasDigits = true;
                    break;
                }
            }
            if (hasDigits) {
                System.out.println("Ошибка: в параметре не должно быть цифр!");
                
            } else {
                return name;
            }
        }
    }
}
