import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создаем инструмент для чтения того, что пользователь пишет в консоли
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine(); // Читаем строку текста

        System.out.print("В каком году вы родились? ");
        int birthYear = scanner.nextInt(); // Читаем целое число

        int age = 2026 - birthYear; // Считаем возраст (на дворе 2026 год)

        System.out.println("Привет, " + name + "! Из этой папки код тоже работает. Ваш возраст: " + age);
        
        scanner.close(); // Закрываем сканер
    }
}
