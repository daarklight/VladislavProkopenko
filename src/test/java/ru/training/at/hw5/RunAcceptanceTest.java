package ru.training.at.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/ru/training/at/hw5/features/")
public class RunAcceptanceTest extends AbstractTestNGCucumberTests {
}