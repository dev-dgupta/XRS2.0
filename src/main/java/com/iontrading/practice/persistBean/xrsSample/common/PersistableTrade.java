package com.iontrading.practice.persistBean.xrsSample.common;

import com.iontrading.isf.committer.spi.AbstractPersistableEntity;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * JPA entity that holds the data to be persisted. Since we're using P&N to take
 * care about ids, revisions and so on, the entity needs to extend the
 * {@link AbstractPersistableEntity}.
 */
@Entity
@Table(name = "TRADE")
public class PersistableTrade extends AbstractPersistableEntity {

    private static final long serialVersionUID = -8963745574006470859L;

    private Integer securityType;
    private Double qtyNominal;
    private BigDecimal price;
    private DateTime timestamp;
    private Integer counterpartyCode;
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

    public Integer getCounterpartyCode() {
        return this.counterpartyCode;
    }

    public void setCounterpartyCode(Integer counterpartyCode) {
        this.counterpartyCode = counterpartyCode;
    }

    public Boolean getActive() {
        return this.active;
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
