package com.fri.code.grades.services.beans;

import com.fri.code.grades.lib.GradeMetadata;
import com.fri.code.grades.models.converters.GradeMetadataConverter;
import com.fri.code.grades.models.entities.GradeMetadataEntity;
import com.kumuluz.ee.streaming.common.annotations.StreamListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@ApplicationScoped
public class GradeMetadataBean {

    @Inject
    EntityManager em;

    Integer tmp;

    @StreamListener(topics = {"4nqq16cf-grades"})
    public void calculatePoints(ConsumerRecord<String, Integer> record){
        //grade.setTotalPoints(grade.getSolvedExercises()*10.0);
        tmp = record.value()*10;
    }

    public Integer getPoints(){
        return tmp;
    }
}
