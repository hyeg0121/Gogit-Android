package com.gogit.gogit_app.model.github.commit;

import java.util.Map;

public class Commit {
    private Map<String, String> author;
    private String message;

    public Commit(Map<String, String> author, String message) {
        this.author = author;
        this.message = message;
    }

    public Map<String, String> getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }
}
