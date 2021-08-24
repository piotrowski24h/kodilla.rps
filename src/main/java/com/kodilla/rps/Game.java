package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class Game {
     private static Game gameInstance = null;

     private final Scanner scanner = new Scanner(System.in);
     private String playerName;
     private int roundsToWin;
     private char playerNumber;
     private char ProcessorNumber;
     private int playerWin;
     private int ProcessorWin;
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

     public char getProcessorNumber() {
          return ProcessorNumber;
     }
     public boolean isFinished() {
          return end;
     }

     public void intro() {
          playerWin = 0;
          ProcessorWin = 0;
          System.out.println("Welcome to Paper-Rock-Scissor Game!" +
                  "\nYou can 5 figures to chose:"+
                  "\n1. Rock beats scissors and lizard" +
                  "\n2. Paper beats rock and spock" +
                  "\n3. Scissors beats paper and lizard" +
                  "\n4. Spock beats rock and scissors" +
                  "\n5. Lizard beats spock and paper");
          System.out.println("What your name?, o brave adventure? [enter name]");
          playerName = scanner.next();

          System.out.println("How many rounds would like be won to win ? [enter amount]");
          roundsToWin = scanner.nextInt();
          System.out.println("Press numerical key to make your choice");
          System.out.println("1 - Rock, 2 - Paper, 3 - Scissors, 4 - Spock, 5 - Lizard. " +
                  "\nPress 'x' to end to end game earlier or 'y' to start new game");
     }

     public void chooseNumber() {
          System.out.print(playerName + ", make your choice: ");
          playerNumber = scanner.next().charAt(0);
          int random = new Random().nextInt(5) + 1;
          ProcessorNumber = (char) (random + '0');
          if (playerNumber == 'x' ) {
               endGame();
          } else if (playerNumber == 'y') {
               newGame();
          }
     }

     public void getFigures(char playerNumber, char ProcessorNumber) {
          playersFigure = new Figures().figures(playerNumber);
          CPUFigure = new Figures().figures(ProcessorNumber);
          System.out.println(playerName + " chose " + playersFigure.getFigureName() +
                  " and Computer chose " + CPUFigure.getFigureName());
     }

     public String getRroundWinner(Figure playersFigure, Figure CPUFigure) {
          if (playersFigure.getFigureName().equals(CPUFigure.getFigureName())) {
               return  "There is no winner in this round";
          } else if (playersFigure.beats().contains(CPUFigure.getFigureName())) {
               playerWin++;
               return playerName + " won! Impossible! Great!";
          } else {
               ProcessorWin++;
               return "It will be better next time";
          }
     }

     public void getMatchWinner() {
          int roundCount = 0;
          while (playerWin < roundsToWin && ProcessorWin < roundsToWin) {
               System.out.println("Round #" + roundCount + " start! GO!");
               roundCount++;
               chooseNumber();;
               getFigures(playerNumber, ProcessorNumber);
               getRroundWinner(playersFigure, CPUFigure);
               System.out.println("After round #" + roundCount + " " + playerName + " has " + playerWin +
                       " win(s) and Processor has " + ProcessorWin + " win(s).");
               if(playerWin < roundsToWin && ProcessorWin < roundsToWin) {
                    if (playerWin > ProcessorWin) {
                         System.out.println("Error in GAME! I should be YES YES !");
                    } else {
                         System.out.println("Try again");
                    }
               }
          }

          System.out.println("After " + roundCount + " rounds our match had come to an end.");
          if (playerWin > ProcessorWin) {
              System.out.println(playerName + ", has won this match! " +
                       "I need to tell my developerJava that should updates ." +
                      "\nand Wait wait a moment " +
                       "\nAnd...");
          } else {
              System.out.println("Aya! " + playerName + "This is comodoro the best PCU!" +
                      "\nagain please!  " +
                      "\n..." +
                       "\nWait!");
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
          System.out.println("The game will be finish. Are you sure? [y/n]");
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
          System.out.println("The new game will start. Are you ready? [y/n]");
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
