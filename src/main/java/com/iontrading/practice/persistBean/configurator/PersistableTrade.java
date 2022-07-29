package com.iontrading.practice.persistBean.configurator;

import com.iontrading.isf.committer.spi.AbstractPersistablePublishableEntity;
import com.iontrading.talk.api.annotation.Identifier;
import com.iontrading.talk.api.annotation.TalkProperty;
import com.iontrading.talk.api.annotation.TalkType;
import org.hibernate.annotations.Index;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Created by divya.gupta on 02-08-2018.
 */
@Entity
@Table(name = "TRADE")
@TalkType(name = "Trade")
public class PersistableTrade extends AbstractPersistablePublishableEntity {
    /**   */
    private static final long serialVersionUID = 443694950228200941L;

    @TalkProperty
    private String instrumentId;
    @TalkProperty
    private double value;
    @TalkProperty
    private double qty;
    @TalkProperty
    private String verb;

    public PersistableTrade() {
    }

    public double getValue() {
        return this.value;
    }

    public double getQty() {
        return qty;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    // Getters and setters for the  properties are omitted
}
