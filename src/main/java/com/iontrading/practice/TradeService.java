package com.iontrading.practice;


import com.iontrading.isf.boot.spi.IService;
import com.iontrading.isf.configuration.api.Configuration;
import com.iontrading.isf.service_manager.spi.IBusServiceManager;
import com.iontrading.isf.trace.ITracer;
import com.iontrading.isf.trace.ITracerFactory;
import com.iontrading.practice.publisherBeans.PublisherTrade;
import com.iontrading.practice.publisherBeans.Trader;
import com.iontrading.talk.api.Publisher;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by divya.gupta on 31-07-2018.
 */

/**
 * here a service is created/activated
 */
public class TradeService implements IService {
    private static final String SERVICE_NAME = "TradeService";
    private final ITracer trace;
    @Inject
    IBusServiceManager manager;

    @Inject
    private TradeService(ITracerFactory logFactory) {
        this.trace = logFactory.createTracer(SERVICE_NAME);
    }

//    @Inject
//    Publisher publisher;

    public String getName() {
        return SERVICE_NAME;
    }

    public void start() throws Exception {
        trace.INFO().key("Service").action("Starting up").end();
        manager.activateService(SERVICE_NAME);
        System.out.println("Service Activated");


//        publishData();
//        publishDataAsAList();

    }

    private void publishDataAsAList() {
        Trader john = new Trader(1, "John");
        Trader peter = new Trader(2, "Peter");
        PublisherTrade PublisherTrade1 = new PublisherTrade(123L, john, 333, new BigDecimal("123456.66"));
        PublisherTrade PublisherTrade2 = new PublisherTrade(183L, john, 133, new BigDecimal("456.66"));
        PublisherTrade PublisherTrade3 = new PublisherTrade(13L, peter, 63, new BigDecimal("8756.66"));

        // Publishing multiple records & chain
//        publisher.publishToList(PublisherTrade.class, Arrays.asList(PublisherTrade1, PublisherTrade2,PublisherTrade3), "PublisherTradeS");
//        // Publishing a single item into a chain
//        publisher.publishToList(john, "PEOPLE");
//        publisher.publishToList(peter, "TRADERS");
        replacePreviousPublishedList(john, PublisherTrade1);
    }

    private void replacePreviousPublishedList(Trader john, PublisherTrade PublisherTrade1) {
        PublisherTrade PublisherTrade3 = new PublisherTrade(173L, john, 3234, new BigDecimal("123.66"));
//        publisher.replaceList(PublisherTrade.class, Arrays.asList(PublisherTrade1, PublisherTrade3), "PublisherTradeS");
    }

    private void publishData() {
        Trader john = new Trader(1, "John");
        PublisherTrade PublisherTrade = new PublisherTrade(123L, john, 333, new BigDecimal("123456.66"));

//        publisher.publish(john);
//        publisher.publish(PublisherTrade);

    }

    public void shutdown() {
        trace.INFO().key("Service").action("Shutting down").end();
        manager.deactivateService(SERVICE_NAME);
        System.out.println("Service DeActivated");
    }


}
