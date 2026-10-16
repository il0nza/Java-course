import java.util.Scanner;

public class Main {
    public static void main() {
        Scanner sc = new Scanner(System.in, "Cp866");
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
            choice = obj.readInt(sc, ">> ", 0, 4);
            switch (choice) {
                case 1:
                    testName(sc, obj);
                    break;
                case 2:
                    testPerson(sc, obj);
                    break;
                case 3:
                    testCity(sc, obj);
                    break;
                case 4:
                    testCat(sc, obj);
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
        int count = obj.readInt(sc, "Сколько имен вы хотите добавить? ", 1, 10);
        if (count <= 0)
            return;
        Name[] names = new Name[count];
        for (int i = 0; i < count; i++) {
            System.out.println("\nВвод данных для имени #" + (i + 1));
            String first = obj.readString(sc, "Введите Личное имя: ", false);
            String last = obj.readString(sc, "Введите Фамилию (или '-' для пропуска): ", true);

            if (last.isEmpty())
                last = null;

            String surname = obj.readString(sc, "Введите Отчество (или '-' для пропуска): ", true);
            if (surname.isEmpty())
                surname = null;
            names[i] = new Name(first, last, surname);
        }

        System.out.println("\nСписок всех введенных имен:");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }

    private static void testPerson(Scanner sc, Input obj) {
        System.out.println("\nТест класса Человек");

        int count = obj.readInt(sc, "Сколько людей вы хотите добавить? ", 1, 10);
        if (count <= 0)
            return;

        Person[] people = new Person[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nВвод данных для человека #" + (i + 1));
            String first = obj.readString(sc, "Введите Личное имя: ", false);
            String last = obj.readString(sc, "Введите Фамилию (или '-' для пропуска): ", true);
            if (last.isEmpty())
                last = null;

            String surname = obj.readString(sc, "Введите Отчество (или '-' для пропуска): ", true);
            if (surname.isEmpty())
                surname = null;

            Name personName = new Name(first, last, surname);
            int height = obj.readInt(sc, "Введите рост (в см): ", 10, 300);
            Person selectedFather = null;

            if (i > 0) {
                System.out.println("\nДоступные отцы из ранее введенных:");
                System.out.println("0 - Нет отца (или пропустить)");
                for (int j = 0; j < i; j++) {
                    System.out.println((j + 1) + " - " + people[j]);
                }

                int fatherChoice = obj.readInt(sc, "Выберите номер отца для этого человека: ", 0, i);

                if (fatherChoice > 0 && fatherChoice <= i) {
                    selectedFather = people[fatherChoice - 1];
                }
            }
            people[i] = new Person(personName, height, selectedFather);
            System.out.println("Успешно создано: " + people[i]);
        }

        System.out.println("\nИтоговый список всех созданных людей:");
        for (int i = 0; i < people.length; i++) {
            System.out.println((i + 1) + ". " + people[i]);
        }
    }

    private static void testCity(Scanner sc, Input obj) {
        System.out.println("\nТест класса Город");
        City[] cities = new City[6];
        cities[0] = new City("A");
        cities[1] = new City("B");
        cities[2] = new City("C");
        cities[3] = new City("D");
        cities[4] = new City("E");
        cities[5] = new City("F");

        System.out.println("Города созданы: A, B, C, D, E, F.");

        while (true) {
            System.out.println("\nТекущее состояние городов:");
            for (int i = 0; i < cities.length; i++) {
                System.out.println((i + 1) + ". " + cities[i]);
            }

            System.out.println("\n0. Закончить ввод дорог и выйти в главное меню");
            int fromChoice = obj.readInt(sc, "Выберите номер города ОТКУДА идет дорога (1-6): ", 0, 6);

            if (fromChoice == 0)
                break;

            int toChoice = obj.readInt(sc, "Выберите номер города КУДА идет дорога (1-6): ", 1, 6);
            int cost = obj.readInt(sc, "Введите стоимость пути (от 0 до 1000): ", 0, 1000);

            City fromCity = cities[fromChoice - 1];
            City toCity = cities[toChoice - 1];

            fromCity.addPath(toCity, cost);
            System.out.println("Дорога от " + fromCity.getName() + " до " + toCity.getName() + " со стоимостью " + cost
                    + " успешно добавлена!");
        }
    }

    private static void testCat(Scanner sc, Input obj) {
        System.out.println("\n Тест класса Кот");
        String catName = obj.readString(sc, "Как зовут кота?: ", false);
        Cat cat = new Cat(catName);
        System.out.println("\nСоздан объект: " + cat);
        
        System.out.print("\nОдиночное мяуканье: ");
        cat.meow();

        int meowCount = obj.readInt(sc, "\nСколько раз коту помяукать? (от 1 до 20): ", 1, 20);        
        cat.meow(meowCount);
    }
}
