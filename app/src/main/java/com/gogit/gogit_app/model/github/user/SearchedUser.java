package com.gogit.gogit_app.model.github.user;

import java.util.List;

public class SearchedUser {
    private Integer total_count;
    private Boolean incomplete_results;
    private List<GithubUser> items;

    public SearchedUser(Integer total_count, Boolean incomplete_results, List<GithubUser> items) {
        this.total_count = total_count;
        this.incomplete_results = incomplete_results;
        this.items = items;
    }

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public Boolean getIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(Boolean incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public List<GithubUser> getItems() {
        return items;
    }

    public void setItems(List<GithubUser> items) {
        this.items = items;
    }
}
