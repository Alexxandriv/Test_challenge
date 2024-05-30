package com.example.test_challenge.service.problem2;

public class Particle {
    int position;
    Character direction;

    public Particle(int position, Character direction) {
        this.position = position;
        this.direction = direction;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Character getDirection() {
        return direction;
    }

    public void setDirection(Character direction) {
        this.direction = direction;
    }
}
