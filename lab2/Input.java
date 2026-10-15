import java.util.Scanner;
public class Input {
    public int readInt(Scanner sc, String p) {
        while (true) {
            System.out.print(p);
            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                sc.nextLine();
                return value;
            } else {
                System.out.println("Ошибка! Введите целое число.");
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
                System.out.println("\u001B[31mОшибка: параметр не может быть пустым.\u001B[0m");
                continue;
            }
            return name;
        }
    }
}
