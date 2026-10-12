
package com.asvi.qa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.asvi.qa.pages.ProductsPage;

public class ProductSearchTest extends BaseTest {

    @Test
    void verifyProductSearch() {
        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.open();
        productsPage.enterSearchTerm("shirt");
        productsPage.clickSearchButton();
        productsPage.waitForSearchUrl("shirt");
        productsPage.waitForSearchResults();

        assertTrue(
            productsPage.getCurrentUrl().contains("search=shirt"),
            "Search URL should contain the submitted search term"
        );

        assertTrue(
            productsPage.hasMatchingProduct("shirt"),
            "Search results should contain a product matching 'shirt'"
        );
    }

    @Test
    void verifySearchWithNoMatchingProducts() {
        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.open();
        productsPage.enterSearchTerm("zztestproduct987");
        productsPage.clickSearchButton();
        productsPage.waitForSearchUrl("zztestproduct987");

        assertTrue(
            productsPage.getCurrentUrl().contains("search=zztestproduct987"),
            "Search URL should contain the submitted search term"
        );

        assertTrue(
            productsPage.hasNoProductsDisplayed(),
            "No product information should be displayed for a search with no matches"
        );
    }

    @Test
    void verifyProductSearchWithAnotherTerm() {
        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.open();
        productsPage.enterSearchTerm("dress");
        productsPage.clickSearchButton();
        productsPage.waitForSearchUrl("dress");
        productsPage.waitForSearchResults();

        assertTrue(
            productsPage.getCurrentUrl().contains("search=dress"),
            "Search URL should contain the submitted search term"
        );

        assertTrue(
            productsPage.hasMatchingProduct("dress"),
            "Search results should contain a product matching 'dress'"
        );
    }

    @Test
    void verifySearchWithEmptyTerm() {
        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.open();
        productsPage.clickSearchButton();

        assertTrue(
            productsPage.getCurrentUrl().contains("/products"),
            "The user should remain on the products page after an empty search"
        );
    }

    @Test
    void verifySearchFieldCanBeCleared() {
        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.open();
        productsPage.enterSearchTerm("shirt");
        productsPage.clearSearchField();

        assertEquals(
            "",
            productsPage.getSearchFieldValue(),
            "Search field should be empty after clearing it"
        );
    }
}
