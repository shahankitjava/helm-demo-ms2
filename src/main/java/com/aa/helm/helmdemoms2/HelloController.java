package com.aa.helm.helmdemoms2;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

	@Value("${helm3.url}")
	private URI helm3Url;

	@GetMapping(value = "/helm2/{id}")
	public @ResponseBody HelmResponse greet(@PathVariable String id) {
		HelmResponse helmResponse = new HelmResponse();
		helmResponse.setWelcome("Helm 2 - Demo MS 2 : " + id);
		return helmResponse;
	}

	@GetMapping(value = "/callHelm3")
	public @ResponseBody HelmResponse greetHelm3() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<HelmResponse> entity = restTemplate.getForEntity(helm3Url, HelmResponse.class);
		return entity.getBody();
	}

}