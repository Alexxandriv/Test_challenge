package com.example.test_challenge.service;

import com.example.test_challenge.service.problem1.MissingLettersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class MissingLettersServiceTest {

    @Autowired
    private MissingLettersService missingLettersService;

    @Test
    public void MissingLetters_okPhrase_ReturnsEmptyString() {
        String input = "A quick brown fox jumps over the lazy dog";
        String missingLetters = missingLettersService.findMissingLetters(input);
        assertEquals("", missingLetters);
    }
    @Test
    public void MissingLetters_notOkPhrase_ReturnsEmptyString(){
        String input = "A slow yellow fox crawls under the proactive dog";
        String missingLetters = missingLettersService.findMissingLetters(input);
        assertEquals("bjkmqz", missingLetters);
    }
    @Test
    public void MissingLetters_exclamationPhrase_ReturnsEmptyString(){
        String input = "Lions, and tigers, and bears, oh my!";
        String missingLetters = missingLettersService.findMissingLetters(input);
        assertEquals("cfjkpquvwxz", missingLetters);
    }
    @Test
    public void MissingLetters_empty_ReturnsEmptyString(){
        String input = "";
        String missingLetters = missingLettersService.findMissingLetters(input);
        assertEquals("abcdefghijklmnopqrstuvwxyz", missingLetters);
    }

    @Test
    public void MissingLetters_veryLongString_ReturnsEmptyString(){
        String input = "ññññññññññ++++++++++++++++++++++++++++++++++++++++++++++}}}+-?._,ñlsd,añ,dña,sdasmdpmdpasmdopmasdmpsadmabcdefghijklmnopqrstuvwxyz";
        String missingLetters = missingLettersService.findMissingLetters(input);
        assertEquals("", missingLetters);
    }


}