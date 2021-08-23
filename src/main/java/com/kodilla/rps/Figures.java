package com.kodilla.rps;

import java.awt.print.Paper;

public class Figures {

    public static final String rock = "ROCK!";
    public static final String paper = "PAPER!";
    public static final String scissors = "SCISSORS!";
    public static final String spock = "SPOCK!";
    public static final String lizard = "LIZARD!";

    public final Figure figures(char figureNumber) {
        switch (figureNumber) {
            case '1':
                return new Rock(rock);
            case '2':
                return new Paper(paper);
            case '3':
                return new Scissors(scissors);
            case '4':
                return new Spock(spock);
            case '5':
                return new Lizard(lizard);
            default:
                return null;
        }
    }
}
