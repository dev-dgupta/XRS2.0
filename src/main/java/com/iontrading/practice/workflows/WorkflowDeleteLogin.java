package com.iontrading.practice.workflows;

import com.google.inject.Inject;
import com.iontrading.isf.trace.ITracer;
import com.iontrading.isf.workflow_engine.spi.annotations.UserTask;
import com.iontrading.isf.workflow_engine.spi.annotations.Workflow;
import com.iontrading.isf.workflow_engine.spi.elements.ICompletionToken;
import com.iontrading.isf.workflow_engine.spi.elements.UserTaskElement;

/**
 * Created by divya.gupta on 02-08-2018.
 */
@UserTask(workflow = "Login", id = "DeleteLogin", to = "End")
public class WorkflowDeleteLogin extends UserTaskElement {

    private IWorkflowLoginContext context;
    private String workflowInstanceId;

    private ITracer logger;

    @Inject
    public WorkflowDeleteLogin(IWorkflowLoginContext context, @Workflow String workflowInstanceId) {
        this.context = context;
        this.workflowInstanceId = workflowInstanceId;
    }

    @Override
    public void process(ICompletionToken token) {
        deleteLogin(context.getUser());
        token.done();
    }

    private void deleteLogin(String user) {

        WorkflowLoginValidation.cache.remove(user);
        System.out.println("User removed: " + user);


    }


}


