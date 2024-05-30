package com.example.test_challenge.service;

import com.example.test_challenge.service.problem2.AnimationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;

@SpringBootTest
class AnimationServiceTest {

    @Autowired
    AnimationService animationService;

    @Test
    public void Animation_ex1_ReturnsList() {
        var control = List.of("..X....", "....X..", "......X", ".......");
        var output = animationService.animate(2, "..R....");
        assertLinesMatch(control, output);
    }

    @Test
    public void Animation_ex2_ReturnsList() {
        var control = List.of("XX..XXX", ".X.XX..", "X.....X", ".......");
        var output = animationService.animate(3, "RR..LRL");
        assertLinesMatch(control, output);
    }

    @Test
    public void Animation_ex3_ReturnsList() {
        var control = List.of("XXXX.XXXX", "X..X.X..X", ".X.X.X.X.", ".X.....X.", ".........");
        var output = animationService.animate(2, "LRLR.LRLR");
        assertLinesMatch(control, output);
    }

    @Test
    public void Animation_noParticles_ReturnsList() {
        var control = List.of(".....");
        var output = animationService.animate(10, ".....");
        assertLinesMatch(control, output);
    }
    @Test
    public void Animation_fastParticles_ReturnsList() {
        var control = List.of("XXXXXXXXXX", "..........");
        var output = animationService.animate(10, "RLRLRLRLRL");
        assertLinesMatch(control, output);
    }

    @Test
    public void Animation_ex5_ReturnsList() {
        var control = List.of("XXXX.XX.XXX.X.XXXX.", "..XXX..X..XX.X..XX.", ".X.XX.X.X..XX.XX.XX",
                "X.X.XX...X.XXXXX..X", ".X..XXX...X..XX.X..", "X..X..XX.X.XX.XX.X.", "..X....XX..XX..XX.X",
                ".X.....XXXX..X..XX.", "X.....X..XX...X..XX", ".....X..X.XX...X..X", "....X..X...XX...X..",
                "...X..X.....XX...X.", "..X..X.......XX...X", ".X..X.........XX...", "X..X...........XX..",
                "..X.............XX.", ".X...............XX", "X.................X", "...................");
        var output = animationService.animate(1, "LRRL.LR.LRR.R.LRRL.");
        assertLinesMatch(control, output);
    }
}