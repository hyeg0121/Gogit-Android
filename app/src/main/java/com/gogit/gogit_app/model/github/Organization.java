package com.gogit.gogit_app.model.github;

public class Organization {
    private String login;
    private String avater_url;

    public Organization(String login, String avater_url) {
        this.login = login;
        this.avater_url = avater_url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvater_url() {
        return avater_url;
    }

    public void setAvater_url(String avater_url) {
        this.avater_url = avater_url;
    }
}
