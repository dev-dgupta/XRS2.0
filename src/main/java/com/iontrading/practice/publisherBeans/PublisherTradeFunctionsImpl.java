package com.iontrading.practice.publisherBeans;

import com.iontrading.isf.commons.async.AsyncResult;
import com.iontrading.isf.commons.callback.Callback;
import com.iontrading.talk.api.Publisher;
import com.iontrading.talk.api.annotation.PrimitiveType;
import com.iontrading.talk.api.annotation.TalkParam;

import javax.inject.Inject;
import java.math.BigDecimal;

/**
 * Created by divya.gupta on 01-08-2018.
 */
public class PublisherTradeFunctionsImpl implements PublisherTradeFunctions {

    @Inject
    PublisherTradeStorage storageService;
    @Inject
    Publisher publisher;

    @Override
    public AsyncResult<PublisherTrade> publisherCreateTrade(@TalkParam(name = "id") Long id,
                                                   @TalkParam(name = "qty") Integer qty,
                                                   @TalkParam(name = "price") BigDecimal price,
                                                   @TalkParam(name = "trader_id") Long trader_id,
                                                   @TalkParam(name = "trader_name") String trader_name) {

        AsyncResult<PublisherTrade> res = storageService.publisherCreateTrade(id, qty, price, trader_id, trader_name);
        res.addCallback(new Callback<PublisherTrade>() {

            @Override
            public void onSuccess(PublisherTrade result) {
                System.out.println("result = " + result);
                publisher.publish(result);
                publisher.publishToList(result, "TRADE");
                res.isDone();
            }

            @Override
            public void onFailure(Throwable exception) {
                System.out.println(exception.getMessage());
            }
        });
        return res;

    }
//
//    @Override
//    public AsyncResult<String> updateTrade(@TalkParam(name = "id") Long id, @TalkParam(name = "verb", description = "Trader gateway accoutn", nullable = true) String verb, @TalkParam(name = "Price", typeHint = PrimitiveType.REAL, nullable = true) BigDecimal price, @TalkParam(name = "QtyTot", nullable = true) Double qty) {
//        AsyncResult<String> res = storageService.updateTrade(id, verb, price, qty);
//        res.addCallback(new Callback<String>() {
//
//            @Override
//            public void onSuccess(String result) {
//                System.out.println("result = " + result);
//                res.isDone();
//            }
//
//            @Override
//            public void onFailure(Throwable exception) {
//                System.out.println(exception.getMessage());
//            }
//        });
//        return res;
//    }

//    @Override
//    public AsyncResult<String> updateTrade(@TalkParam(name = "id") Long id, String... fieldValues) {
//        AsyncResult<String> res = storageService.updateTrade(id, fieldValues);
//        res.addCallback(new Callback<String>() {
//
//            @Override
//            public void onSuccess(String result) {
//                System.out.println("result = " + result);
//                res.isDone();
//            }
//
//            @Override
//            public void onFailure(Throwable exception) {
//                System.out.println(exception.getMessage());
//            }
//        });
//        return res;
//    }

    @Override
    public AsyncResult<PublisherTrade> publisherDeleteTrade(@TalkParam(name = "id") Long id) {
        AsyncResult<PublisherTrade> res = storageService.publisherDeleteTrade(id);
        res.addCallback(new Callback<PublisherTrade>() {

            @Override
            public void onSuccess(PublisherTrade result) {
                System.out.println("result = " + result);
                publisher.unpublish(result);
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
