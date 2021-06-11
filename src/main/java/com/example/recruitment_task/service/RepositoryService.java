package com.example.recruitment_task.service;

import org.kohsuke.github.GHRepository;

import java.io.IOException;

public interface RepositoryService {

    GHRepository findRepository(String userName, String repoName) throws IOException;
}
