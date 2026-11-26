import java.util.Random;

public class Cuckoo extends Bird {
    @Override
    public void sing() {
        Random random = new Random();
        int n = random.nextInt(1, 11);
        for (int i = 0; i < n; i++) {
            System.out.print("ку-ку ");
        }
        System.out.println();
    }
}