package base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;

/**
 * Base class for API test modules using REST Assured.
 * Provides reusable methods for setting up and executing requests.
 */
public abstract class BaseAPI {

    protected String baseUri;

    /**
     * Constructor to set base URI for the API endpoint group.
     *
     * @param baseUri The base URI for the APIs (e.g., https://api.example.com)
     */
    public BaseAPI(String baseUri) {
        this.baseUri = baseUri;
        RestAssured.baseURI = baseUri;
    }

    /**
     * Builds a generic request specification with common headers and optional query/path params.
     *
     * @param headers Optional headers map
     * @param queryParams Optional query parameters map
     * @return A configured RequestSpecification object
     */
    protected RequestSpecification buildRequest(Map<String, String> headers, Map<String, String> queryParams) {
        RequestSpecification request = RestAssured
                .given()
                .contentType("application/json")
                .accept("application/json");

        if (headers != null) {
            request.headers(headers);
        }
        if (queryParams != null) {
            request.queryParams(queryParams);
        }

        return request;
    }

    /**
     * Executes a GET request.
     *
     * @param endpoint Endpoint path (relative to baseUri)
     * @param headers Optional headers
     * @param queryParams Optional query params
     * @return The response
     */
    protected Response get(String endpoint, Map<String, String> headers, Map<String, String> queryParams) {
        return buildRequest(headers, queryParams)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    /**
     * Executes a POST request.
     *
     * @param endpoint Endpoint path
     * @param headers Optional headers
     * @param body Request payload
     * @return The response
     */
    protected Response post(String endpoint, Map<String, String> headers, Object body) {
        return buildRequest(headers, null)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    /**
     * Executes a PUT request.
     */
    protected Response put(String endpoint, Map<String, String> headers, Object body) {
        return buildRequest(headers, null)
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }

    /**
     * Executes a DELETE request.
     */
    protected Response delete(String endpoint, Map<String, String> headers) {
        return buildRequest(headers, null)
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }
}
