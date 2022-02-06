package com.paystack.test;


import com.cucumber.listener.Reporter;
import com.paystack.model.Automation;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/Feature"},
        glue = {"com.paystack.stepdefination"},
        strict = true,
        tags = {"@SmokeTest"},
        format = {"pretty", "html:target/html/cucumber.html", "json:target/Json/cucumber.json", "junit:target/Junit/junit.xml"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport/index.html"},
        monochrome = true
)
public class RunnerTest {

    @AfterClass
    public static void generateReport() {

        Reporter.loadXMLConfig(new File("src/main/resources/Extent-Report/Extent-Config.xml"));
        Reporter.setSystemInfo("User Name : ", System.getProperty("user.name"));
        Reporter.setSystemInfo("Operating System : ", System.getProperty("os.name"));
        Reporter.setSystemInfo("OS Version : ", System.getProperty("os.version"));
        Reporter.setSystemInfo("Java Version : ", System.getProperty("java.version"));
        Reporter.setSystemInfo("Time Zone : ", System.getProperty("user.timezone"));
        Reporter.setTestRunnerOutput("Absa Test Logs");
    }
}
