package com.example.controller;

import com.example.service.DummyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dummy")
public class DummyController {

    private final DummyService dummyService;

    public DummyController(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    @GetMapping
    public @ResponseBody ResponseEntity<Long> getCount() {
        Long dbCount = dummyService.count();
        return ResponseEntity.ok(dbCount);
    }
}
