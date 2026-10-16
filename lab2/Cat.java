public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println(name + ": мяу!");
    }

    public void meow(int n) {
        if (n <= 0) {
            System.out.println("(Кот молчит, так как число мяуканий <= 0)");
            return;
        }
        String meowText = name + ": ";
        for (int i = 0; i < n; i++) {
            meowText = meowText + "мяу";
            if (i < n - 1) {
                meowText = meowText + "-";
            }
        }
        meowText = meowText + "!";

        System.out.println(meowText);
    }

    public String toString() {
        return "кот: " + name;
    }
}
