package com.foofinc.mods.http_connections;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GitHubApiAccessor {

    private String repositoryOwner;
    private String repositoryName;

    public GitHubApiAccessor(String repositoryOwner, String repositoryName) {
        this.repositoryOwner = repositoryOwner;
        this.repositoryName = repositoryName;
    }

    public HttpURLConnection open() {

        try {
            URL url = new URL(createUrlString(repositoryOwner, repositoryName));
            return HttpConnector.openHttpConnection(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String createUrlString(String repositoryOwner, String repositoryName) {

        return String.format("https://github.com/%s/%s/archive/refs/heads/master.zip",
                             repositoryOwner, repositoryName);

    }

    public void setRepositoryOwner(String repositoryOwner) {
        this.repositoryOwner = repositoryOwner;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }
}
