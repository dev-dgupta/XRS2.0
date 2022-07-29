package com.iontrading.practice.functionCalls;

import com.iontrading.isf.commons.async.AsyncResult;
import com.iontrading.talk.api.annotation.PrimitiveType;
import com.iontrading.talk.api.annotation.TalkParam;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by divya.gupta on 01-08-2018.
 */
public interface TradeStorage {

    AsyncResult<String> createTrade(String verb, BigDecimal price, Double qty);

    AsyncResult<String> updateTrade(String id, String verb, BigDecimal price, Double qty);

    AsyncResult<String> updateTrade(String id, String... fieldValues);


    AsyncResult<String> deleteTrade(String id);

}
