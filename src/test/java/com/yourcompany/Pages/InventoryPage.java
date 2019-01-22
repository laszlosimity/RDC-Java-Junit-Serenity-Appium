package com.yourcompany.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@DefaultUrl("https://www.saucedemo.com/inventory.html")
public class InventoryPage extends PageObject {

    public static String PRODUCTLABEL_TEXT = "Products";

    @FindBy(id = "item_4_title_link")
    private WebElement backpackLink;

    public WebElement getProductLabel() {
        return productLabel;
    }

    @FindBy(className = "product_label")
    private WebElement productLabel;

    @FindBy(className="inventory_details_name")
    private WebElement backpackItem;

    public WebDriver driver;
    public static String url = "https://www.saucedemo.com/inventory.html";

    public static InventoryPage visitPage(WebDriver driver) {
        InventoryPage page = new InventoryPage(driver);
        page.visitPage();
        return page;
    }

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }


    public void clickBackpack() {
        this.backpackLink.click();
    }

    public boolean isOnPage() {
        String labelText = PRODUCTLABEL_TEXT;
        return this.productLabel.getText() == labelText;
    }

}
