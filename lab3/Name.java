public class Name {
    private final String lastName;
    private final String name;
    private final String surname;

    public Name(String firstName) {
        this(firstName, null, null);
    }

    public Name(String firstName, String lastName) {
        this(firstName, lastName, null);
    }

    public Name(String firstName, String lastName, String surname) {
        if (isEmpty(firstName) && isEmpty(lastName) && isEmpty(surname)) {
            throw new IllegalArgumentException("Хотя бы один параметр имени (имя, фамилия или отчество) должен быть непустым!");
        }
        this.name = firstName;
        this.lastName = lastName;
        this.surname = surname;
    }

    private boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (!isEmpty(lastName)) {
            result.append(lastName).append(" ");
        }
        if (!isEmpty(name)) {
            result.append(name).append(" ");
        }
        if (!isEmpty(surname)) {
            result.append(surname);
        }
        return result.toString().trim();
    }
}
