package com.aa.helm.helmdemoms2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

@GetMapping(value="/helm2/{id}")
public @ResponseBody HelmResponse greet(@PathVariable String id) {
    HelmResponse helmResponse = new HelmResponse();
    helmResponse.setWelcome("Helm 2 - Demo MS 2 : " + id);
    return helmResponse;
}

}