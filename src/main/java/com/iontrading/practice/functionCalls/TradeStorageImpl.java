package com.iontrading.practice.functionCalls;

import com.iontrading.isf.commons.async.AsyncResult;
import com.iontrading.isf.commons.async.AsyncResultPromise;
import com.iontrading.isf.commons.async.AsyncResults;
import com.iontrading.talk.api.annotation.TalkParam;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by divya.gupta on 01-08-2018.
 */
public class TradeStorageImpl implements TradeStorage {
    Map<String, Trade> cache = new ConcurrentHashMap<>();

    @Override
    public AsyncResult<String> createTrade(String verb, BigDecimal price, Double qty) {

        AsyncResultPromise<String> asyncResult = AsyncResults.create();
        Trade tr = new Trade(verb, price, qty);

        if (cache.containsValue(tr)) {
            asyncResult.failure(new IllegalStateException("Trade already exists"));
        } else {
            cache.put(tr.getId(), tr);
            asyncResult.success("Trade created successfully " + tr.getId());
        }

        return asyncResult;
    }

    @Override
    public AsyncResult<String> updateTrade(String id, String verb, BigDecimal price, Double qty) {
        AsyncResultPromise<String> asyncResult = AsyncResults.create();
        if (cache.containsKey(id)) {
            Trade tr = cache.get(id);
            tr.setPrice(price);
            tr.setQuantity(qty);
            tr.setVerb(verb);
            cache.put(id, tr);
            asyncResult.success("Trade updated successfully " + id);
        } else {
            asyncResult.failure(new IllegalStateException("Trade not found"));

        }
        return asyncResult;
    }

    @Override
    public AsyncResult<String> updateTrade(@TalkParam(name = "id") String id, @TalkParam(name = "fieldValues") String... fieldValues) {
        AsyncResultPromise<String> asyncResult = AsyncResults.create();
        if (null != fieldValues && cache.containsKey(id)) {
            Trade tr = cache.get(id);

            for (String fieldKey : fieldValues) {
                String[] fields = fieldKey.split(":");
                switch (fields[0]) {
                    case "Price":
                        tr.setPrice(BigDecimal.valueOf(Double.parseDouble(fields[1])));
                        continue;
                    case "Verb":
                        tr.setVerb(fields[1]);
                        continue;
                    case "Qty":
                        tr.setQuantity(Double.valueOf(fields[1]));
                        continue;
                }

            }

            cache.put(id, tr);
            asyncResult.success("Trade updated successfully " + tr.toString());
        } else

        {
            asyncResult.failure(new IllegalStateException("Trade not found"));

        }

        return asyncResult;
    }

    @Override
    public AsyncResult<String> deleteTrade(String id) {
        AsyncResultPromise<String> asyncResult = AsyncResults.create();
        if (cache.containsKey(id)) {
            cache.remove(id);
            asyncResult.success("Trade deleted successfully " + id);
        } else {
            asyncResult.failure(new IllegalStateException("Trade not found"));
        }
        return asyncResult;
    }
}
