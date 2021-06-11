package com.example.recruitment_task.response;

import org.kohsuke.github.GHRepository;

import java.io.IOException;

public interface ResponsePreparator {

    RepositoryInfoResponse prepareResponse(GHRepository repository) throws IOException;
}
