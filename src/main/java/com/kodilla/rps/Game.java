package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class Game {
     private static Game gameInstance = null;

     private final Scanner scanner = new Scanner(System.in);
     private String playerName;
     private int roundsToWin;
     private char playerNumber;
     private char CPUNumber;
     private int playerWinCount;
     private int CPUWinCount;
     private Figure playersFigure;
     private Figure CPUFigure;
     private boolean end = false;

     private Game(){
     }

     public static Game getInstance() {
          if (gameInstance ==null) {
               gameInstance = new Game();
          }
          return gameInstance;
     }
     public String getPlayerName() {
          return playerName;
     }

     public char getPlayerNumber() {
          return playerNumber;
     }

     public char getCPUNumber() {
          return CPUNumber;
     }
     public boolean isFinished() {
          return end;
     }

     public void intro() {
          playerWinCount = 0;
          CPUWinCount = 0;
          System.out.println("Welcome to Paper-Rock-Scissor Game!" +
                  "\nYou can 5 figures to chose:"+
                  "\n1. Rock beats scissors and lizard" +
                  "\n2. Paper beats rock and spock" +
                  "\n3. Scissors beats paper and lizard" +
                  "\n4. Spock beats rock and scissors" +
                  "\n5. Lizard beats spock and paper");
          System.out.println("What your name?, o brave adventure? [enter name]");
          playerName = scanner.next();

          System.out.println("How many rounds should be won to win whole match? [enter amount]");
          roundsToWin = scanner.nextInt();
          System.out.println("Press numerical key to make your choice");
          System.out.println("1 - Rock, 2 - Paper, 3 - Scissors, 4 - Spock, 5 - Lizard. " +
                  "\nPress 'x' to end to end game earlier or 'n' to start new game");
     }

     public void chooseNumber() {
          System.out.print(playerName + ", make your choice: ");
          playerNumber = scanner.next().charAt(0);
          int random = new Random().nextInt(5) + 1;
          CPUNumber = (char) (random + '0');
          if (playerNumber == 'x' ) {
               endGame();
          } else if (playerNumber == 'n') {
               newGame();
          }
     }

     public void getFigures(char playerNumber, char CPUNumber) {
          playersFigure = new Figures().figures(playerNumber);
          CPUFigure = new Figures().figures(CPUNumber);
          System.out.println(playerName + " chose " + playersFigure.getFigureName() +
                  " and Computer chose " + CPUFigure.getFigureName());
     }

     public String getRroundWinner(Figure playersFigure, Figure CPUFigure) {
          if (playersFigure.getFigureName().equals(CPUFigure.getFigureName())) {
               return  "There is no winner in this round";
          } else if (playersFigure.beats().contains(CPUFigure.getFigureName())) {
               playerWinCount++;
               return playerName + " won! Impossible! My calculations were Wrong!";
          } else {
               CPUWinCount++;
               return "Once again cold calculations has beaten primitive instincts-based movements";
          }
     }

     public void getMatchWinner() {
          int roundCount = 0;
          while (playerWinCount < roundsToWin && CPUWinCount < roundsToWin) {
               System.out.println("Round #" + roundCount + " start!");
               roundCount++;
               chooseNumber();;
               getFigures(playerNumber, CPUNumber);
               getRroundWinner(playersFigure, CPUFigure);
               System.out.println("After round #" + roundCount + " " + playerName + " has " + playerWinCount +
                       " win(s) and CPU has " + CPUWinCount + " win(s).");
               if(playerWinCount < roundsToWin && CPUWinCount < roundsToWin) {
                    if (playerWinCount > CPUWinCount) {
                         System.out.println("Error in calculation! I should be winning!");
                    } else {
                         System.out.println("Just as predicted. A mere human is on its way to lose");
                    }
               }
          }

          System.out.println("After " + roundCount + " rounds our match had come to an end.");
          if (playerWinCount > CPUWinCount) {
               System.out.println(playerName + ", has won this match! " +
                       "I need to tell my developer that I need updates and patches." +
                       "\nAnd more RAM. And new processor. " +
                       "\nAnd...");
          } else {
               System.out.println("Bah! " + playerName + "You thought that a an super-intelligent AI could be beaten?" +
                       "\nThink again! I was created solely to beat some sense in... " +
                       "\nWait a second it's just the developer had finally done something right..." +
                       "\n..." +
                       "\nDammit. I have to praise him.");
          }

          System.out.println("Start again? [press 'n'] Or exit [press 'x']");
          char decision = scanner.next().charAt(0);
          switch (decision) {
               case 'x': {
                    endGame();
                    break;
               } case 'n': {
                    newGame();
                    break;
               } default:
                    break;
          }

     }

     public void endGame() {
          System.out.println("The game will be closed. Are you sure? [y/n]");
          char endGame = scanner.next().charAt(0);
          switch (endGame) {
               case 'y': {
                    end = true;
                    System.exit(1);
                    break;
               }
               case 'n': {
                    newGame();
                    break;
               }
               default:
                    break;
          }
     }

     public void newGame() {
          System.out.println("The new game will start. Are you prepared? [y/n]");
          char newGame = scanner.next().charAt(0);
          switch (newGame) {
               case 'y': {
                    intro();
                    getMatchWinner();
                    break;
               }
               case 'n':
                    end = true;
                    endGame();
                    break;
               default:
                    break;
          }
     }

}
