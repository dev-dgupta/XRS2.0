package com.iontrading.practice.workflows;

/**
 * Created by divya.gupta on 02-08-2018.
 */
public class WorkflowLoginContext implements IWorkflowLoginContext {
    private String user;
    private String password;

    public WorkflowLoginContext() {
    }

    public WorkflowLoginContext(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
