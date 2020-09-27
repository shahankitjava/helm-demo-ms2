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

    @GetMapping(value = "/helm2")
    public @ResponseBody
    HelmResponse greet() {
        System.out.println("===== Method greet called of helm-demo-ms2 =====");
        HelmResponse helmResponse = new HelmResponse();
        helmResponse.setWelcome("Hello from helm-demo-ms2");
        return helmResponse;
    }

    @GetMapping(value = "/helm2/callFromMS1")
    public @ResponseBody
    HelmResponse greetCallFromMS1() {
        System.out.println("===== Method greetCallFromMS1 called of helm-demo-ms2 by helm-demo-ms1 =====");
        HelmResponse helmResponse = new HelmResponse();
        helmResponse.setWelcome("Call came from MS1 and responded from MS2");
        return helmResponse;
    }

    @GetMapping(value = "/helm2/callHelm3")
    public @ResponseBody
    HelmResponse greetHelm3() {
        System.out.println("===== Method greetHelm3 called of helm-demo-ms2 =====");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<HelmResponse> entity = restTemplate.getForEntity(helm3Url, HelmResponse.class);
        return entity.getBody();
    }

}