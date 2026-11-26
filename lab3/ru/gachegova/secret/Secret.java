package ru.gachegova.secret;
import java.util.Random;

public class Secret {
    private final String secretText;
    private final String name;
    private Secret prev;
    private Secret next;

    public Secret(String name, String text) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым!");
        }
        if (text == null) {
            throw new IllegalArgumentException("Текст секрета не может быть null!");
        }
        this.name = name;
        this.secretText = text;
        this.prev = null;
        this.next = null;
    }

    public Secret(Secret prevSecret, String name) {
        if (prevSecret == null) {
            throw new IllegalArgumentException("Исходный секрет не может быть null!");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя нового хранителя не может быть пустым!");
        }
        if (prevSecret.next != null) {
            throw new IllegalStateException(
                    "Этот секрет уже был передан другому человеку! Рассказать его повторно нельзя");
        }

        System.out.println(prevSecret.name + " сказал, что " + prevSecret.secretText);

        this.name = name;
        this.secretText = distortText(prevSecret.secretText);
        this.prev = prevSecret;
        prevSecret.next = this;
    }

    // искажение текста
    private String distortText(String orig) {
        Random random = new Random();
        int maxAdd = (int) (orig.length() * 0.1);
        int x = random.nextInt(maxAdd + 1);

        StringBuilder sb = new StringBuilder(orig);
        String letters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";

        for (int i = 0; i < x; i++) {
            int pos = random.nextInt(sb.length() + 1);
            char randomChar = letters.charAt(random.nextInt(letters.length()));
            sb.insert(pos, randomChar);
        }
        return sb.toString();
    }

    public int getOrder() {
        int order = 1;
        Secret current = this.prev;
        while (current != null) {
            order++;
            current = current.prev;
        }
        return order;
    }

    // сколько человек узнали после текущего
    public int getPeopleAfterCount() {
        int count = 0;
        Secret current = this.next;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // поиск n хранителя
    private Secret getNKeeper(int n) {
        Secret current = this;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                if (current.next == null) {
                    throw new IllegalArgumentException("После текущего хранителя нет столько людей");
                }
                current = current.next;
            }
        } else if (n < 0) {
            for (int i = 0; i < -n; i++) {
                if (current.prev == null) {
                    throw new IllegalArgumentException("До текущего хранителя нет столько людей");
                }
                current = current.prev;
            }
        }
        return current;
    }

    // имя n человека, узнавшего секрет
    public String getNKeeperName(int n) {
        return getNKeeper(n).name;
    }

    // разница в кол-ве символов текста секрета с n человеком
    public int getLengthDifference(int n) {
        Secret target = getNKeeper(n);
        return target.secretText.length() - this.secretText.length();
    }

    @Override
    public String toString() {
        return name + ": это секрет!";
    }
}