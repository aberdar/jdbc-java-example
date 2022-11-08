package ru.ac.uniyar.databasescourse.storage;

public class Solution {
    private final Integer solutionID;
    private final Integer studentID;
    private final Integer reviewerID;
    private final Double score;
    private final String hasPass;

    public Solution(
            Integer solutionID,
            Integer studentID,
            Integer reviewerID,
            Double score,
            String hasPass
    ) {
        this.solutionID = solutionID;
        this.studentID = studentID;
        this.reviewerID = reviewerID;
        this.score = score;
        this.hasPass = hasPass;
    }

    public Integer getSolutionID() {
        return solutionID;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public Integer getReviewerID() {
        return reviewerID;
    }

    public Double getScore() {
        return score;
    }

    public String getHasPass() {
        return hasPass;
    }
}
