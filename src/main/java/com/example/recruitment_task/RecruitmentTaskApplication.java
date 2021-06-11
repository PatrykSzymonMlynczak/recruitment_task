package com.example.recruitment_task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
public class RecruitmentTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitmentTaskApplication.class, args);
    }

}
