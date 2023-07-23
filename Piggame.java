package com.mono.game;

import java.util.Random;


import java.util.Scanner;

public class Piggame {
	private int turns;
    private int currentTurnScore;

    public void DiceGame() {
        turns = 1;
        currentTurnScore = 0;
    }

    public void rollDice() {
        int diceValue = (int) (Math.random() * 6) + 1;
        if (diceValue != 1) {
        	currentTurnScore += diceValue;  
            System.out.println("Die: " + diceValue + ". Current score: " + currentTurnScore);  
        }
        else if(diceValue==1)
        {
      	  currentTurnScore=0;
            System.out.println("Die a 1! Score reset to 0.");
        }
        }
    

    public void hold() {
        turns++;
    	System.out.println("the no of turns:"+turns++);
    	getTotalScore();
        
    }
   

  

    public int getTotalScore() {
        return currentTurnScore;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            Piggame game = new Piggame();
            System.out.println("Let's play the Dice Game!");
            System.out.println("You start with a score of 0.");

            while (true) {
                System.out.println("Current total score: " + game.getTotalScore());
                System.out.println("Do you want to (r)oll or (h)old?");
                String input = scanner.next().toLowerCase();

                if (input.equals("r")) {
                    game.rollDice();
                } else if (input.equals("h")) {
                    game.hold();
                } 

                if (game.getTotalScore() >= 20) {
                    System.out.println("Congratulations! You reached 20 points or more. You win!");
                    break;
                }
            }

            System.out.println("Do you want to play again? (yes/no)");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Thank you for playing!");
    }
}



	


