package com.cucumber.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/features"
                ,glue = {"stepdefinition"}
                ,tags = "@register")

public class runner extends AbstractTestNGCucumberTests
{}
