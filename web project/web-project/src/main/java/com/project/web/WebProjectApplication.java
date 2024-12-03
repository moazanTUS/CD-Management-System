package com.project.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import com.project.web.CDRequest;

@SpringBootApplication
@RestController
@RequestMapping(value="cdstore")
public class WebProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebProjectApplication.class, args);
    }

    @GetMapping(value="/cds")
    public String getAllCDs() {
        // Logic to fetch all CDs from the database and return JSON response
        return "{\"message\":\"Retrieving all CDs\"}";
    }

    @PostMapping(value="/cd")
    public String addCD(@RequestBody CDRequest request) {
        // Logic to add a CD to the database using the request body
        return String.format("{\"message\":\"Added CD - %s by %s\"}", request.getTitle(), request.getArtist());
    }

    @DeleteMapping(value="/cd/{id}")
    public String deleteCD(@PathVariable("id") Long id) {
        // Logic to delete a CD from the database based on the provided ID
        return String.format("{\"message\":\"Deleted CD with ID - %d\"}", id);
    }
}
