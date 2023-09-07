import java.util.Scanner;
 
/**
 * The LadderAndSnake class:
 * 		.creates objects with a board and a number of players as attributes.
 * 		.has the flipDice() method to flip the dice of the game.
 * 		.has a toString method to give a visual support of the board.
 * 		.has the play() method, which allows the players to play the game, and sets their position according to the dice value.
 * @author Rym Bensalem
 */
public class LadderAndSnake {

/**
*  attributes: array (board) and one int value (# players)
*/
	private int[][] board = new int[10][10];
	private int nbOfPlayers;

/**
 * Default constructor
 * Creates an object of type LadderAndSnake with 2 players and the board as a 2D-array
 */
	public LadderAndSnake() {
		this.setNbOfPlayers(2);
		
		// we use 2 for loops in order to fill the array (board) appropriately. 
		for(int i = 8; i>=0; i-=2) {
			for(int j = 0; j < 10; j++) {
				this.board[i][j] = (i*10) + (j+1);
			}
		}
		
		for(int i = 9; i>=0; i-=2) {
			for(int j = 0; j < 10; j++) {
				this.board[i][j] = (i*10) + (10-j);
			}
		}
	}
	
/**
* Constructor with 1 int param.
* Takes 1 int (number of players) and initializes the number of player to 2 if the input is 2 or greater,
* exits the programs if the input is less than 2.
* @param nb an int value (number of player)
*/
	public LadderAndSnake(int nb) {
		
		/**
		 *  if the user enters more than 2 players, the number of players is set to 2.
		 */
		if(nb > 2) {
			System.out.println("Initialization was attempted for " + nb + " members of players; however, this is only " +
					 "expected for an extended version of the game.\nValue will be set to 2.");
		}
		
		/**
		 *  if the user enters less than 2 players, exit program.
		 */
		if(nb < 2) {
			System.out.println("Error: Cannot execute the game with less than 2 players! Will exit");
			System.exit(0);
		}
		
		/**
		 *  if the user enters 2 then the numbers of players is simply set to 2.
		 */
		this.setNbOfPlayers(nb);
		
		/**
		 *  we use 2 for loops in order to fill the array (board) appropriately. 
		 */
		for(int i = 8; i>=0; i-=2) {
			for(int j = 0; j < 10; j++) {
				this.board[i][j] = (i*10) + (j+1);
			}
		}
		
		for(int i = 9; i>=0; i-=2) {
			for(int j = 0; j < 10; j++) {
				this.board[i][j] = (i*10) + (10-j);
			}
		}
	}
	
	
/** 
* Accessor method for the variable nbOfPlayers.
* @return the int value of nbOfPlayers.
*/
	public int getNbOfPlayers() {
		return this.nbOfPlayers;
	}
	
/** 
* Accessor method for an index on the board.
* @param x an int value (1D index)
* @param y an int value (2D index)
* @return the int value of an index on the board
*/
	public int getBoard(int x, int y) {
		return this.board[x][y];
	}
	
/**
 * Mutator method for nbOfPlayers
 * @param x an int value (number of players)
 */
	public void setNbOfPlayers(int x) {
		this.nbOfPlayers = x;
	}
	
/**
 * Mutator method for an index on the board
 * @param x an int value (1D index)
 * @param y an int value (2D index)
 * @param z an int value such that this.board[x][y] = z
 */
	public void setBoard(int x, int y, int z) {
		this.board[x][y] = z;
	}
	
// flipdice()
	
/** 
* Flips the dice.
* @return a random int number from 1 to 6 (dice)
*/
	public static int flipDice() {
		return (int)((Math.random()*6) + 1);
	}

// tostring
	
/** 
* Returns a visual support of the board.
* @return a String of the board
*/
	public String toString() {
		
	String line = "";
	
	// we use the getBoard() method in order to access an index on the board 2D-array.
	for(int i = 9; i >=0; i--) {
		for(int j = 0; j < 10; j++) {
			line += "\t" + this.getBoard(i, j) + "  ";
		}
		line += "\n";
		}
		return line;
	}

// play()
	
/**
* Determines the player's position according to the dice value. 1 player at a time.
* @param p, an object of type Player, the player that is currently playing.
* @param s, an object of type Scanner, we have to close the scanner inside the play() method because we cannot do so in the main method
* because of the while(true) loop.
*/
	public void play(Player p, Scanner s) {
		
		/**
		 *  role the dice.
		 */
		p.setDiceValue(flipDice());
		
		/**
		 *  set the player to its new position.
		 */
		p.setPosition(p.getPosition() + p.getDiceValue()); 
		
		/**
		 *  display dice value.
		 */
		System.out.print("Player " + p.getId() + " got a dice value of " + p.getDiceValue() + "; ");
				
		/**
		 *  if position of player is 100, he wins the game and we exit the program.	
		 */
		if(p.getPosition() == board[9][0]) {
			
		/**
		 *  display message of the player's position (100).
		 */
		System.out.println("now in square " + board[9][0]);
			System.out.println("\n***** PLAYER " + p.getId() + " WON *****"); 
			
			/**
			 *  we close the scanner here because we cannot close it in the main method after a while(true) loop.
			 */
			s.close();
			System.exit(0); 
		}
		
		/**
		 *  if player's position is not 100, it is either less or greater than 100.
		 */
		else {
			
			/**
			 *  if player's position is greater than 100, the player moves backward.
			 */
			if(p.getPosition() > board[9][0]) {
				p.setPosition(board[9][0] - (p.getPosition() - board[9][0]));
				
				/**
				 *  display message of the player's position.
				 */
				System.out.print("now in square ");
				for(int i = 9; i >=0; i--) {
					for(int j = 0; j < 10; j++) { if(p.getPosition() == board[i][j]) System.out.print(board[i][j]); }
					}
				}
			
			/**
			 *  if player's position is less than 100, simply state the position.
			 */
			else {
				/**
				 *  display message of the player's position.
				 */
				System.out.print("now in square ");
				for(int i = 9; i >=0; i--) {
					for(int j = 0; j < 10; j++) { if(p.getPosition() == board[i][j]) System.out.print(board[i][j]); }
				}
			}
			
			/**
			 *  we switch the player's position for the ladders and snakes
			 */
			switch(p.getPosition()) {
			
// LADDERS
			
				// tile 1 --> tile 38
				case 1:		
					p.setPosition(board[3][2]);
					System.out.print("; then up to square " + board[3][2]);
				break;
										
				// tile 4 --> tile 14
				case 4:		
					p.setPosition(board[1][6]);
					System.out.print("; then up to square " + board[1][6]);					
				break;
									
				// tile 9 --> tile 31
				case 9:
					p.setPosition(board[3][9]);
					System.out.print("; then up to square " + board[3][9]);
				break;
									
				// tile 21 --> 42
				case 21:
					p.setPosition(board[4][1]);
					System.out.print("; then up to square " + board[4][1]);	
				break;
				
				// tile 28 --> tile 84						
				case 28:
					p.setPosition(board[8][3]);
					System.out.print("; then up to square " + board[8][3]);		
				break;
								
				// tile 36 --> tile 44
				case 36:
					p.setPosition(board[4][3]);
					System.out.print("; then up to square " + board[4][3]);	
				break;
									
				// tile 51 --> tile 67
				case 51:
					p.setPosition(board[6][6]);
					System.out.print("; then up to square " + board[6][6]);		
				break;
									
				// tile 71 --> tile 91
				case 71:
					p.setPosition(board[9][9]);
					System.out.print("; then up to square " + board[9][9]);	
				break;
					
				/**
				 *  if the player's position is 80, it becomes 100 and the player wins the game. We exit the program.
				 */
				// tile 80 --> tile 100
				case 80:
					p.setPosition(board[9][0]);
					System.out.println("; then up to square " + board[9][0]);	
					System.out.println("\n***** PLAYER " + p.getId() + " WON *****");
					// we close the scanner here because we cannot close it in the main method after a while(true) loop
					s.close();
					System.exit(0);
				break;
									
// SNAKES
							
				// tile 16 --> tile 6
				case 16:		
					p.setPosition(board[0][5]);
					System.out.print("; then down to square " + board[0][5]);
				break;
							
				// tile 79 --> tile 19
				case 79:
					p.setPosition(board[1][1]);
					System.out.print("; then down to square " + board[1][1]);
				break;
								
				// tile 95 --> tile 24
				case 95:
					p.setPosition(board[2][3]);
					System.out.print("; then down to square " + board[2][3]);
				break;
								
				// tile 48 --> tile 30
				case 48:
					p.setPosition(board[2][9]);
					System.out.print("; then down to square " + board[2][9]);
				break;
								
				// tile 64 --> tile 60
				case 64:
					p.setPosition(board[5][0]);
					System.out.print("; then down to square " + board[5][0]);
				break;
							
				// tile 93 --> tile 68
				case 93:
					p.setPosition(board[6][7]);
					System.out.print("; then down to square " + board[6][7]);
				break;
								
				// tile 97 --> tile 76
				case 97:
					p.setPosition(board[7][4]);
					System.out.print("; then down to square " + board[7][4]);
				break;
						
				// tile 98 --> tile 78
				case 98:
					p.setPosition(board[7][2]);
					System.out.print("; then down to square " + board[7][2]);
					
			}	// end of switch().
			
			System.out.println();
			
		} // end of play() method.
		
	} // end of else statement (if player position is 100, else...).
	
} // end of LadderAndSnake class.