package com.yourcompany.Tests;

import com.yourcompany.Steps.BackpackSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.openqa.selenium.InvalidElementStateException;

import static org.junit.Assert.assertFalse;

public class LoginTest extends TestBase {


    @Steps
    private BackpackSteps steps;


    /**
     * Runs a simple test logging into the Swag Labs demo page.
     * @throws InvalidElementStateException
     */
    @Test
    public void should_be_able_to_login() {
        steps.login("standard_user", "secret_sauce");
        assertFalse(steps.verify_logged_in());
    }
}