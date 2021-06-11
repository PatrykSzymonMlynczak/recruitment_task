package com.example.recruitment_task.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class RepositoryInfoResponse {

    private String fullName;
    private String description;
    private String cloneUrl;
    private int stars; // stargazers
    private String createdAt;


}
