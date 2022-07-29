package com.iontrading.practice.workflows;

import com.iontrading.isf.workflow_engine.spi.IWorkflowContext;

/**
 * Created by divya.gupta on 02-08-2018.
 */
public interface IWorkflowLoginContext extends IWorkflowContext {
    String getUser();

    String getPassword();
}
