package com.iontrading.practice.persistBean.xrsSample.common;

import com.iontrading.isf.committer.spi.AbstractPublishableEntity;
import com.iontrading.isf.committer.spi.DomainEntity;
import com.iontrading.isf.committer.spi.RevisionIdentifier;
import com.iontrading.practice.persistBean.xrsSample.common.counterparties.Counterparty;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Trade represents both Domain object and publishable one. It will be used to
 * define the structure of the xRS context and other modules as well.
 * 
 * Please note that @Identifier annotated property is required for xRS and it's
 * taken care of by {@link AbstractPublishableEntity}.
 */
public class Trade implements DomainEntity {

    private RevisionIdentifier revision;
    private Integer securityType;
    private Double qtyNominal;
    private BigDecimal price;
    private DateTime timestamp;
    private Counterparty counterparty;
    private Boolean active;
    private BuySell buySell;
    private Date maturityDate;

    public Integer getSecurityType() {
        return securityType;
    }

    public void setSecurityType(Integer securityType) {
        this.securityType = securityType;
    }

    public Double getQtyNominal() {
        return qtyNominal;
    }

    public void setQtyNominal(Double qtyNominal) {
        this.qtyNominal = qtyNominal;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public DateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(DateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Counterparty getCounterparty() {
        return this.counterparty;
    }

    public void setCounterparty(Counterparty counterparty) {
        this.counterparty = counterparty;
    }

    @Override
    public RevisionIdentifier getIdentifier() {
        return revision;
    }

    @Override
    public void setIdentifier(RevisionIdentifier newId) {
        this.revision = newId;
    }

    @Override
    public RevisionIdentifier getPreviousIdentifier() {
        return null;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public BuySell getBuySell() {
        return this.buySell;
    }

    public void setBuySell(BuySell buySell) {
        this.buySell = buySell;
    }

    public Date getMaturityDate() {
        return this.maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }
}
