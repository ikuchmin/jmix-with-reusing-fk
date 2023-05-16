package com.company.ub_with_double_keys.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;
import org.springframework.data.util.ProxyUtils;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@JmixEntity
@Embeddable
public class Ska1Id implements Serializable {
    @Column(name = "KTOPL")
    private String ktopl;

    @Column(name = "SAKNR")
    private String saknr;

    public String getSaknr() {
        return saknr;
    }

    public void setSaknr(String saknr) {
        this.saknr = saknr;
    }

    public String getKtopl() {
        return ktopl;
    }

    public void setKtopl(String ktopl) {
        this.ktopl = ktopl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(saknr, ktopl);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ProxyUtils.getUserClass(this) != ProxyUtils.getUserClass(o)) return false;
        Ska1Id entity = (Ska1Id) o;
        return Objects.equals(this.saknr, entity.saknr) &&
                Objects.equals(this.ktopl, entity.ktopl);
    }
}