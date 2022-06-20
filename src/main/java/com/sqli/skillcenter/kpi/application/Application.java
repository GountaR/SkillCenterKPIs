package com.sqli.skillcenter.kpi.application;

import com.sqli.skillcenter.kpi.model.Collaborateur;
import com.sqli.skillcenter.kpi.parser.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Value("${API_client_id_name}")
    private String API_client_id_name;
    @Value("${Authorization_name}")
    private String Authorization_name;
    @Value("${API_client_id_value}")
    private String API_client_id_value;
    @Value("${Authorization_value}")
    private String Authorization_value;
    @Value("${URL_WebService_TBP}")
    private String URL_WebService_TBP;

    @Value("${Activity_value}")
    private String Activity_value;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {

            HttpHeaders header = buildHeader();
            HttpEntity requestHeader = new HttpEntity(header);
            ResponseEntity<String> response = restTemplate.exchange(
                    URL_WebService_TBP+Activity_value, HttpMethod.GET, requestHeader, String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                log.info("Request Successful");
                ArrayList< Collaborateur> collabs = JsonParser.getCollabsFromJson(response.getBody().toString());
                for (Collaborateur collab:
                     collabs) {
                    log.info(collab.toString());
                }
            } else {
                log.error("Request Failed");
                log.error(response.getStatusCode().toString());
            }
        };
    }

    private HttpHeaders buildHeader(){
        log.debug("in buildHeader");
        log.debug(API_client_id_name);
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set(API_client_id_name,API_client_id_value);
        header.set(Authorization_name,Authorization_value);
        return header;
    }

}