import java.util.Scanner;

/**
 * The PlayLadderAndSnake class is where the game takes place.
 * We create 1 object of type LadderAndSnake and 2 objects of type Player.
 * We give a visual support of the board.
 * The games starts by determining the starting player.
 * @author Rym Bensalem
 */

public class PlayLadderAndSnake {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		/**
		 * prompt the user to enter the number of players for the game
		 */
		System.out.print("Enter the number of players that you need to play the game with --> ");
		int nbOfPlayers = s.nextInt();
		
		/**
		 * create an object of type LadderAndSnake.
		 */
		LadderAndSnake game = new LadderAndSnake(nbOfPlayers);
		
		/**
		 * create two objects of type Player with Ids 1 and 2, respectively.
		 */
		Player player1 = new Player(0, 0, 1);
		Player player2 = new Player(0, 0, 2);
		
		/**
		 * print the visual support of the board.
		 */
		System.out.println("\nHere is the board:");
		System.out.println(game);
		
		
// starting player
		
		System.out.println("Now deciding which player will start playing:\n");
		
		/**
		 *  keep track of the number of attempts.
		 */
		int count = 1;
		
		/**
		 * create a while loop that runs until both players have different dice values so that the game can start.
		 * play the game right after.
		 */
		while(true) {
			player1.setDiceValue(LadderAndSnake.flipDice());
			player2.setDiceValue(LadderAndSnake.flipDice());
			
			/**
			 * if player1 has a greater dice value than player2, player1 starts the game.
			 */
			if(player1.getDiceValue() > player2.getDiceValue()) {
				System.out.println("Player 1 got a dice value of " + player1.getDiceValue());
				System.out.println("Player 2 got a dice value of " + player2.getDiceValue() + "\n");
				System.out.println("Reached final decision on order of playing: Player 1 then Player 2.");
				System.out.println("It took " + count + " attempts before a decision could be made\n");
				player1.setDiceValue(0);
				player2.setDiceValue(0);

				/**
				 * while loop to allow the user to press enter for each turn.
				 * the game starts until one player wins. 
				 * exits the program and close the scanner inside the play() method of the LadderAndSnake class.
				 */
				while(true) {
				s.nextLine();
				
				/**
				 * player1's turn
				 */
				game.play(player1, s);
				/**
				 * each turn, we check if both players have the same position and reset to 0 the position of the appropriate player.
				 */
				player1.sameTile(player2);
				
				/**
				 * player2's turn
				 */
				game.play(player2, s);
				player2.sameTile(player1);
			 	
				System.out.println("-----> Game not over, press enter to flip again");
				} // end of second while loop
			}
			
			
			/**
			 * if player2 has a greater dice value than player1, player2 starts the game.
			 */
			else if (player1.getDiceValue() < player2.getDiceValue()) {
				System.out.println("Player 1 got a dice value of " + player1.getDiceValue());
				System.out.println("Player 2 got a dice value of " + player2.getDiceValue() + "\n");
				System.out.println("Reached final decision on order of playing: Player 2 then Player 1.");
				System.out.println("It took " + count + " attempts before a decision could be made\n");
				player1.setDiceValue(0);
				player2.setDiceValue(0);
				
				/**
				 * while loop to allow the user to press enter for each turn.
				 * the game starts until one player wins. 
				 * exits the program and close the scanner inside the play() method of the LadderAndSnake class.
				 */
				while(true) {
				s.nextLine();
				
				/**
				 * player2's turn
				 */
				game.play(player2, s);
				/**
				 * each turn, we check if both players have the same position and reset to 0 the position of the appropriate player.
				 */
				player2.sameTile(player1);
				
				/**
				 * player1's turn
				 */
				game.play(player1, s);
				player1.sameTile(player2);
				
				System.out.println("-----> Game not over, press enter to flip again");
				}
				
			}
			
			/**
			 * display the players' diceValue if they have the same. 
			 * flip the dice again.
			 */
			System.out.println("Player 1 got a dice value of " + player1.getDiceValue());
			System.out.println("Player 2 got a dice value of " + player2.getDiceValue());
			System.out.println("\nA tie was achieved between Player 1 and Player 2. Attempting to break the tie\n");
			
			/**
			 * increment count by 1 each time to keep track of the number of attempts.
			 */
			count++;
		
		} // end of while loop
		
	} // end of main method

} // end of PlayLadderAndSnake class