import java.util.Scanner;

public class Main {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        Input obj = new Input();
        boolean run = true;
        int choice;
        while (run) {
            System.out.println();
            System.out.print("""
                    Выберите задание:
                        1 - Задание 1. Сущность Имя
                        2 - Задание 2. Сущность Человек
                        3 - Задание 3. Сущность Город
                        4 - Задание 4. Сущность Кот
                        0 - Выход
                      """);
            choice = obj.readInt(sc, ">> ");
            switch (choice) {
                case 1:
                    testName(sc, obj);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    System.out.println("Неверный пункт меню. Попробуйте снова.");
                    break;
            }

        }

    }

    private static void testName(Scanner sc, Input obj) {
        System.out.println("\nТест класса Имя");
        String first = obj.readString(sc, "Введите Личное имя: ", false);
        String last = obj.readString(sc, "Введите Фамилию (или '-' для пропуска): ", true);
        
        if (last.isEmpty())
            last = null;

        String surname = obj.readString(sc, "Введите Отчество (или '-' для пропуска): ", true);
        if (surname.isEmpty())
            surname = null;

        Name n = new Name(first, last, surname);
        System.out.println("Результат: " + n);
    }

}
