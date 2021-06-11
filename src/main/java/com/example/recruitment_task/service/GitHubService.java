package com.example.recruitment_task.service;

import org.kohsuke.github.GHUser;

import java.io.IOException;

public interface GitHubService {

    GHUser getGitHubUser(String userName) throws IOException;
}
