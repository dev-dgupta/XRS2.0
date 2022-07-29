package com.iontrading.practice;

import com.google.inject.AbstractModule;
import com.iontrading.isf.boot.guice.BootModule;
import com.iontrading.isf.committer.guice.PersistenceNotificationModule;
import com.iontrading.isf.configuration.guice.ConfigurationCoreModule;
import com.iontrading.isf.modules.annotation.ModuleDescriptor;
import com.iontrading.isf.service_manager.guice.ServiceManagerModule;
import com.iontrading.isf.trace.guice.TracerModule;
import com.iontrading.isf.workflow_engine.guice.WorkflowEngineModule;
import com.iontrading.practice.persistBean.CreateAmendDeleteTradeService;
import com.iontrading.talk.ionbus.guice.TalkIonBusModule;

import javax.inject.Singleton;


/**
 * Created by divya.gupta on 31-07-2018.
 */

@ModuleDescriptor(requires = {BootModule.class, TracerModule.class, ServiceManagerModule.class, ConfigurationCoreModule.class, TalkIonBusModule.class, WorkflowEngineModule.class, PersistenceNotificationModule.class})
public class MyApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
//        BootModule.registerBootService(binder(), TradeService.class, IBootService.RunPhase.RUNNING);
//        ServiceManagerModule.addService(binder(), "TradeService");

//        bind(TradeStorage.class).to(TradeStorageImpl.class).in(Singleton.class);
//        bind(TradeFunctions.class).to(TradeFunctionsImpl.class).in(Singleton.class);
//        TalkModule.exportFunctions(binder(), TradeFunctions.class);

//        bind(PublisherTradeStorage.class).to(PublisherTradeStorageImpl.class).in(Singleton.class);
//        bind(PublisherTradeFunctions.class).to(PublisherTradeFunctionsImpl.class).in(Singleton.class);
//        TalkModule.exportFunctions(binder(), PublisherTradeFunctions.class);
//        TalkModule.exportFunctions(binder(), ComponentFunctions.class);
        TalkIonBusModule.exportFunctions(binder(), CreateAmendDeleteTradeService.class);

    }


}
