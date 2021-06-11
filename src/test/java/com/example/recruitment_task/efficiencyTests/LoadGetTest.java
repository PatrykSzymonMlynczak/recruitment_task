package com.example.recruitment_task.efficiencyTests;

import org.jsmart.zerocode.core.domain.LoadWith;
import org.jsmart.zerocode.core.domain.TestMapping;
import org.jsmart.zerocode.core.runner.parallel.ZeroCodeLoadRunner;
import org.junit.runner.RunWith;

@LoadWith("load_generation.properties")
@TestMapping(testClass = EfficiencyTest.class, testMethod = "test20Requests")
@RunWith(ZeroCodeLoadRunner.class)
public class LoadGetTest {

}