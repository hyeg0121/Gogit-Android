package com.gogit.gogit_app.model.github.commit;

public class RepoCommit {
    private Commit commit;

    public RepoCommit(Commit commit) {
        this.commit = commit;
    }

    public Commit getCommit() {
        return commit;
    }
}
