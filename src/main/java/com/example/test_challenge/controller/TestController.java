package com.example.test_challenge.controller;

import com.example.test_challenge.DTO.Problem1Input;
import com.example.test_challenge.DTO.Problem2Input;
import com.example.test_challenge.service.problem1.MissingLettersService;
import com.example.test_challenge.service.problem2.AnimationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    AnimationService animationService;
    @Autowired
    MissingLettersService missingLettersService;


    @GetMapping("/problem1")
    public ResponseEntity<Object> MissingLettersService(@RequestBody Problem1Input phrase) {
        if (phrase.getPhrase() != null) {
            return ResponseEntity.ok(missingLettersService.findMissingLetters(phrase.getPhrase()));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error on the information provided, please check ");
        }
    }

    @GetMapping("/problem2")
    public ResponseEntity<Object> AnimationChamberService(@RequestBody Problem2Input status) {
        if (status.getInitialValues() != null && status.getSpeed() != null) {
            return ResponseEntity.ok(animationService.animate(status.getSpeed(), status.getInitialValues()));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error on the information provided, please check ");
        }
    }

}
