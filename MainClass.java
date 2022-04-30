import java.util.Scanner;

public class MainClass {
	
	
	public static void main(String[] args) {
		
		
		// Generate the board
		Board b = new Board();
		b.makeBoard();
		// Print out the board
		b.printBoard();
		
		
		// Generate two players with names (the player can input their own names
		Scanner scan = new Scanner(System.in);
		System.out.println("Player 1, please enter your name: ");
		String name1 = scan.next();
		
		System.out.println("Hello! " + name1);
		System.out.println("Player 2, please enter your name: ");
		Scanner scan2 = new Scanner(System.in);
		String name2 = scan2.next();
		System.out.println("Hello! " + name2);

		
		// assign the players' name to the Player object's attribute of name
		Player player1 = new Player(name1, b);
		Player player2 = new Player(name2, b);
		
		
		// Generate the ship. When generating the expanded ship, just change the boolean to true.
		boolean generateExpandedShip = true;
		if(generateExpandedShip == false) {
			b.generateShip();
		}else {
			b.generateExpandedShip();
			player1.setShipNum(6);
		}		
		
		
		// Take Turns to implement the takeTurn method of the player
		while(player1.gameGoing()) {

			// The first player takes turn
			player1.takeTurn();
			// Print out the board and scores for the player to know what's going on
			b.printBoard();
			System.out.println(player1.getName() + ", your score is: " + player1.getScores());
			System.out.println();

			
			// The second player takes turn
			player2.takeTurn();
			// Print out the board and scores for the player to know what's going on
			b.printBoard();
			System.out.println(player2.getName() + ", your score is: " + player2.getScores());
			System.out.println();

		}
		
		
		
		// End the game. Check the winner of the game
		System.out.println("This is the end of the game! Thanks for playing!");
		if(player1.getScores() > player2.getScores()) {
			System.out.println(player1.getName() + " , you are the Winner! Congrats!");
		}else if (player1.getScores() < player2.getScores()) {
			System.out.println(player2.getName() + " , you are the Winner! Congrats!");
		}else {
			System.out.println("This is a draw. Every on got the same score. Well done!");
		}
		
		
	}

}
