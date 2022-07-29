/**
 * Copyright (c) 2015 ION Trading ltd.
 * All Rights reserved.
 *
 * This software is proprietary and confidential to ION Trading ltd.
 * and is protected by copyright law as an unpublished work.
 * Unauthorized access and disclosure strictly forbidden.
 */
package com.iontrading.practice.persistBean.xrsSample.common;

import com.iontrading.isf.committer.spi.MapperException;
import com.iontrading.isf.committer.spi.PublishableFromDomainMapper;
import com.iontrading.practice.persistBean.xrsSample.common.counterparties.CounterpartyUtils;

public class TradeToPublishableTradeMapper implements PublishableFromDomainMapper<PublishableTrade, Trade> {

    public PublishableTrade write(Trade trade) throws MapperException {
        PublishableTrade publishableTrade = new PublishableTrade();
        publishableTrade.setCounterpartyCode(CounterpartyUtils.idToIdx(trade.getCounterparty().getId()));

        publishableTrade.setPrice(trade.getPrice());
        publishableTrade.setQtyNominal(trade.getQtyNominal());
        publishableTrade.setSecurityType(trade.getSecurityType());
        publishableTrade.setTimestamp(trade.getTimestamp());
        publishableTrade.setActive(trade.getActive());
        publishableTrade.setBuySell(trade.getBuySell());
        publishableTrade.setMaturityDate(trade.getMaturityDate());

        // No need to map P&N fields, will be mapped automatically

        return publishableTrade;
    }

    public Class<? extends PublishableTrade> getPublishableEntityClass() {
        return PublishableTrade.class;
    }

}
