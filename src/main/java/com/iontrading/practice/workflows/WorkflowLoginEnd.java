package com.iontrading.practice.workflows;

import com.google.inject.Inject;
import com.iontrading.isf.trace.ITracer;
import com.iontrading.isf.workflow_engine.spi.annotations.End;
import com.iontrading.isf.workflow_engine.spi.elements.EndElement;


/**
 * Created by divya.gupta on 02-08-2018.
 */


@End(workflow = "Login", id = "End")
public class WorkflowLoginEnd extends EndElement {
    @Inject
    public WorkflowLoginEnd(ITracer logger) {

        System.out.println("Login workflow ending");
        logger.INFO().action("Login workflow ending").end();
    }
}

