package com.restassured.ch6;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class GoogleMapsAPI {


    @BeforeClass
    public void setUp() {

        io.restassured.RestAssured.baseURI = "https://maps.googleapis.com";
        io.restassured.RestAssured.basePath = "/maps/api";



    }

    @Test
    public void testRestApi() {

        given()
                .param("units", "imperial")
                .param("origins", "Seattle,WA")
                .param("destination", "Portland,OR")
                .param("key", "AIzaSyCkuTZAh86A5xLrFBamtnHR95K_t568ebc")
        .when()
                .get("/distancematrix/json")
        .then()
                .statusCode(200);

    }

}
