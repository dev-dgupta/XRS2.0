package com.iontrading.practice.workflows;

import com.iontrading.isf.workflow_engine.spi.IWorkflowContext;
import com.iontrading.isf.workflow_engine.spi.annotations.AnnotatedWorkflowModule;
import com.iontrading.isf.workflow_engine.spi.elements.IFlowElement;

/**
 * Created by divya.gupta on 02-08-2018.
 */
public class WorkflowLoginModule extends AnnotatedWorkflowModule {

    public WorkflowLoginModule() {
        super(
                WorkflowLoginStart.class,
                WorkflowLoginValidation.class,
                WorkflowLoginFork.class,
                WorkflowUpdateLogin.class,
                WorkflowCreateLogin.class,
                WorkflowCreateLoginFork.class,
                WorkflowDeleteLogin.class,
                WorkflowLoginPerformLogin.class,
                WorkflowLoginReplyError.class,
                WorkflowLoginJoin.class,
                WorkflowLoginEnd.class);
    }

    @Override
    protected Class<? extends IWorkflowContext> getContextType() {

        return WorkflowLoginContext.class;
    }
}
