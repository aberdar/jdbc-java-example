package ru.ac.uniyar.databasescourse.storage;

public class Reviewers {
    private int reviewerID;
    private String reviewerSurname;
    private int reviewerDepartmentID;

    public Reviewers(int reviewerID, String reviewerSurname, int reviewerDepartmentID) {
        this.reviewerID = reviewerID;
        this.reviewerSurname = reviewerSurname;
        this.reviewerDepartmentID = reviewerDepartmentID;
    }

    public int getReviewerID() {
        return reviewerID;
    }

    public void setReviewerID(int reviewerID) {
        this.reviewerID = reviewerID;
    }

    public String getReviewerSurname() {
        return reviewerSurname;
    }

    public void setReviewerSurname(String reviewerSurname) {
        this.reviewerSurname = reviewerSurname;
    }

    public int getReviewerDepartmentID() {
        return reviewerDepartmentID;
    }

    public void setReviewerDepartmentID(int reviewerDepartmentID) {
        this.reviewerDepartmentID = reviewerDepartmentID;
    }
}
