package com.iontrading.practice.workflows;

import com.google.inject.Inject;
import com.iontrading.isf.trace.ITracer;
import com.iontrading.isf.workflow_engine.spi.annotations.UserTask;
import com.iontrading.isf.workflow_engine.spi.elements.ICompletionToken;
import com.iontrading.isf.workflow_engine.spi.elements.UserTaskElement;

/**
 * Created by divya.gupta on 02-08-2018.
 */
@UserTask(workflow = "Login", id = "ReplyError", to = "End")
public class WorkflowLoginReplyError extends UserTaskElement {
    private final ITracer logger;
    private IWorkflowLoginContext context;

    @Inject
    public WorkflowLoginReplyError(ITracer logger, IWorkflowLoginContext context) {
        this.logger = logger;
        this.context = context;
    }

    @Override
    public void process(ICompletionToken token) {
        logger.ERROR().action("Validation failed").token("Reason", "Provided credentials are invalid").token("User", context.getUser()).end();
        System.out.println("Validation failed");
        // failure management code here
        token.done();
    }
}
