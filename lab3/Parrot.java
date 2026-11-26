import java.util.Random;

public class Parrot extends Bird {
    private final String singText;

    public Parrot(String singText) {
        if (singText == null || singText.isEmpty()) {
            throw new IllegalArgumentException("Текст для попугая не может быть пустым!");
        }
        this.singText = singText;
    }

    @Override
    public void sing() {
        Random random = new Random();
        int n = random.nextInt(1, singText.length() + 1);
        System.out.println(singText.substring(0, n));
    }
}
