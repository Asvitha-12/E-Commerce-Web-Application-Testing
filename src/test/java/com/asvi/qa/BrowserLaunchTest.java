package com.asvi.qa;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.asvi.qa.pages.HomePage;
import com.asvi.qa.pages.ProductsPage;
import org.openqa.selenium.By;


public class BrowserLaunchTest extends BaseTest {

    @Test
    void openECommerceWebsite() {
        HomePage homePage = new HomePage(driver);

        homePage.open();

        String pageTitle = driver.getTitle();

        assertTrue(pageTitle.contains("Automation Exercise"));
    }

    @Test
void verifySearchFieldIsDisplayed() {
    ProductsPage productsPage = new ProductsPage(driver);

    productsPage.open();

    assertTrue(productsPage.isSearchInputDisplayed());
    }

    @Test
void verifySearchTermCanBeEntered() {
    ProductsPage productsPage = new ProductsPage(driver);

    productsPage.open();
    productsPage.enterSearchTerm("shirt");

    assertTrue(
        driver.findElement(org.openqa.selenium.By.id("search_product"))
              .getAttribute("value")
              .equals("shirt")
    );
        }

}