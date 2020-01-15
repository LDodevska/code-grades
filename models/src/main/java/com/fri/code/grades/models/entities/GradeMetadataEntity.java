package com.fri.code.grades.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "grade_entity")
@NamedQueries(
        value = {
                @NamedQuery(name = "GradeMetadataEntity.getGradeById", query = "SELECT grade FROM GradeMetadataEntity grade WHERE grade.ID =?1")
        }
)
public class GradeMetadataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "total_points")
    private Double totalPoints;

    @Column(name = "solved_exercises")
    private Integer solvedExercises;

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
