package com.nagarro.training.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
 @CucumberOptions(
   features = "src/test/java/com/nagarro/training/features/Tshirt.feature",
    glue = "com/nagarro/training/steps"
 )
public class CucumberTestRunner {
    
}
