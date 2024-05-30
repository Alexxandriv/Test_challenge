package com.example.test_challenge.service.problem2;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AnimationService {
    /**
     * generate the animation process
     *
     * @param speed        the constant of movement for the objects
     * @param initialState the string representing the original state
     * @return a list of "frames" meanwhile the objects are on lens
     */
    public List<String> animate(final int speed, String initialState) {
        final int len = initialState.length();
        List<String> Frames = new ArrayList<>();
        Frames.add(initialState.replace('R', 'X').replace('L', 'X'));
        List<Particle> possibilities = setStart(initialState, len);
        while (!possibilities.isEmpty()) {
            calculateMovement(possibilities, speed);
            possibilities = possibilities.stream().filter(x -> x.getPosition() >= 0 && x.getPosition() < len).toList();
            Frames.add(printFrame(possibilities, len));
        }
        return Frames;
    }

    /**
     * generates the frame, showing the avaliable and occupied places for each moment
     *
     * @param possibilities the visible objects on th e linear chamber
     * @param len           the size of the chamber
     * @return string representation meaning the position of the objects
     */
    private String printFrame(List<Particle> possibilities, int len) {
        char[] frame = new char[len];
        Arrays.fill(frame, '.');
        for (Particle p : possibilities) {
            frame[p.getPosition()] = 'X';
        }
        return String.valueOf(frame).replaceAll("[\\[\\],]", "");
    }

    /**
     * calculates the movement inside the chamber for each object
     *
     * @param possibilities the list of objects on the chamber
     * @param speed         the constant of movement
     */
    private void calculateMovement(List<Particle> possibilities, int speed) {
        possibilities.forEach(x -> {
            if (x.getDirection() == 'R') x.setPosition(x.getPosition() + speed);
            else x.setPosition(x.getPosition() - speed);
        });

    }

    /**
     * converts the initial input representation into objects
     *
     * @param initialState the original input
     * @param len          the size of the chamber
     * @return list of particles representation
     */
    private List<Particle> setStart(String initialState, int len) {
        List<Particle> state = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (initialState.charAt(i) == 'R' || initialState.charAt(i) == 'L') {
                state.add(new Particle(i, initialState.charAt(i)));
            }
        }
        return state;
    }
}
