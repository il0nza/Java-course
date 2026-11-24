import java.util.Scanner;

public class Main {
    public static void main() {
        Scanner sc = new Scanner(System.in, "Cp866");
        Input input = new Input();
        boolean run = true;
        int choice, choice_m;
        while (run) {
            System.out.println();
            System.out.print("""
                    Выберите задание:
                        1 - Задание 1.
                        2 - Задание 2. Секреты.
                        3 - Задание 3. Трехмерная точка.
                        4 - Задание 4. Фигуры.
                        5 - Задание 5. Мяуканье.
                        6 - Задание 6. Сравнение точек.
                        7 - Задание 7.
                        8 - Задание 8. Клонирование линии.
                        0 - Выход
                      """);
            choice = input.readInt(sc, "Ваш выбор: ", 0, 8);
            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.print("""
                            Выберите задачу:
                                1 - Задача 1.7 Непустые Имена
                                2 - Задача 1.8 Человек меняется
                              """);
                    choice_m = input.readInt(sc, "Ваш выбор: ", 1, 2);
                    switch (choice_m) {
                        case 1:
                            System.out.println("\nАвтоматический тест исключения: попытка создания имени с null: ");
                            try {
                                Name badName = new Name("", null, "");
                            } catch (IllegalArgumentException e) {
                                System.out.println("Поймана ожидаемая ошибка: " + e.getMessage());
                            }

                            testName(sc, input);
                            break;
                        case 2:
                            testPerson(sc, input);
                            break;
                        default:
                            System.out.println("Неверный пункт меню");
                            break;
                    }
                    break;
                case 2:
                    testSecret(sc, input);
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

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

    private static void testName(Scanner sc, Input input) {
        System.out.println("\n Тест класса Имя");
        int count = input.readInt(sc, "Сколько имен вы хотите добавить? ", 1, 10);
        Name[] names = new Name[count];

        for (int i = 0; i < count; i++) {
            while (true) {
                System.out.println("\nВвод имени #" + (i + 1)
                        + " (введите '-' во всех полях, чтобы проверить выброс исключения):");
                String first = input.readString(sc, "Личное имя (или '-'): ", true);
                String last = input.readString(sc, "Фамилия (или '-'): ", true);
                String surname = input.readString(sc, "Отчество (или '-'): ", true);

                try {
                    names[i] = new Name(first, last, surname);
                    System.out.println("Создано: " + names[i]);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Перехвачено исключение: " + e.getMessage() + " Попробуйте снова.");
                }
            }
        }

        System.out.println("\nИтоговый список имен:");
        for (Name n : names) {
            System.out.println("- " + n);
        }
    }

    private static void testPerson(Scanner sc, Input input) {
        System.out.println("\nТест класса Человек");
        int count = input.readInt(sc, "Сколько людей вы хотите добавить? ", 1, 10);
        Person[] people = new Person[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nВвод данных для человека #" + (i + 1));
            String first = input.readString(sc, "Личное имя: ", false);
            String last = input.readString(sc, "Фамилия (или '-'): ", true);
            String surname = input.readString(sc, "Отчество (или '-'): ", true);
            Name personName = new Name(first, last, surname);

            Person selectedFather = null;
            if (i > 0) {
                System.out.println("\nВыберите отца из ранее созданных:");
                System.out.println("0 - Нет отца");
                for (int j = 0; j < i; j++) {
                    System.out.println((j + 1) + " - " + people[j]);
                }
                int fatherChoice = input.readInt(sc, "Номер отца: ", 0, i);
                if (fatherChoice > 0) {
                    selectedFather = people[fatherChoice - 1];
                }
            }

            while (true) {
                int height = input.readInt(sc, "Рост: ");
                try {
                    people[i] = new Person(personName, height, selectedFather);
                    System.out.println("Успешно создано: " + people[i]);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Перехвачено исключение: " + e.getMessage() + ". Попробуйте ввести рост снова.");
                }
            }
        }
        System.out.println("\nПроверка геттеров getName() и getFather():");
        for (Person p : people) {
            String fatherName = (p.getFather() != null) ? p.getFather().getName().toString() : "не указан";
            System.out.println("Человек: " + p + " | Объект Name: " + p.getName() + " | Отец: " + fatherName);
        }

        System.out
                .println("\nПроверка изменения роста (setHeight) для первого человека (" + people[0].getName() + "):");
        while (true) {
            int newHeight = input.readInt(sc, "Введите новый рост: ");
            try {
                people[0].setHeight(newHeight);
                System.out.println("Рост успешно обновлен: " + people[0]);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Перехвачено исключение при изменении роста: " + e.getMessage());
            }
        }
    }

    private static void testSecret(Scanner sc, Input input) {
        System.out.println("\nТест класса Секрет");
        int count = input.readInt(sc, "Сколько человек будет в цепочке секрета (от 2 до 10)? ", 2, 10);
        Secret[] chain = new Secret[count];

        // создание исходного секрета
        String firstName = input.readString(sc, "Введите имя создателя секрета: ", false);
        String text = input.readText(sc, "Введите текст секрета: ");
        chain[0] = new Secret(firstName, text);
        System.out.println(chain[0]);

        // передача секрета по цепочке
        for (int i = 1; i < count; i++) {
            String nextName = input.readString(sc,
                    "\nВведите имя " + (i + 1) + "-го хранителя, которому передадут секрет: ", false);
            System.out.print("Процесс передачи: ");
            chain[i] = new Secret(chain[i - 1], nextName);
            System.out.println(chain[i]);
        }

        // проверка запрета на повторную передачу секрета
        System.out.println("\nПопытка рассказать секрет второму человеку:");
        try {
            System.out.println("Пробуем передать секрет от " + chain[0] + " еще одному человеку");
            Secret duplicate = new Secret(chain[0], "Шпион");
        } catch (IllegalStateException e) {
            System.out.println("Поймана ошибка: " + e.getMessage());
        }

        // проверка методов навигации для выбранного хранителя
        System.out.println("\nПроверка информации по цепочке");
        int index = input.readInt(sc, "Выберите номер хранителя для проверки (от 1 до " + count + "): ", 1, count) - 1;
        Secret selected = chain[index];

        System.out.println("Выбран: " + selected);
        System.out.println("Каким по очереди узнал секрет: " + selected.getOrder());
        System.out.println("Сколько человек узнали после него: " + selected.getPeopleAfterCount());

        int shift = input.readInt(sc, "Введите сдвиг N (например, 1 — следующий, -1 — предыдущий): ");
        try {
            System.out.println("Имя N-го хранителя: " + selected.getNKeeperName(shift));
            System.out.println("Разница в длине текста с N-ым хранителем: " + selected.getLengthDifference(shift));
        } catch (IllegalArgumentException e) {
            System.out.println("Поймана ошибка при поиске: " + e.getMessage());
        }
    }
}
