package com.iontrading.practice.workflows;

import com.google.inject.Inject;
import com.iontrading.isf.trace.ITracer;
import com.iontrading.isf.workflow_engine.spi.annotations.UserTask;
import com.iontrading.isf.workflow_engine.spi.annotations.Workflow;
import com.iontrading.isf.workflow_engine.spi.elements.ICompletionToken;
import com.iontrading.isf.workflow_engine.spi.elements.UserTaskElement;
import com.iontrading.jmix.subscribe.IError;
import com.iontrading.practice.publisherBeans.PublisherTrade;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by divya.gupta on 02-08-2018.
 */
@UserTask(workflow = "Login", id = "PerformLogin", to = "Join")
public class WorkflowLoginPerformLogin extends UserTaskElement {

    private IWorkflowLoginContext context;
    private String workflowInstanceId;

    private ITracer logger;

    @Inject
    public WorkflowLoginPerformLogin(IWorkflowLoginContext context, @Workflow String workflowInstanceId) {
        this.context = context;
        this.workflowInstanceId = workflowInstanceId;
    }

    @Override
    public void process(ICompletionToken token) {
        doLogin(context.getUser(), context.getPassword());
        token.done();
    }

    private void doLogin(String user, String password) {

        System.out.println("User logged In: " + user);
        logger.INFO().action("do login with user: " + user + " and password: " + password).token("Workflow instance id", workflowInstanceId).end();
    }

}


