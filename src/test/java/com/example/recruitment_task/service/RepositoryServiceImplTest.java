package com.example.recruitment_task.service;

import com.example.recruitment_task.exceptions.RepositoryNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.kohsuke.github.GHRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class RepositoryServiceImplTest {

    @Autowired
    private RepositoryService repositoryService;

    @Test
    void shouldReturnGitHubUser() throws IOException {
        //given //when
        GHRepository ghRepository = repositoryService.findRepository("PatrykSzymonMlynczak", "recruitment_task");
        //then
        assertThat(ghRepository).isNotNull();
        assertThat(ghRepository.getFullName()).isEqualTo("PatrykSzymonMlynczak/recruitment_task");
        assertThat(ghRepository.getDescription()).isEqualTo("This task allowed me to get into an internship. Guidelines in ReadMe. Clean code and Tests.");
    }

    @Test
    void shouldThrowException(){
        RepositoryNotFoundException exception = assertThrows(RepositoryNotFoundException.class,
                () ->   repositoryService.findRepository("ala","makota")
        );

        assertEquals(exception.getMessage(),"Repository not found");
    }
}