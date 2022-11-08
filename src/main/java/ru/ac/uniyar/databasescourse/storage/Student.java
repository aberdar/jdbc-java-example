package ru.ac.uniyar.databasescourse.storage;

public class Student {
    private final Integer id;
    private final String name;
    private final String surname;

    public Student(
            Integer id,
            String name,
            String surname
    ) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
