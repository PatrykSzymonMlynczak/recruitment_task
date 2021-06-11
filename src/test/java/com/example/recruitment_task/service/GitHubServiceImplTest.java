package com.example.recruitment_task.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.kohsuke.github.GHUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class GitHubServiceImplTest {

    @Autowired
    private GitHubService gitHubService;

    @Test
    void shouldReturnCorrectMessageSubject() throws IOException {
        //given //when
        GHUser ghUser = gitHubService.getGitHubUser("Bykowski");
        //then
        assertThat(ghUser).isNotNull();
        assertThat(ghUser.getName()).isEqualTo("Przemysław Bykowski");
    }

}