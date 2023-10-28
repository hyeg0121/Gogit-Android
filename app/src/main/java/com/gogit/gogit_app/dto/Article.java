package com.gogit.gogit_app.dto;

import java.util.List;

public class Article {
    private final Long id;
    private final Member wrtier;
    private final String contents;
    private final List<Comment> comment;

    public Article(Long id, Member wrtier, String contents, List<Comment> comment) {
        this.id = id;
        this.wrtier = wrtier;
        this.contents = contents;
        this.comment = comment;
    }
}
