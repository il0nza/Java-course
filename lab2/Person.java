public class Person {
    private Name name;
    private int height;
    private Person father;

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
        this.name = name;
        this.height = height;
        this.father = father;

        if (this.father != null) {
            if (this.name.getLastName() == null || this.name.getLastName().isEmpty()) {
                if (this.father.getName().getLastName() != null) {
                    this.name.setLastName(this.father.getName().getLastName());
                }
            }
            if (this.name.getSurname() == null || this.name.getSurname().isEmpty()) {
                if (this.father.getName().getName() != null) {
                    this.name.setSurname(this.father.getName().getName() + "ович");
                }
            }
        }
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public String toString() {
        return name.toString() + ", рост: " + height + " см";
    }

}
