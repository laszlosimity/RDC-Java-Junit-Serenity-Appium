package com.yourcompany.Steps;

import com.yourcompany.Pages.InventoryItemPage;
import com.yourcompany.Pages.InventoryPage;
import com.yourcompany.Pages.SauceDemoHomePage;
import net.thucydides.core.annotations.Step;

public class BackpackSteps {

    InventoryItemPage invItemPage;
    SauceDemoHomePage homePage;
    InventoryPage invPage;

    @Step
    public void login(String username, String password) {
        homePage.open();
        homePage.login(username, password);
    }

    @Step
    public void click_backpack_item() {
        invPage.clickBackpack();
    }

    @Step
    public boolean verify_logged_in() {
        return invPage.isOnPage();
    }

    @Step
    public boolean verify_at_backpack_page() {
        return invItemPage.isOnBackpackPage();
    }

}
