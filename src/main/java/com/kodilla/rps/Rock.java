package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;

public final class Rock implements Figure {
    private final String figureName;
    private List<String> beats = new ArrayList<>();

    public Rock(final String figureName) {
        this.figureName = figureName;
    }

    @Override
    public String getFigureName() {
        return figureName;
    }

    @Override
    public List<String> beats() {
        beats.add(Figures.scissors);
        beats.add(Figures.lizard);
        return beats;
    }


}
