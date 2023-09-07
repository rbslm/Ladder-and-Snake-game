/**
 * The Player class:
 * 		.creates objects with a position, a diceValue and an id as attributes.
 * 		.has a method to reset the position of a player to zero if both players have the same position.
 * @author Rym Bensalem
 */ 
public class Player {
	
/**
 * attributes: the position, diceValue and Id of the player.
 * we create an Id in order to keep track of which player is playing.
 */
	private int position;
	private int diceValue;
	private int Id;
	
/**
 * Default constructor.
 * Creates an object of type Player and sets the player's position and diceValue to 0.
 */
	public Player() {
		this.position = 0;
		this.diceValue = 0;
	}
	
/**
* Constructor with three int params.
* Creates an object of type Player and sets the player's position, diceValue and Id to the passed values.
* @param position an int value (position of player)
* @param diceValue an int value (diceValue of player)
* @param Id an int value (Id of the player)
*/
	public Player(int position, int diceValue, int Id) {
		this.position = position;
		this.diceValue = diceValue;
		this.Id = Id;
	}

	
/** 
* Accessor method for the variable Id.
* @return the int value of Id.
*/
	public int getId() {
		return this.Id;
	}
	
/** 
* Accessor method for the variable position.
* @return the int value of position.
*/
	public int getPosition() {
		return this.position;
	}
	
/** 
* Accessor method for the variable diceValue.
* @return the int value of diceValue.
*/
	public int getDiceValue() {
		return this.diceValue;
	}
	
/** 
* Mutator method for the variable position.
* @param p an int value, the player's new position.
*/
	public void setPosition(int p) {
		this.position = p;
	}
	
/** 
* Mutator method for the variable diceValue.
* @param d an int value, the player's new diceValue.
*/
	public void setDiceValue(int d) {
		this.diceValue = d;
	}
	
/**
* Takes one object of type Player, resets his position to zero if the player that is currently playing falls on the same tile.
* @param x an object of type Player
*/
	public void sameTile(Player x) {
		if(x.getPosition() == this.getPosition()) {
			x.setPosition(0);
			System.out.println("-----> Player " + this.getId() + " has the same position as Player " + x.getId() + ". " + 
									"Position of player " + x.getId() + " was reset to zero (0)");
		}
	} // end of sameTile() method.

} // end of Player class.