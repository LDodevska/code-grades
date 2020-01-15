package com.fri.code.grades.services.beans;

import com.fri.code.grades.lib.GradeMetadata;
import com.fri.code.grades.models.converters.GradeMetadataConverter;
import com.fri.code.grades.models.entities.GradeMetadataEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@ApplicationScoped
public class GradeMetadataBean {

    @Inject
    EntityManager em;

    public GradeMetadata calculatePoints(GradeMetadata grade){
        grade.setTotalPoints(grade.getSolvedExercises()*50.0);
        return grade;
    }

    public GradeMetadata getGradeById(Integer id){
        TypedQuery<GradeMetadataEntity> query = em.createNamedQuery("GradeMetadataEntity.getGradeById", GradeMetadataEntity.class);
        return GradeMetadataConverter.toDTO(query.setParameter(1, id).getSingleResult());
    }
}
