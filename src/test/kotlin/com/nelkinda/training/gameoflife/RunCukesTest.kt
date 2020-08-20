package com.nelkinda.training.gameoflife

import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@CucumberOptions(
        features = ["src/test/resources/features"],
)
@RunWith(io.cucumber.junit.Cucumber::class)
@io.cucumber.junit.platform.engine.Cucumber
class RunCukesTest
