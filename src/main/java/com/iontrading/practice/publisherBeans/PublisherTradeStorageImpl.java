package com.iontrading.practice.publisherBeans;

import com.iontrading.isf.commons.async.AsyncResult;
import com.iontrading.isf.commons.async.AsyncResultPromise;
import com.iontrading.isf.commons.async.AsyncResults;
import com.iontrading.practice.functionCalls.Trade;
import com.iontrading.talk.api.Publisher;
import com.iontrading.talk.api.annotation.TalkParam;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by divya.gupta on 01-08-2018.
 */
public class PublisherTradeStorageImpl implements PublisherTradeStorage {
    Map<Long, PublisherTrade> cache = new ConcurrentHashMap<>();


    @Override
    public AsyncResult<PublisherTrade> publisherCreateTrade(Long id, Integer qty, BigDecimal price, Long trader_id, String trader_name) {

        AsyncResultPromise<PublisherTrade> asyncResult = AsyncResults.create();

        Trader trader = new Trader(trader_id, trader_name);
        PublisherTrade PublisherTrade = new PublisherTrade(id, trader, qty, price);

        if (cache.containsValue(PublisherTrade)) {
            asyncResult.failure(new IllegalStateException("Trade already exists"));
//            publisher.publish(trader);
        } else {
            cache.put(id, PublisherTrade);
            asyncResult.success(PublisherTrade);
        }

        return asyncResult;
    }

//    @Override
//    public AsyncResult<String> updateTrade(Long id, String verb, BigDecimal price, Double qty) {
//        AsyncResultPromise<String> asyncResult = AsyncResults.create();
//        if (cache.containsKey(id)) {
//            Trade tr = cache.get(id);
//            tr.setPrice(price);
//            tr.setQuantity(qty);
//            tr.setVerb(verb);
//            cache.put(id, tr);
//            asyncResult.success("Trade updated successfully " + id);
//        } else {
//            asyncResult.failure(new IllegalStateException("Trade not found"));
//
//        }
//        return asyncResult;
//    }
//
//    @Override
//    public AsyncResult<String> updateTrade(@TalkParam(name = "id") Long id, @TalkParam(name = "fieldValues") String... fieldValues) {
//        AsyncResultPromise<String> asyncResult = AsyncResults.create();
//        if (null != fieldValues && cache.containsKey(id)) {
//            Trade tr = cache.get(id);
//
//            for (String fieldKey : fieldValues) {
//                String[] fields = fieldKey.split(":");
//                switch (fields[0]) {
//                    case "Price":
//                        tr.setPrice(BigDecimal.valueOf(Double.parseDouble(fields[1])));
//                        continue;
//                    case "Verb":
//                        tr.setVerb(fields[1]);
//                        continue;
//                    case "Qty":
//                        tr.setQuantity(Double.valueOf(fields[1]));
//                        continue;
//                }
//
//            }
//
//            cache.put(id, tr);
//            asyncResult.success("Trade updated successfully " + tr.toString());
//        } else
//
//        {
//            asyncResult.failure(new IllegalStateException("Trade not found"));
//
//        }
//
//        return asyncResult;
//    }

    @Override
    public AsyncResult<PublisherTrade> publisherDeleteTrade(Long id) {
        AsyncResultPromise<PublisherTrade> asyncResult = AsyncResults.create();
        if (cache.containsKey(id)) {
            PublisherTrade PublisherTrade = cache.get(id);
            cache.remove(id);
            asyncResult.success(PublisherTrade);
        } else {
            asyncResult.failure(new IllegalStateException("Trade not found"));
        }
        return asyncResult;
    }
}
