package com.example.recruitment_task.service;

import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GitHubServiceImpl implements GitHubService {

    @Override
    public GHUser getGitHubUser(String userName) throws IOException {
        GitHub gitHub = getGitHubInstance();
        return gitHub.getUser(userName);
    }

    //method is getting credentials
    private GitHub getGitHubInstance() throws IOException {
        return GitHubBuilder
                .fromPropertyFile("src/main/resources/application.properties")
                .build();
    }
}
