package com.iontrading.practice.persistBean.xrsSample.common;

import com.iontrading.isf.committer.spi.AbstractPublishableEntity;
import com.iontrading.talk.api.annotation.TalkProperty;
import com.iontrading.talk.api.annotation.TalkType;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.Date;

/**
 * JPA entity that holds the data to be persisted. Since we're using P&N to take
 * care about ids, revisions and so on, the entity needs to extend the
 * {@link AbstractPublishableEntity}.
 */
@TalkType(name = "Trade")
public class PublishableTrade extends AbstractPublishableEntity {

    private Integer securityType;
    private Double qtyNominal;
    private BigDecimal price;
    private DateTime timestamp;
    private Integer counterpartyCode;
    private Boolean active;
    private BuySell buySell;
    private Date maturityDate;

    @TalkProperty
    public Integer getSecurityType() {
        return securityType;
    }

    public void setSecurityType(Integer securityType) {
        this.securityType = securityType;
    }

    @TalkProperty
    public Double getQtyNominal() {
        return qtyNominal;
    }

    public void setQtyNominal(Double qtyNominal) {
        this.qtyNominal = qtyNominal;
    }

    @TalkProperty
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @TalkProperty
    public DateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(DateTime timestamp) {
        this.timestamp = timestamp;
    }

    @TalkProperty
    public Integer getCounterpartyCode() {
        return this.counterpartyCode;
    }

    public void setCounterpartyCode(Integer counterpartyCode) {
        this.counterpartyCode = counterpartyCode;
    }

    @TalkProperty
    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @TalkProperty
    public BuySell getBuySell() {
        return this.buySell;
    }

    public void setBuySell(BuySell buySell) {
        this.buySell = buySell;
    }

    @TalkProperty
    public Date getMaturityDate() {
        return this.maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }
}
