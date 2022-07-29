package com.iontrading.practice.publisherBeans;

import com.iontrading.isf.commons.async.AsyncResult;

import java.math.BigDecimal;

/**
 * Created by divya.gupta on 01-08-2018.
 */
public interface PublisherTradeStorage {

    AsyncResult<PublisherTrade> publisherCreateTrade(Long id, Integer qty, BigDecimal price, Long trader_id, String trader_name);

//    AsyncResult<String> publisherUpdateTrade(Long id, String verb, BigDecimal price, Double qty);
//
//    AsyncResult<String> publisherUpdateTradeWithArgs(Long id, String... fieldValues);


    AsyncResult<PublisherTrade> publisherDeleteTrade(Long id);

}
