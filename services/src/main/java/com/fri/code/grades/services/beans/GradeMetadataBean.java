package com.fri.code.grades.services.beans;

import com.fri.code.grades.lib.GradeMetadata;
import com.kumuluz.ee.streaming.common.annotations.StreamListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.logging.Logger;

@ApplicationScoped
public class GradeMetadataBean {

    private Logger log = Logger.getLogger(GradeMetadataBean.class.getName());

    Integer tmp;

    @PostConstruct
    private void init() {
        tmp = 0;
    }

    @StreamListener(topics = {"4nqq16cf-grades"})
    public void calculatePoints(ConsumerRecord<String, String> record){
        //grade.setTotalPoints(grade.getSolvedExercises()*10.0);
        log.severe(String.format("!!!!!!!!!!!!!!!!!!!!!!%s!!!!!!!!!!!!!!!!!!!!!!", record.value()));
        tmp = Integer.decode(record.value())*10;
    }

    public Integer getPoints(){
        return tmp;
    }
}
