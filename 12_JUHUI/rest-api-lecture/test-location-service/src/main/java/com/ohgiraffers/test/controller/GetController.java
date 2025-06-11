package com.ohgiraffers.test.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class GetController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name) {
        return "Hello " + name;
    }

    @PostMapping("/hello")
    public String helloPost(@RequestBody Map<String, String> data) {
        return "Recived: " + data.get("message");
    }

    @PutMapping("/hello/{id}")
    public String updateHello(@PathVariable String id, @RequestBody Map<String, String> data) {
        return "Updated " + id + " with " + data.get("name");
    }

    @DeleteMapping("/hello/{id}")
    public String deleteHello(@PathVariable String id) {
        return "Deleted " + id;
    }
}
