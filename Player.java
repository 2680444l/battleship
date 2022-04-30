import java.util.Scanner;

public class Player {
	
	// public attributes
	private static int shipLeft = 5;
	
	
	// attributes
	private Board playerBoard;
	private String name;
	private int scores = 0;
	
	
	// constructor, get in the name and linked board
		public Player(String name, Board playerBoard) {
			this.name = name;
			this.playerBoard = playerBoard;
		}

	
	// getters and setters of the attributes
	public static int getShipNum() {
		return shipLeft;
	}
	public static void setShipNum(int shipNum) {
		Player.shipLeft = shipNum;
	}
	public Board getPlayerBoard() {
		return playerBoard;
	}
	public void setPlayerBoard(Board playerBoard) {
		this.playerBoard = playerBoard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScores() {
		return scores;
	}
	public void setScores(int scores) {
		this.scores = scores;
	}

	
	
	// Set the printing of the player
	public String toString() {
		return this.name;
	}
	


	// takeTurn() method
	public void takeTurn() {
		
		// players input guesses from the console
		Scanner scan = new Scanner(System.in);
		System.out.println(this.getName() + ", please enter your guess (two integer numbers and seperate them with a space): ");
		int x = scan.nextInt();
		int y = scan.nextInt();
		scan.nextLine();
		
		
		// Check the guess and get the scoring system going
		Square guess = this.getPlayerBoard().getBoard()[x][y]; // name the attribute guess to avoid repetition
		
		if((guess.isHasShip() == true && guess.isShotFired() == true) || guess.isShotFired() == true) { // when the exact square is guessed, the player lose the turn
			System.out.println("Sorry, someone has already made the same guess... You lost your turn...");
			guess.setShotFired(true);
		} else if(guess.isHasShip() == true){ // when the guess is correct, decrease the ship's health and when the ship health is zero, the player gets a point
			System.out.println("Good guess! You have decreased the ship's health!");
			guess.getShip().decreaseHealth();
			guess.setShotFired(true);
			if(guess.getShip().getHealth() == 0) {
				guess.getShip().setSunk(true);
				shipLeft -= 1; // count how many ships are left to know when to end the game
				System.out.println("Congrats! You've sunk a battleship and got one score!");
				System.out.println("There are " + shipLeft + " ships left.");
				this.scores += 1;
			}
		}else { // when the guess is incorrect
			guess.setShotFired(true);
			System.out.println("Sorry you didn't hit the ship.");

		}
		
	}
	
	
	// If this is true, the while loop will keep going in the main method. 
	// If false (when there are no ships left in the game) then stop the while loop in the main method
	public boolean gameGoing() {
		// boolean return true or false
		if(shipLeft == 0) {
			// return true when all the battleships are sunk
			return false;
		}else {
			// normally return false so that players can always take turns
			return true;
		}
	}
	
			
	

	
	
	
	
}
