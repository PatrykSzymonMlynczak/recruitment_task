package com.example.recruitment_task.response;

import com.example.recruitment_task.dateFormat.DateToISOFormatter;
import lombok.AllArgsConstructor;
import org.kohsuke.github.GHRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@AllArgsConstructor
@Service
public class ResponsePreparatorImpl implements ResponsePreparator {

    private DateToISOFormatter dateToISOFormatter;

    @Override
    public RepositoryInfoResponse prepareResponse(GHRepository repository) throws IOException {

        return new RepositoryInfoResponse(
                repository.getFullName(),
                repository.getDescription(),
                repository.getUrl() + ".git",
                repository.getStargazersCount(),
                setISODataFormat(repository.getCreatedAt())
        );
    }

    private String setISODataFormat(Date date) {
        return dateToISOFormatter.dateFormatter(date);
    }
}
