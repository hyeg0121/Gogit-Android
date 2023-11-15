package com.gogit.gogit_app.request;

import java.util.List;

public class AddIssueRequest {
    private String title;
    private List<String> assignees;

    public AddIssueRequest(String title, List<String> assignees) {
        this.title = title;
        this.assignees = assignees;
    }



    @Override
    public String toString() {
        return "AddIssueRequest{" +
                "title='" + title + '\'' +
                ", assignees=" + assignees +
                '}';
    }
}
