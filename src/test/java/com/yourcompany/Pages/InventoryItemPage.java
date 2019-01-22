package com.yourcompany.Pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@DefaultUrl("https://www.saucedemo.com/inventory-item?id=")
public class InventoryItemPage extends PageObject {


    @FindBy(className="inventory_details_name")
    private WebElement backpackItem;

    public WebDriver driver;
    public static String url = "https://www.saucedemo.com/inventory-item?id=";

    //Not used - but you could in theory go straight to a specific item for isolated tests if required
    public static InventoryItemPage visitPage(WebDriver driver, String itemId) {
        InventoryItemPage page = new InventoryItemPage(driver);
        page.visitPage(itemId);
        return page;
    }

    public InventoryItemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage(String itemId) {
        this.driver.get(url  + itemId);
    }

    //Verify we are on the details page for the backpack.
    public boolean isOnBackpackPage() {

        return this.backpackItem.getText() == "Sauce Labs Backpack";
    }

}
