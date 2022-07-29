/**
 * File:    TradeContextProvider.java
 * Author:  Pavel Halas
 * Created: 14 Apr 2014
 * <p>
 * Copyright (c) 2014 Wall Street Systems, Delaware Inc.
 * All Rights reserved.
 * <p>
 * This software is proprietary and confidential to Wall Street Systems, Delaware Inc.
 * and is protected by copyright law as an unpublished work.
 * Unauthorized access and disclosure strictly forbidden.
 */
package com.iontrading.practice.persistBean.xrsSample;

import com.iontrading.isf.xrs_talk_helper.spi.*;
import com.iontrading.practice.persistBean.xrsSample.common.PersistableTrade;
import com.iontrading.practice.persistBean.xrsSample.common.PublishableTrade;
import com.iontrading.xrs.api.ContextInitInfoProvider;
import com.iontrading.xrs.api.lib.ContextInitInfo;
import com.iontrading.xrs.api.lib.ContextModuleCollection;

import javax.inject.Inject;

/**
 * Context provider for the data query scenario.
 *
 * The structure of the context is defined using Talk annotated bean
 * {@link } which is shared with the data owner component.
 *
 * This xRS component uses the database of the data owner directly via snapshot
 * module and subscribes to the P&N message queue the data owner provides via
 * realtime module.
 *
 */
public class DataQueryTradeContextProvider implements ContextInitInfoProvider {

    /**
     * ID of the service provided by the data owner component.
     */
    private final static String REMOTE_SERVICE_ID = "XRS_DATAOWNER_SAMPLE";

    private final StructureModuleFactory structureModuleFactory;
    private final SnapshotModuleFactory snapshotModuleFactory;
    private final PNInProcessRealtimeModuleFactory realtimeModuleFactory;

    private JPACriteriaConfigurationFactory jpaCriteriaConfigurationFactory;

    @Inject
    public DataQueryTradeContextProvider(StructureModuleFactory structureModuleFactory,
                                         SnapshotModuleFactory snapshotModuleFactory, PNInProcessRealtimeModuleFactory realtimeModuleFactory,
                                         JPACriteriaConfigurationFactory jpaCriteriaConfigurationFactory) {
        this.structureModuleFactory = structureModuleFactory;
        this.snapshotModuleFactory = snapshotModuleFactory;
        this.realtimeModuleFactory = realtimeModuleFactory;
        this.jpaCriteriaConfigurationFactory = jpaCriteriaConfigurationFactory;
    }

    @Override
    public ContextInitInfo getContext() {
        ContextInitInfo context = new ContextInitInfo();

        // set the context name and the name of the managed entity
        context.setContextName("Trade").setContextObjectName("Trade");

        // prepare the set of xRS modules
        ContextModuleCollection modules = new ContextModuleCollection();

        // the Talk annotated bean can be used to instantiate the
        // StructureModule
        modules.setStructureModule(structureModuleFactory.create(PublishableTrade.class));

        // the SnapshotModule is automatically created and it exploits the JPA
        // annotated bean
        JPACriteriaConfiguration configuration = jpaCriteriaConfigurationFactory.create();

        // configuration.mapFilterField("PNCreationTime", "insertTimestamp");

        modules.setSnapshotModule(snapshotModuleFactory.builder(PersistableTrade.class, PublishableTrade.class)
                .withCriteriaConfiguration(configuration)
                .build());

        /*
         * the RealtimeModule is fed by a remote (single-instance) service
         * running P&N. In order to support the early-notification protocol it
         * would be sufficient to set the support at context level, by calling:
         * 
         * context.setSupportEarlyNotification(true);
         * 
         * In that case the RealtimModule would subscribe the P&N notification
         * queue in early-notification mode.
         */
        modules.setRealTimeModule(realtimeModuleFactory.create(PersistableTrade.class, PublishableTrade.class));

        context.setModuleCollection(modules);

        // The context supports the snapshot sorting feature. The Talk Helper
        // uses the native sorting capability of the DBMS.
        context.setSupportSortedSnapshot(true);

        return context;
    }
}
