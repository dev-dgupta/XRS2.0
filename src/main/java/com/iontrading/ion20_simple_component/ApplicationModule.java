/**
 * Copyright (c) 2014 ION Trading ltd.
 * All Rights reserved.
 *
 * This software is proprietary and confidential to ION Trading ltd.
 * and is protected by copyright law as an unpublished work.
 * Unauthorized access and disclosure strictly forbidden.
 */
package com.iontrading.ion20_simple_component;

import com.google.inject.AbstractModule;
import com.iontrading.isf.boot.guice.BootModule;
import com.iontrading.isf.boot.spi.IBootService.RunPhase;
import com.iontrading.isf.configuration.guice.ConfigurationCoreModule;
import com.iontrading.isf.modules.annotation.ModuleDescriptor;
import com.iontrading.isf.trace.guice.TracerModule;

/**
 * Component level module. Typically defines the lifecycle of the component,
 * dependencies etc.
 */
@ModuleDescriptor(requires = { BootModule.class, TracerModule.class, ConfigurationCoreModule.class, })
public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        BootModule.registerBootService(binder(), ApplicationService.class, RunPhase.RUNNING);
    }

}
