package com.iontrading.practice.workflows;

/**
 * Created by divya.gupta on 02-08-2018.
 */

import com.google.inject.Inject;
import com.iontrading.isf.trace.ITracer;
import com.iontrading.isf.workflow_engine.spi.annotations.BoolGateway;
import com.iontrading.isf.workflow_engine.spi.elements.BoolGatewayElement;
import com.iontrading.isf.workflow_engine.spi.elements.IBoolGatewayCompletionToken;
import com.iontrading.jmix.subscribe.IError;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@BoolGateway(workflow = "Login", id = "Validation", yes = "LoginFork", no = "CreateLogin")
public class WorkflowLoginValidation extends BoolGatewayElement {

    private final ITracer logger;
    private final IWorkflowLoginContext context;
    static Map<String, String> cache = new ConcurrentHashMap<>();

    @Inject
    public WorkflowLoginValidation(ITracer logger, IWorkflowLoginContext context) {
        this.logger = logger;
        this.context = context;
    }

    @Override
    public void process(IBoolGatewayCompletionToken token) {
        logger.INFO().action("Validating credentials").token("User", context.getUser()).end();
        System.out.println("Validating credentials......");

        if (WorkflowLoginValidation.cache.containsKey(context.getUser())) {
            token.done(true);
        } else {
            token.done(false);
        }


    }

//    class RecordObserver {
//        public void onDownloadEnd() {
//            token.done(true);
//        }
//        public void onError(final IError error) {
//            token.done(false);
//        }
//    }

}
