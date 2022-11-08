package ru.ac.uniyar.databasescourse.storage;

public class Department {
    private final Integer id;
    private final String name;

    public Department(
            Integer id,
            String name
    ) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
