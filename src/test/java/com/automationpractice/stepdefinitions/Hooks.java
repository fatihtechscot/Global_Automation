package com.automationpractice.stepdefinitions;

import com.automationpractice.utilities.Driver;
import io.cucumber.java.Before;
import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp() {
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }
}


