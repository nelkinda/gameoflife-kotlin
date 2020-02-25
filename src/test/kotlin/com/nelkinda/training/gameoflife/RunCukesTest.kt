package com.nelkinda.training.gameoflife

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@CucumberOptions(
        features = ["src/test/resources/features"],
        strict = true
)
@RunWith(Cucumber::class)
class RunCukesTest
