package com.iontrading.practice.workflows;

import com.google.inject.Inject;
import com.iontrading.isf.trace.ITracer;
import com.iontrading.isf.workflow_engine.spi.annotations.Start;
import com.iontrading.isf.workflow_engine.spi.elements.StartElement;

/**
 * Created by divya.gupta on 02-08-2018.
 */
@Start(workflow = "Login", id = "Start", to = "Validation")
public class WorkflowLoginStart extends StartElement {

    @Inject
    public WorkflowLoginStart(ITracer logger) {
        logger.INFO().action("Login workflow started").end();
    }
}
