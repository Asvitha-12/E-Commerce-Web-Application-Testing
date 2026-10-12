
package com.asvi.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

    private WebDriver driver;

    private By searchInput = By.id("search_product");
    private By searchButton = By.id("submit_search");
    private By productInformation = By.cssSelector(".productinfo p");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://automationexercise.com/products");
    }

    public boolean isSearchInputDisplayed() {
        return driver.findElement(searchInput).isDisplayed();
    }

    public void enterSearchTerm(String searchTerm) {
        driver.findElement(searchInput).sendKeys(searchTerm);
    }

    public void clearSearchField() {
        driver.findElement(searchInput).clear();
    }

    public String getSearchFieldValue() {
        return driver.findElement(searchInput).getAttribute("value");
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void waitForSearchResults() {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        productInformation
                )
        );
    }

    public void waitForSearchUrl(String searchTerm) {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.urlContains("search=" + searchTerm)
        );
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean hasMatchingProduct(String searchTerm) {
        return driver.findElements(productInformation)
                .stream()
                .anyMatch(element ->
                        element.getText()
                                .toLowerCase()
                                .contains(searchTerm.toLowerCase())
                );
    }

    public boolean hasNoProductsDisplayed() {
        return driver.findElements(productInformation).isEmpty();
    }
}
