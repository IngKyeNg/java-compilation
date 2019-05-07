package io.javabrains.courseapidata.course;

import io.javabrains.courseapidata.topic.Topic;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Course {

    @Id
    private String id;
    private String name;
    private String description;

    @ManyToOne
    private Topic topic;

}
