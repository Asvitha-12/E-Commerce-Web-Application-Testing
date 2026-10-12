package com.asvi.qa.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private static final String HOME_PAGE_URL = "https://automationexercise.com/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(HOME_PAGE_URL);
    }
}