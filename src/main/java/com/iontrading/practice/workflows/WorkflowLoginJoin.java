package com.iontrading.practice.workflows;

import com.iontrading.isf.workflow_engine.spi.annotations.Parallel;
import com.iontrading.isf.workflow_engine.spi.elements.ParallelElement;

/**
 * Created by divya.gupta on 02-08-2018.
 */
@Parallel(workflow = "Login", id = "Join", task1 = "End")
public class WorkflowLoginJoin extends ParallelElement {
}

