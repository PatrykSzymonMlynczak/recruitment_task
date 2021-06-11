package com.example.recruitment_task.efficiencyTests;

import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("app_service_host.properties")
@RunWith(ZeroCodeUnitRunner.class)
public class EfficiencyTest {

    @Test
    @JsonTestCase("get_response_by_user_and_repo.json")
    public void test20Requests() {
        System.out.println("sd");
    }

}