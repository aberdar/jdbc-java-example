package ru.ac.uniyar.databasescourse.storage;

public class Student {
    String name;
    String surname;
    Integer card;
    String answer;
    Double score;
    String review;
    Boolean has_pass;

    public Student(
            String name,
            String surname,
            Integer card,
            String answer,
            Double score,
            String review,
            Boolean has_pass
    ) {
        this.name = name;
        this.surname = surname;
        this.card = card;
        this.answer = answer;
        this.score = score;
        this.review = review;
        this.has_pass = has_pass;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getCard() {
        return card;
    }

    public String getAnswer() {
        return answer;
    }

    public Double getScore() {
        return score;
    }

    public String getReview() {
        return review;
    }

    public Boolean getHas_pass()     {
        return has_pass;
    }
}
