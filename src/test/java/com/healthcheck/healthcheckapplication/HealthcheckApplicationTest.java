package com.healthcheck.healthcheckapplication;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HealthcheckApplicationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    ApplicationContext context;

    @Test
    public void test_health() throws JSONException {
        ResponseEntity<String> entity = restTemplate.getForEntity("/healthcheck",String.class);

        HttpStatus statusCode = entity.getStatusCode();
        JSONObject healthCheckBody = new JSONObject(entity.getBody());

        assertThat(statusCode, is(HttpStatus.OK));
        assertThat(healthCheckBody.get("status"), is("UP"));
        assertThat(healthCheckBody.get("details").toString(), containsString("pre-interview technical test"));
    }
}