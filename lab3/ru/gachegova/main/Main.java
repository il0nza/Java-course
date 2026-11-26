package ru.gachegova.main;

import java.util.Scanner;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

import ru.gachegova.bird.Bird;
import ru.gachegova.bird.Cuckoo;
import ru.gachegova.bird.Parrot;
import ru.gachegova.bird.Sparrow;
import ru.gachegova.cat.Cat;
import ru.gachegova.cat.Meowable;
import ru.gachegova.cat.RoboCat;
import ru.gachegova.geometry.Point;
import ru.gachegova.geometry.Point3D;
import ru.gachegova.people.Name;
import ru.gachegova.people.Person;
import ru.gachegova.secret.Secret;
import ru.gachegova.utils.Input;

public class Main {
    // задача 7.3
    public static double powerFromStrings(String xStr, String yStr) {
        int x = parseInt(xStr.trim());
        int y = parseInt(yStr.trim());
        return pow(x, y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Cp866");
        Input input = new Input();
        boolean run = true;
        int choice, choice_m;

        if (args.length >= 2) {
            System.out.println("Возведение в степень из аргументов командной строки");
            try {
                double res = powerFromStrings(args[0], args[1]);
                System.out.println(args + " в степени " + args + " = " + res);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: аргументы командной строки должны быть целыми числами!");
            }
        }

        while (run) {
            System.out.println();
            System.out.print("""
                    Выберите задание:
                        1 - Задание 1.
                        2 - Задание 2. Секреты.
                        3 - Задание 3. Трехмерная точка.
                        4 - Задание 4. Птицы.
                        5 - Задание 5. Мяуканье.
                        6 - Задание 6. Сравнение точек.
                        7 - Задание 8. Клонирование точки.
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
                            System.out.println("\nАвтоматический тест: попытка создания имени с null: ");
                            try {
                                Name badName = new Name("", null, "");
                            } catch (IllegalArgumentException e) {
                                System.out.println("Поймана ошибка: " + e.getMessage());
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
                    testPoint3D(sc, input);
                    break;
                case 4:
                    testBirds(sc, input);
                    break;
                case 5:
                    testMeow(sc, input);
                    break;
                case 6:
                    testPointEquals(sc, input);
                    break;
                case 7:
                    testPointClone(sc, input);
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

    //задача 1.7
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

    //задача 1.8
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

    //задача 2.2
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

    //задача 3ю5
    private static void testPoint3D(Scanner sc, Input input) {
        System.out.println("\nТрехмерная точка");
        Point3D[] points = new Point3D[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("\nВведите координаты для 3D-точки #" + (i + 1) + ":");
            double x = input.readDouble(sc, "X: ");
            double y = input.readDouble(sc, "Y: ");
            double z = input.readDouble(sc, "Z: ");
            points[i] = new Point3D(x, y, z);
        }

        System.out.println("\nСозданные трехмерные точки:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Точка " + (i + 1) + ": " + points[i]);
        }
    }

    // задача 6.2
    private static void testPointEquals(Scanner sc, Input input) {
        System.out.println("\nСравнение точек");

        System.out.println("1. Сравнение двумерных точек (Point):");
        double x1 = input.readDouble(sc, "Первая точка X: ");
        double y1 = input.readDouble(sc, "Первая точка Y: ");
        Point p1 = new Point(x1, y1);

        double x2 = input.readDouble(sc, "Вторая точка X: ");
        double y2 = input.readDouble(sc, "Вторая точка Y: ");
        Point p2 = new Point(x2, y2);

        System.out.println("Точка 1: " + p1 + " | Точка 2: " + p2);
        System.out.println("Сравнение ссылок (p1 == p2): " + (p1 == p2));
        System.out.println("Сравнение координат: " + p1.equals(p2));

        System.out.println("\n2. Сравнение трехмерных точек (Point3D):");
        double x3 = input.readDouble(sc, "Первая 3D-точка X: ");
        double y3 = input.readDouble(sc, "Первая 3D-точка Y: ");
        double z3 = input.readDouble(sc, "Первая 3D-точка Z: ");
        Point3D p3d1 = new Point3D(x3, y3, z3);

        double x4 = input.readDouble(sc, "Вторая 3D-точка X: ");
        double y4 = input.readDouble(sc, "Вторая 3D-точка Y: ");
        double z4 = input.readDouble(sc, "Вторая 3D-точка Z: ");
        Point3D p3d2 = new Point3D(x4, y4, z4);

        System.out.println("3D-точка 1: " + p3d1 + " | 3D-точка 2: " + p3d2);
        System.out.println("Сравнение координат: " + p3d1.equals(p3d2));
        System.out.println("Сравнение 2D и 3D точек: " + p1.equals(p3d1));
    }

    // задача 8.4
    private static void testPointClone(Scanner sc, Input input) {
        System.out.println("\nКлонирование точки");

        System.out.println("Клонирование двумерной точки:");
        double x = input.readDouble(sc, "Введите X: ");
        double y = input.readDouble(sc, "Введите Y: ");
        Point original = new Point(x, y);
        Point copy = original.clone();

        System.out.println("Оригинал: " + original);
        System.out.println("Клон:     " + copy);
        System.out.println("Это один и тот же объект в памяти? - " + (original == copy));
        System.out.println("Координаты совпадают? - " + original.equals(copy));

        System.out.println("\nКлонирование трехмерной точки:");
        double z = input.readDouble(sc, "Введите Z для 3D-точки: ");
        Point3D original3D = new Point3D(x, y, z);
        Point3D copy3D = original3D.clone();

        System.out.println("Оригинал 3D: " + original3D);
        System.out.println("Клон 3D:     " + copy3D);
        System.out.println("Это один и тот же объект в памяти? - " + (original3D == copy3D));
        System.out.println("Координаты совпадают? -" + original3D.equals(copy3D));
    }

    //задча 4.3
    private static void testBirds(Scanner sc, Input input) {
        System.out.println("\nПтицы");

        Parrot parrot = null;
        while (parrot == null) {
            String text = input.readText(sc, "Введите фразу, которую выучит попугай: ");
            try {
                parrot = new Parrot(text);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage() + " Попробуйте снова.");
            }
        }

        Bird[] birds = {
                new Sparrow(),
                new Cuckoo(),
                parrot
        };

        System.out.println("\nРезультат:");
        for (Bird bird : birds) {
            bird.sing();
        }
    }

    //задача 5.4
    public static void makeAllMeow(Meowable... meowables) {
        for (Meowable m : meowables) {
            if (m != null) {
                m.meow();
            }
        }
    }

    private static void testMeow(Scanner sc, Input input) {
        System.out.println("\n Мяуканье ");

        int catCount = input.readInt(sc, "Сколько обычных котов создать (от 1 до 5)? ", 1, 5);
        int robotCount = input.readInt(sc, "Сколько робо-котов создать (от 1 до 5)? ", 1, 5);

        Meowable[] allMeowers = new Meowable[catCount + robotCount];
        int index = 0;

        for (int i = 0; i < catCount; i++) {
            String catName = input.readString(sc, "Введите кличку кота #" + (i + 1) + ": ", false);
            allMeowers[index++] = new Cat(catName);
        }

        for (int i = 0; i < robotCount; i++) {
            String modelName = input.readText(sc, "Введите модель робо-кота #" + (i + 1) + ": ");
            while (modelName == null || modelName.trim().isEmpty()) {
                System.out.println("Ошибка: модель не может быть пустой.");
                modelName = input.readText(sc, "Введите модель робо-кота #" + (i + 1) + ": ");
            }
            allMeowers[index++] = new RoboCat(modelName);
        }

        System.out.println("\nПередаем всех в общий метод makeAllMeow():");
        makeAllMeow(allMeowers);

        int n = input.readInt(sc, "\nСколько раз должен мяукнуть первый кот (" + allMeowers + ")? ", 1, 10);
        ((Cat) allMeowers[0]).meow(n);
    }

}