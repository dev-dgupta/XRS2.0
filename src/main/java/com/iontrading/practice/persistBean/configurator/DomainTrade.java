package com.iontrading.practice.persistBean.configurator;


import com.iontrading.isf.committer.spi.AbstractPersistablePublishableEntity;
import com.iontrading.isf.committer.spi.DomainEntity;
import com.iontrading.isf.committer.spi.RevisionIdentifier;

/**
 * Created by divya.gupta on 02-08-2018.
 */
public class DomainTrade implements DomainEntity {

    private String instrumentId;
    private double value;
    private double qty;
    private String verb;
    private DomainTrade previous;
    private RevisionIdentifier id;

    /*
     * Constructor for new entity
     */
    public DomainTrade() {
        this.previous = null;
    }

    /*
     * Constructor for amended entity
     */
    public DomainTrade(DomainTrade previous) {
        this.previous = previous;
    }


    @Override
    public RevisionIdentifier getIdentifier() {
        return id;
    }

    @Override
    public void setIdentifier(RevisionIdentifier revisionIdentifier) {
        this.id = revisionIdentifier;
    }

    // Required by the persistence and notification service to amend the trade.
    @Override
    public RevisionIdentifier getPreviousIdentifier() {
        return (previous != null) ? previous.getIdentifier() : null;
    }


    public DomainTrade getPrevious() {
        return previous;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getQty() {
        return qty;
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
}
