public class Name {
    private String lastName;
    private String name;
    private String surname;

    public Name(String name) {
        this(name, null, null);
    }

    public Name(String firstName, String lastName) {
        this(firstName, lastName, null);
    }

    public Name(String firstName, String lastName, String surname) {
        this.name = firstName;
        this.lastName = lastName;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getsurname() {
        return surname;
    }

    public void setsurname(String surname) {
        this.surname = surname;
    }

    public String toString() {
        String result = "";
        if (lastName != null && !lastName.isEmpty()) {
            result = result + lastName + " ";
        }

        if (name != null && !name.isEmpty()) {
            result = result + name + " ";
        }

        if (surname != null && !surname.isEmpty()) {
            result = result + surname;
        }
        return result;
    }
}
