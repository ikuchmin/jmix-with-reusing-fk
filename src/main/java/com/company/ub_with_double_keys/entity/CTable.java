package com.company.ub_with_double_keys.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@JmixEntity
@Table(name = "C_TABLE", indexes = {
        @Index(name = "IDX_C_TABLE_KTOPL", columnList = "KTOPL")
})
@Entity
public class CTable {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "KTOPL")
    @ManyToOne(fetch = FetchType.LAZY)
    private T004 ktopl;

    @JoinColumns({
            @JoinColumn(name = "SAKNR", referencedColumnName = "SAKNR"),
            @JoinColumn(name = "KTOPL", referencedColumnName = "KTOPL",
                    insertable = false, updatable = false)
    })
    @ManyToOne(fetch = FetchType.LAZY)
    private Ska1 saknr;

    public Ska1 getSaknr() {
        return saknr;
    }

    public void setSaknr(Ska1 saknr) {
        this.saknr = saknr;
    }

    public T004 getKtopl() {
        return ktopl;
    }

    public void setKtopl(T004 ktopl) {
        this.ktopl = ktopl;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}