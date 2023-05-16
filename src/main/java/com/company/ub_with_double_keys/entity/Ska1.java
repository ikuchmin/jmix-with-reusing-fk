package com.company.ub_with_double_keys.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@JmixEntity
@Table(name = "SKA1")
@Entity
public class Ska1 {

    @EmbeddedId
    private  Ska1Id id;

    public Ska1Id getId() {
        return id;
    }

    public void setId(Ska1Id id) {
        this.id = id;
    }
}