package ru.gachegova.cat;
public class Cat implements Meowable {
    private final String name;

    public Cat(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Кличка кота не может быть пустой!");
        }
        this.name = name;
    }

    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
    }

    public void meow(int n) {
        if (n <= 0) {
            System.out.println("(Кот молчит, так как число мяуканий <= 0)");
            return;
        }
        StringBuilder meowText = new StringBuilder(name + ": ");
        for (int i = 0; i < n; i++) {
            meowText.append("мяу");
            if (i < n - 1) {
                meowText.append("-");
            }
        }
        meowText.append("!");
        System.out.println(meowText);
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }
}
