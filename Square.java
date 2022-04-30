
public class Square {
	// attributes that a Square Object owns
	private int row;
	private int column;
	private boolean hasShip;
	private Battleship shipOnSquare; // reference to battleship! In this way we can count when a ship is sunk
	private boolean shotFired;
	
    // Constructor of the ship
    public Square(int row, int column) {
    	// set the default value
    	this.row = row;
    	this.column = column;
    	this.hasShip = false;
    	this.shotFired = false;
    	this.shipOnSquare = null;
    }
    
	
	//getters and setters for the attributes
	public void setRow(int row) {
		this.row = row;
	}
	
	public void setCol(int col) {
		this.column = col;
	}
    
    public boolean isHasShip() {
		return hasShip;
	}
	public void setHasShip(boolean hasShip) {
		this.hasShip = hasShip;
	}
	public boolean isShotFired() {
		return shotFired;
	}
	public void setShotFired(boolean shotFired) {
		this.shotFired = shotFired;
	}
	
	
	// Get a ship reference for the square, also when setting the ship it means that the boolean hasShip is true
	public void setShip(Battleship ship) {
		this.shipOnSquare = ship;
		this.hasShip = true;
	}
	public Battleship getShip() { // so that we can get the ship information from this square board
		return this.shipOnSquare;
	}
	
	
	// set the printing for the board with toString (and print the board with the funtion of the board object
	public String toString() {
		if(this.hasShip == true && this.shotFired == true) {
			return " o ";
		}else if(this.shotFired == true) {
			return " x ";
		}else {
			return " - ";
		}
	}
	
	
	
}
