package com.sirafonso.e_library_users.adapters.out;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sirafonso.e_library_users.core.domain.dtos.response.ResponseBody;
import com.sirafonso.e_library_users.core.ports.out.http.HttpRequestOutputPort;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpRequest implements HttpRequestOutputPort {

    private RestTemplate restTemplate;
    private HttpHeaders httpHeaders;
    private ObjectMapper objectMapper;

    public HttpRequest() {
        this.httpHeaders = new HttpHeaders();
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();

        this.setHeaders();
    }

    private void setHeaders() {
        this.httpHeaders.add("Accept", "application/json");
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    }

    @Override
    public String sendGetRequest(String url) {
        return "";
    }

    @Override
    public ResponseBody sendPostRequest(String url, Object payload) throws Exception {
        try {
            String jsonBody = this.objectMapper.writeValueAsString(payload);
            HttpEntity<String> requestHttp = new HttpEntity<>(jsonBody, this.httpHeaders);
            ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.POST, requestHttp, Object.class);

            return this.formatResponse(response);
        } catch (Exception e) {
            throw new Exception("deu ruim");
        }
    }

    private ResponseBody formatResponse(ResponseEntity<Object> response) {
        System.out.println("type of body " + response.getBody().getClass().getName());
        return new ResponseBody(response.getStatusCode().value(), response.getBody());
    }
}
