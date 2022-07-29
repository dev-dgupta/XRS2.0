package com.iontrading.practice.workflows;

import com.iontrading.isf.workflow_engine.spi.annotations.Parallel;
import com.iontrading.isf.workflow_engine.spi.elements.ParallelElement;

/**
 * Created by divya.gupta on 02-08-2018.
 */

@Parallel(workflow = "Login", id = "CreateFork", task1 = "CreateLogin", task2 = "ReplyError")
public class WorkflowCreateLoginFork extends ParallelElement {
}
