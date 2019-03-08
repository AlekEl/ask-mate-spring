package com.codecool.askmate.Model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="descriminatorColumn")
@Table(name="AuditModel")
public abstract class AuditionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    public AuditionModel() {
    }

    public AuditionModel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
