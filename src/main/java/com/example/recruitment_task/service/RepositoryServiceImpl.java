package com.example.recruitment_task.service;

import com.example.recruitment_task.exceptions.RepositoryNotFoundException;
import lombok.AllArgsConstructor;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RepositoryServiceImpl implements RepositoryService{

    private GitHubService gitHubService;

    @Override
    public GHRepository findRepository(String userName, String repositoryName) throws IOException {
        String repoFullName = userName + "/" + repositoryName;

        Map<String, GHRepository> repositories = getRepositories(userName);
        Optional<GHRepository> repositoryOptional = repositories.values()
                .stream()
                .filter(e -> e.getFullName().equals(repoFullName))
                .findFirst();

        return repositoryOptional.orElseThrow(() -> new RepositoryNotFoundException());
    }

    private Map<String, GHRepository> getRepositories(String userName) throws IOException {
        GHUser ghUser = findUser(userName);
        return ghUser.getRepositories();
    }

    private GHUser findUser(String userName) throws IOException {
        return gitHubService.getGitHubUser(userName);
    }
}
