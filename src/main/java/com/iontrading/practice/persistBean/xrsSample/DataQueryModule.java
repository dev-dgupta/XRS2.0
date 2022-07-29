/**
 * File:    DataOwnerModule.java
 * Author:  Pavel Halas
 * Created: 14 Apr 2014
 *
 * Copyright (c) 2014 Wall Street Systems, Delaware Inc.
 * All Rights reserved.
 *
 * This software is proprietary and confidential to Wall Street Systems, Delaware Inc.
 * and is protected by copyright law as an unpublished work.
 * Unauthorized access and disclosure strictly forbidden.
 */
package com.iontrading.practice.persistBean.xrsSample;

import com.google.inject.AbstractModule;
import com.iontrading.isf.boot.guice.BootModule;
import com.iontrading.isf.configuration.guice.ConfigurationCoreModule;
import com.iontrading.isf.jmix_persistence.JMIXPersistenceModule;
import com.iontrading.isf.modules.annotation.ModuleDescriptor;
import com.iontrading.isf.service_manager.guice.ServiceManagerModule;
import com.iontrading.isf.xrs_talk_helper.guice.XrsTalkHelperMapperModule;
import com.iontrading.isf.xrs_talk_helper.guice.XrsTalkHelperModule;
import com.iontrading.practice.persistBean.xrsSample.common.PersistableTrade;
import com.iontrading.xrs.guice.XrsModule;

/**
 * Main module for the data query use case.
 * 
 * It shows the scenario of standalone xRS component (this one, data query)
 * depending on a another component taking care about persistence (using P&N) --
 * the data owner.
 * 
 * This xRS component uses the database of the data owner directly via snapshot
 * module and subscribes to the P&N message queue the data owner provides via
 * realtime module. The structure of the context is defined using Talk annotated
 * bean.
 * 
 */
@ModuleDescriptor(requires = { ServiceManagerModule.class, ConfigurationCoreModule.class, BootModule.class,
        XrsModule.class, XrsTalkHelperModule.class, JMIXPersistenceModule.class, XrsTalkHelperMapperModule.class })
public class DataQueryModule extends AbstractModule {
    @Override
    protected void configure() {
        // define an xRS context by registering a context provider
        XrsModule.registerContext(binder(), DataQueryTradeContextProvider.class);

        // ..and we have to configure Hibernate properly
        JMIXPersistenceModule.registerAnnotatedClass(binder(), PersistableTrade.class);
    }
}
