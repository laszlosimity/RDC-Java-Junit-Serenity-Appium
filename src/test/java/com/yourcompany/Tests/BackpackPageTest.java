package com.yourcompany.Tests;

import com.yourcompany.Steps.BackpackSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;


import static org.junit.Assert.assertFalse;

public class BackpackPageTest extends TestBase {


    @Steps
    private BackpackSteps steps;


    @Test
    public void should_be_able_to_click_backpack_item() {
        steps.login("standard_user", "secret_sauce");
        steps.click_backpack_item();
        assertFalse(steps.verify_at_backpack_page());
    }
}