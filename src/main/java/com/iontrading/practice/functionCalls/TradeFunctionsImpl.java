package com.iontrading.practice.functionCalls;

import com.iontrading.isf.commons.async.AsyncResult;
import com.iontrading.isf.commons.callback.Callback;
import com.iontrading.talk.api.annotation.PrimitiveType;
import com.iontrading.talk.api.annotation.TalkParam;

import javax.inject.Inject;
import java.math.BigDecimal;

/**
 * Created by divya.gupta on 01-08-2018.
 */
public class TradeFunctionsImpl implements TradeFunctions {

    @Inject
    TradeStorage storageService;

    @Override
    public AsyncResult<String> createTrade(@TalkParam(name = "verb", description = "Trader gateway accoutn", nullable = true) String verb, @TalkParam(name = "Price", typeHint = PrimitiveType.REAL, nullable = true) BigDecimal price, @TalkParam(name = "QtyTot", nullable = true) Double qty) {

        AsyncResult<String> res = storageService.createTrade(verb, price, qty);
        res.addCallback(new Callback<String>() {

            @Override
            public void onSuccess(String result) {
                System.out.println("result = " + result);
                res.isDone();
            }

            @Override
            public void onFailure(Throwable exception) {
                System.out.println(exception.getMessage());
            }
        });
        return res;

    }

    @Override
    public AsyncResult<String> updateTrade(@TalkParam(name = "id") String id, @TalkParam(name = "verb", description = "Trader gateway accoutn", nullable = true) String verb, @TalkParam(name = "Price", typeHint = PrimitiveType.REAL, nullable = true) BigDecimal price, @TalkParam(name = "QtyTot", nullable = true) Double qty) {
        AsyncResult<String> res = storageService.updateTrade(id, verb, price, qty);
        res.addCallback(new Callback<String>() {

            @Override
            public void onSuccess(String result) {
                System.out.println("result = " + result);
                res.isDone();
            }

            @Override
            public void onFailure(Throwable exception) {
                System.out.println(exception.getMessage());
            }
        });
        return res;
    }

    @Override
    public AsyncResult<String> updateTrade(@TalkParam(name = "id") String id, String... fieldValues) {
        AsyncResult<String> res = storageService.updateTrade(id, fieldValues);
        res.addCallback(new Callback<String>() {

            @Override
            public void onSuccess(String result) {
                System.out.println("result = " + result);
                res.isDone();
            }

            @Override
            public void onFailure(Throwable exception) {
                System.out.println(exception.getMessage());
            }
        });
        return res;
    }

    @Override
    public AsyncResult<String> deleteTrade(@TalkParam(name = "id") String id) {
        AsyncResult<String> res = storageService.deleteTrade(id);
        res.addCallback(new Callback<String>() {

            @Override
            public void onSuccess(String result) {
                System.out.println("result = " + result);
                res.isDone();
            }

            @Override
            public void onFailure(Throwable exception) {
                System.out.println(exception.getMessage());
            }
        });
        return res;
    }
}
