package com.fri.code.grades.models.converters;

import com.fri.code.grades.lib.GradeMetadata;
import com.fri.code.grades.models.entities.GradeMetadataEntity;

public class GradeMetadataConverter {

    public static GradeMetadata toDTO(GradeMetadataEntity entity) {
        GradeMetadata gradeMetadata = new GradeMetadata();

        gradeMetadata.setID(entity.getID());
        gradeMetadata.setTotalPoints(entity.getTotalPoints());
        gradeMetadata.setSolvedExercises(entity.getSolvedExercises());

        return gradeMetadata;
    }

    public static GradeMetadataEntity toEntity(GradeMetadata gradeMetadata){
        GradeMetadataEntity entity = new GradeMetadataEntity();

        entity.setID(gradeMetadata.getID());
        entity.setSolvedExercises(gradeMetadata.getSolvedExercises());
        entity.setTotalPoints(gradeMetadata.getTotalPoints());

        return entity;
    }
}
