package com.codecool.askmate.Model;

import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="descriminatorColumn")
@Table(name="AuditModel")
public abstract class AuditionModel extends ResourceSupport {


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public Integer qid;

//    public AuditionModel() {
//    }

    public AuditionModel(Integer qid) {
        this.qid = qid;
    }


    public void setQid(Integer qId) {
        this.qid = qId;
    }

    @Override
    public String toString() {
        return qid + "";
    }
}
