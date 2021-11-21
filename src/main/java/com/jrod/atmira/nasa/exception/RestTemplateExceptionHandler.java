package com.jrod.atmira.nasa.exception;

import org.json.JSONObject;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * @author Jesús Rodríguez
 */
public class RestTemplateExceptionHandler extends DefaultResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse response) throws IOException, RestTemplateException {
        if (response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError()) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getBody()))) {
                String bodyResponse = reader.lines().collect(Collectors.joining(""));
                JSONObject jsonResponse = new JSONObject(bodyResponse);
                throw new RestTemplateException(jsonResponse.getString("http_error"));
            }
        }
    }
}
