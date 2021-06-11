package com.example.recruitment_task.controller;

import com.example.recruitment_task.response.RepositoryInfoResponse;
import com.example.recruitment_task.response.ResponsePreparator;
import com.example.recruitment_task.service.RepositoryService;
import lombok.AllArgsConstructor;
import org.kohsuke.github.GHRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@AllArgsConstructor
@RestController
public class GitController {

    private ResponsePreparator responsePreparator;
    private RepositoryService repositoryService;

    @GetMapping("/repositories/{userName}/{repositoryName}")
    public RepositoryInfoResponse getRepositoryInfo(
            @PathVariable String userName,
            @PathVariable String repositoryName) throws IOException {

        GHRepository ghRepository = repositoryService.findRepository(userName,repositoryName);
        return responsePreparator.prepareResponse(ghRepository);
    }
}
