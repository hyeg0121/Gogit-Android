package com.gogit.gogit_app.request;

public class AddIssueRequest {
    private String title;
    private String body;
    private String[] assignees;

    public AddIssueRequest(String title, String body, String[] assignees) {
        this.title = title;
        this.body = body;
        this.assignees = assignees;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String[] getAssignees() {
        return assignees;
    }

    public void setAssignees(String[] assignees) {
        this.assignees = assignees;
    }
}
