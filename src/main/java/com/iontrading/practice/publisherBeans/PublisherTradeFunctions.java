package com.iontrading.practice.publisherBeans;

import com.iontrading.isf.commons.async.AsyncResult;
import com.iontrading.talk.api.annotation.PrimitiveType;
import com.iontrading.talk.api.annotation.TalkFunction;
import com.iontrading.talk.api.annotation.TalkParam;

import java.math.BigDecimal;

/**
 * Created by divya.gupta on 01-08-2018.
 */
public interface PublisherTradeFunctions {

    @TalkFunction(name = "publisherCreateTrade")
    AsyncResult<PublisherTrade> publisherCreateTrade(@TalkParam(name = "id") Long id,
                                             @TalkParam(name = "qty") Integer qty,
                                             @TalkParam(name = "price") BigDecimal price,
                                             @TalkParam(name = "trader_id") Long trader_id,
                                             @TalkParam(name = "trader_name") String trader_name);

//    @TalkFunction(name = "publisherUpdateTrade")
//    AsyncResult<String> publisherUpdateTrade(@TalkParam(name = "id") String id, @TalkParam(name = "fieldValues") String... fieldValues);

    @TalkFunction(name = "publisherDeleteTrade")
    AsyncResult<PublisherTrade> publisherDeleteTrade(@TalkParam(name = "id") Long id);
}
