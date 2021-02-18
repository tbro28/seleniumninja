package com.restassured.ch6;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class GoogleMapsAPI {

    private static String KEY;

    /**
     * Static initializer instead of using a method.
     */
    static {
        try (InputStream input = new FileInputStream(
                "src/test/resources/api.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            KEY = prop.getProperty("google.api");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }




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
                .param("key", KEY)
        .when()
                .get("/distancematrix/json")
        .then()
                .statusCode(200);

    }

}
