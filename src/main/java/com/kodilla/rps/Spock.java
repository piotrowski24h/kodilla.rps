package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;


public final class Spock implements Figure {
    private final String figureName;
    private final List<String> beats = new ArrayList<>();

    public Spock(final String figureName) {
        this.figureName = figureName;
    }

    @Override
    public String getFigureName() {
        return figureName;
    }

    @Override
    public List<String> beats() {
        beats.add(Figures.rock);
        beats.add(Figures.scissors);
        return beats;
    }
}
