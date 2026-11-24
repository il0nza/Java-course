public class Person {
    private Name name;
    private int height;
    private final Person father;

    public Person(String firstName, int height) {
        this(new Name(firstName), height, null);
    }

    public Person(String firstName, int height, Person father) {
        this(new Name(firstName), height, father);
    }

    public Person(Name name, int height) {
        this(name, height, null);
    }

    public Person(Name name, int height, Person father) {
        if (name == null) {
            throw new IllegalArgumentException("Имя человека не может быть null!");
        }
        setHeight(height);
        this.father = father;

        String firstName = name.getName();
        String lastName = name.getLastName();
        String surname = name.getSurname();
        
        if (this.father != null) {
            if (isEmpty(lastName) && !isEmpty(this.father.getName().getLastName())) {
                lastName = this.father.getName().getLastName();
            }
            if (isEmpty(surname) && !isEmpty(this.father.getName().getName())) {
                surname = this.father.getName().getName() + "ович";
            }
        }

        this.name = new Name(firstName, lastName, surname);
    }

    private boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        if (name == null) {
            throw new IllegalArgumentException("Имя человека не может быть null!");
        }
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public final void setHeight(int height) {
        if (height <= 0 || height > 500) {
            throw new IllegalArgumentException("Рост человека должен быть положительным и не более 500 см! Введено: " + height);
        }
        this.height = height;
    }

    public Person getFather() {
        return father;
    }

    @Override
    public String toString() {
        return name.toString() + ", рост: " + height + " см";
    }
}
