package com.cucumber.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/features"
        ,glue = {"stepdefinition"}
        ,tags = "@register"
        ,plugin ={"pretty", "html:target/cucumber-reports/cucumber", "json:target/cucumber-reports/cucumber.json"}
        ,monochrome = true)

public class runner extends AbstractTestNGCucumberTests
{}
