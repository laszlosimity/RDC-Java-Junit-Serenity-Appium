package com.yourcompany.Pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@DefaultUrl("http://www.saucedemo.com/")
public class SauceDemoHomePage extends PageObject {

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(className = "login-button")
    private WebElement submitButton;


    public WebDriver driver;
    public static String url = "https://www.saucedemo.com";

    /*public static SauceDemoHomePage visitPage(WebDriver driver) {
        SauceDemoHomePage page = new SauceDemoHomePage(driver);
        page.visitPage();
        return page;
    }

    public SauceDemoHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }*/

    public void login(String user_name, String password) {
        this.userName.sendKeys(user_name);
        this.password.sendKeys(password);

        submitButton.submit();

    }

    public boolean isOnPage() {
        String title = "Swag Labs";
        return this.driver.getTitle() == title;
    }

}
