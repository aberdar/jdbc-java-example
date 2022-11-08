package ru.ac.uniyar.databasescourse.storage;

public class Reviewer {
    private final Integer reviewerID;
    private final String reviewerSurname;

    public Reviewer(Integer reviewerID, String reviewerSurname) {
        this.reviewerID = reviewerID;
        this.reviewerSurname = reviewerSurname;
    }

    public Integer getReviewerID() {
        return reviewerID;
    }

    public String getReviewerSurname() {
        return reviewerSurname;
    }
}
