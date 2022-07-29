package com.iontrading.practice.workflows;

import com.google.inject.Inject;

import com.iontrading.isf.commons.async.AsyncResult;
import com.iontrading.isf.commons.async.AsyncResultPromise;
import com.iontrading.isf.commons.async.AsyncResults;
import com.iontrading.isf.workflow_engine.spi.IWorkflow;
import com.iontrading.isf.workflow_engine.spi.IWorkflowFactory;
import com.iontrading.isf.workflow_engine.spi.IWorkflowListener;
import com.iontrading.talk.api.annotation.TalkFunction;
import com.iontrading.talk.api.annotation.TalkParam;
import com.iontrading.talk.api.exception.TalkFunctionException;

/**
 * Created by divya.gupta on 02-08-2018.
 */
public class ComponentFunctions {
    @Inject
    IWorkflowFactory factory;

    @TalkFunction
    public AsyncResult<Void> doLogin(@TalkParam(name = "user") String user, @TalkParam(name = "password") String password) {
        AsyncResultPromise<Void> result = AsyncResults.create();

        WorkflowLoginContext context = new WorkflowLoginContext(user, password);


        MyWorkflowListener listener = new MyWorkflowListener();
        IWorkflow workflow = factory.create(WorkflowLoginModule.class, context, new IWorkflowListener() {
            @Override
            public void started(IWorkflow iWorkflow) {

            }

            @Override
            public void completed(IWorkflow iWorkflow) {
                result.success(null);
            }

            @Override
            public void completedWithError(IWorkflow iWorkflow, Throwable throwable) {
                result.failure(throwable);
            }
        });
        workflow.start();

        return result;
    }

    @TalkFunction
    public void createLogin(@TalkParam(name = "user") String user, @TalkParam(name = "password") String password) {
        WorkflowLoginContext context = new WorkflowLoginContext(user, password);


        MyWorkflowListener listener = new MyWorkflowListener();
        IWorkflow workflow = factory.create(WorkflowLoginModule.class, context, listener);
        workflow.start();

    }

    @TalkFunction
    public void updateLogin(@TalkParam(name = "user") String user, @TalkParam(name = "password") String password) {
        WorkflowLoginContext context = new WorkflowLoginContext(user, password);


        MyWorkflowListener listener = new MyWorkflowListener();
        IWorkflow workflow = factory.create(WorkflowLoginModule.class, context, listener);
        workflow.start();

    }

    @TalkFunction
    public void deleteLogin(@TalkParam(name = "user") String user, @TalkParam(name = "password") String password) {
        WorkflowLoginContext context = new WorkflowLoginContext(user, password);


        MyWorkflowListener listener = new MyWorkflowListener();
        IWorkflow workflow = factory.create(WorkflowLoginModule.class, context, listener);
        workflow.start();

    }

}

class MyWorkflowListener implements IWorkflowListener {
    @Override
    public void started(IWorkflow workflow) {
        System.out.println("started..");

    }

    @Override
    public void completed(IWorkflow workflow) {
        System.out.println("completed..");
    }

    @Override
    public void completedWithError(IWorkflow iWorkflow, Throwable throwable) {
        System.out.println("completed with error..");
    }


}