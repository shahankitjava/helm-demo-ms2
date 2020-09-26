package com.aa.helm.helmdemoms2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class HelloController {

    @Value("${helm3.url}")
    private URI helm3Url;

    @GetMapping(value = "/")
    public @ResponseBody
    HelmResponse greet() {
        HelmResponse helmResponse = new HelmResponse();
        helmResponse.setWelcome("Hello from helm-demo-ms2");
        return helmResponse;
    }

    @GetMapping(value = "/callHelm3")
    public @ResponseBody
    HelmResponse greetHelm3() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<HelmResponse> entity = restTemplate.getForEntity(helm3Url, HelmResponse.class);
        return entity.getBody();
    }

}