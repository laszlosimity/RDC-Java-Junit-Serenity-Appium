package com.yourcompany.Tests;

import com.yourcompany.util.ResultReporter;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.Concurrent;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@Concurrent
@RunWith(SerenityRunner.class)
abstract public class TestBase {

    @Managed
    protected WebDriver driver;

    @Before
    public void setUp() {
        //set the

    }

    @Rule
    public TestWatcher myReporter = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            ResultReporter saucelabsReporter = new ResultReporter();
            saucelabsReporter.saveTestStatus(Serenity.getCurrentSessionID(), false);
        }

        @Override
        protected void succeeded(Description description) {
            ResultReporter saucelabsReporter = new ResultReporter();
            saucelabsReporter.saveTestStatus(Serenity.getCurrentSessionID(), true);
        }
    };




}
