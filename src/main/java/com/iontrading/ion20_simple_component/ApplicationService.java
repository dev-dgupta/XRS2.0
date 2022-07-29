/**
 * Copyright (c) 2014 ION Trading ltd.
 * All Rights reserved.
 *
 * This software is proprietary and confidential to ION Trading ltd.
 * and is protected by copyright law as an unpublished work.
 * Unauthorized access and disclosure strictly forbidden.
 */
package com.iontrading.ion20_simple_component;

import javax.inject.Inject;

import com.iontrading.isf.boot.spi.IService;
import com.iontrading.isf.trace.ITracer;
import com.iontrading.isf.trace.ITracerFactory;

/**
 * Defines automatically starting services.
 */
public class ApplicationService implements IService {

    /**   */
    private static final String SERVICE_NAME = "ApplicationService";
    private final ITracer trace;

    @Inject
    private ApplicationService(ITracerFactory logFactory) {
        this.trace = logFactory.createTracer(SERVICE_NAME);
    }
    
    public String getName() {
        return SERVICE_NAME;
    }

    public void start() throws Exception {
        trace.INFO().key("Service").action("Starting up").end();

    }

    public void shutdown() {
        trace.INFO().key("Service").action("Shutting down").end();
    }

}
