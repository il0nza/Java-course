public class RoboCat implements Meowable {
    private final String model;

    public RoboCat(String model) {
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Модель робота не может быть пустой!");
        }
        this.model = model;
    }

    @Override
    public void meow() {
        System.out.println("Робо-кот " + model + ": БИП-МЯЯУ-БИП!");
    }

    @Override
    public String toString() {
        return "робо-кот: " + model;
    }
}
