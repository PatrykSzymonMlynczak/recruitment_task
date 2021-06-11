package com.example.recruitment_task.controller;

import com.example.recruitment_task.response.RepositoryInfoResponse;
import com.example.recruitment_task.response.ResponsePreparator;
import com.example.recruitment_task.service.RepositoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kohsuke.github.GHRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@ExtendWith(MockitoExtension.class)
public class GitControllerTest {

    private static Logger logger = LogManager.getLogger(GitControllerTest.class);
    private long start;
    long elapsedTime;
    static long totalTime;

    private MockMvc mockMvc;
    @Mock
    private ResponsePreparator responsePreparator;
    @Mock
    private RepositoryService repositoryService;
    @InjectMocks
    private GitController gitController;
    @Mock
    private GHRepository ghRepository;
    private RepositoryInfoResponse expectedRepositoryInfoResponse;
    private JacksonTester<RepositoryInfoResponse> testerResponse;

    @BeforeEach
    public void setup()  {

        this.mockMvc = MockMvcBuilders.standaloneSetup(this.gitController).build();
        JacksonTester.initFields(this, new ObjectMapper());

        expectedRepositoryInfoResponse = RepositoryInfoResponse.builder()
                .cloneUrl("https://api.github.com/repos/PatrykSzymonMlynczak/HTML.git")
                .createdAt("2020-05-04T21:16:04+02:00")
                .description("egreg")
                .fullName("PatrykSzymonMlynczak/HTML")
                .stars(111)
                .build();

    }

    @Test
    public void testSearchRepo() throws Exception {
        when(repositoryService.findRepository(any(String.class),any(String.class))).thenReturn(ghRepository);
        when(responsePreparator.prepareResponse(ghRepository)).thenReturn(expectedRepositoryInfoResponse);

        MockHttpServletResponse response = mockMvc.perform(
                get("/repositories/PatrykSzymonMlynczak/HTML")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                testerResponse.write(expectedRepositoryInfoResponse).getJson() );
    }

    @Test
    public void isAbleToDo20Rps() throws Exception {
        when(repositoryService.findRepository(any(String.class),any(String.class))).thenReturn(ghRepository);
        when(responsePreparator.prepareResponse(ghRepository)).thenReturn(expectedRepositoryInfoResponse);

        for(int i=0;i<20;i++) {
            start = System.currentTimeMillis();

            MockHttpServletResponse response = mockMvc.perform(
                    get("/repositories/PatrykSzymonMlynczak/HTML")
                            .accept(MediaType.APPLICATION_JSON))
                    .andReturn().getResponse();

            elapsedTime = System.currentTimeMillis() - start;
            totalTime += elapsedTime;

            logger.info("REQUEST TIME ELAPSED : " + elapsedTime + " MILLISECONDS");
        }

        assertThat(totalTime  < 1000);
    }

    @AfterAll
    private static void elapsedTime(){
        logger.info("TOTAL TIME ELAPSED : "+ totalTime + "MILLISECONDS" );
    }

}
