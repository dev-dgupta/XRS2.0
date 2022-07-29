/**
 * Copyright (c) 2015 ION Trading ltd.
 * All Rights reserved.
 *
 * This software is proprietary and confidential to ION Trading ltd.
 * and is protected by copyright law as an unpublished work.
 * Unauthorized access and disclosure strictly forbidden.
 */
package com.iontrading.practice.persistBean.xrsSample.common;

import com.iontrading.isf.commons.async.ResultToken;
import com.iontrading.isf.mapping.spi.AbstractMapper;
import com.iontrading.isf.mapping.spi.MappingRequest;

public class PersistableTradeToPublishableTradeMapper extends AbstractMapper<PersistableTrade, PublishableTrade> {

    public PersistableTradeToPublishableTradeMapper() {
        super(PersistableTrade.class, PublishableTrade.class);
    }

    public void map(MappingRequest<PersistableTrade, PublishableTrade> request, ResultToken<PublishableTrade> result) {
        PersistableTrade persistable = request.getSource();

        PublishableTrade publishable = new PublishableTrade();
        publishable.setCounterpartyCode(persistable.getCounterpartyCode());
        publishable.setId(persistable.getId());
        publishable.setPrice(persistable.getPrice());
        publishable.setQtyNominal(persistable.getQtyNominal());
        publishable.setSecurityType(persistable.getSecurityType());
        publishable.setTimestamp(persistable.getTimestamp());
        publishable.setActive(persistable.getActive());
        publishable.setBuySell(persistable.getBuySell());
        publishable.setMaturityDate(persistable.getMaturityDate());

        result.success(publishable);
    }

}
