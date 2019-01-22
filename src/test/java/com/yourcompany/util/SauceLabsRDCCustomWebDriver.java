package com.yourcompany.util;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

public class SauceLabsRDCCustomWebDriver implements DriverSource {

    @Override
    public WebDriver newDriver() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            //alter to https://us1.appium.testobject.com:443/wd/hub for USA datacentre
            String url = "https://eu1.appium.testobject.com:443/wd/hub";

            EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

            String platformName = variables.getProperty("saucelabs_platformName");
            if (platformName == null) {
                platformName = "Android"; //default
                System.out.println("Default to Android - please set saucelabs_platformName in serenity.properties");
            }

            String testObjectKey = variables.getProperty("saucelabs_testobject_api_key");
            if (testObjectKey == null) //this is really fatal
            {
                throw new Error("You MUST set testobject_api_key in your serenity.properties file");
            }

            Iterator myIt = variables.getKeys().iterator();

            while(myIt.hasNext()) {
                String currentEl = (String) myIt.next();

                if (currentEl.equalsIgnoreCase("saucelabs_platformName") || currentEl.equalsIgnoreCase("saucelabs_testobjectkey")) {
                    continue;
                }
                else if (currentEl.startsWith("saucelabs_")) {
                    capabilities.setCapability(currentEl.replace("saucelabs_", ""), variables.getProperty(currentEl));
                }

            }

            capabilities.setCapability(CapabilityType.PLATFORM_NAME, platformName);
            capabilities.setCapability("testobject_api_key", testObjectKey);

            return new RemoteWebDriver(new URL(url), capabilities);

        }
        catch (IOException e) {
            throw new Error(e);
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
