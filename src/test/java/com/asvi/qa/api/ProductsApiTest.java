
package com.asvi.qa.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductsApiTest {

    private static final String BASE_URL =
            "https://dummyjson.com";

    @Test
    void verifyGetProductsReturnsSuccess() {
        given()
            .baseUri(BASE_URL)
        .when()
            .get("/products")
        .then()
            .statusCode(200)
            .contentType(containsString("application/json"))
            .body("products", not(empty()));
    }

    @Test
    void verifyGetProductsReturnsProductDetails() {
        var response =
            given()
                .baseUri(BASE_URL)
            .when()
                .get("/products")
            .then()
                .statusCode(200)
                .extract()
                .response();

        assertNotNull(response.jsonPath().getList("products"));

        response.then()
            .body("products[0].id", notNullValue())
            .body("products[0].title", not(emptyOrNullString()))
            .body("products[0].price", notNullValue())
            .body("products[0].category", not(emptyOrNullString()));
    }

    @Test
    void verifyGetProductByIdReturnsProductDetails() {
        given()
            .baseUri(BASE_URL)
        .when()
            .get("/products/1")
        .then()
            .statusCode(200)
            .contentType(containsString("application/json"))
            .body("id", equalTo(1))
            .body("title", not(emptyOrNullString()))
            .body("price", notNullValue())
            .body("category", not(emptyOrNullString()));
    }

    @Test
    void verifyGetNonExistingProductReturnsEmptyBody() {
        given()
            .baseUri(BASE_URL)
        .when()
            .get("/products/999999")
        .then()
            .statusCode(404)
            .body("message", not(emptyOrNullString()));
    }

    @Test
    void verifyCreateProductReturnsCreatedProduct() {
        String requestBody = """
                {
                    "title": "QA Automation Test Product",
                    "price": 29.99,
                    "description": "Product created for API automation testing",
                    "category": "beauty"
                }
                """;

        given()
            .baseUri(BASE_URL)
            .contentType("application/json")
            .body(requestBody)
        .when()
            .post("/products/add")
        .then()
            .statusCode(201)
            .body("id", notNullValue())
            .body("title", equalTo("QA Automation Test Product"))
            .body("price", equalTo(29.99f));
    }

    @Test
    void verifyUpdateProductReturnsUpdatedDetails() {
        String requestBody = """
                {
                    "title": "Updated QA Automation Product",
                    "price": 39.99,
                    "description": "Updated product for API testing",
                    "category": "beauty"
                }
                """;

        given()
            .baseUri(BASE_URL)
            .contentType("application/json")
            .body(requestBody)
        .when()
            .put("/products/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("title", equalTo("Updated QA Automation Product"))
            .body("price", equalTo(39.99f));
    }

    @Test
    void verifyDeleteProductReturnsSuccess() {
        given()
            .baseUri(BASE_URL)
        .when()
            .delete("/products/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1));
    }
}
