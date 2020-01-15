package com.fri.code.grades.lib;

public class GradeMetadata {

    public Integer ID;
    public Double totalPoints;
    public Integer solvedExercises;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Double getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Double totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Integer getSolvedExercises() {
        return solvedExercises;
    }

    public void setSolvedExercises(Integer solvedExercises) {
        this.solvedExercises = solvedExercises;
    }
}
