
public class Battleship {
	
	// attributes
	protected boolean isSunk;
	protected int health;
	protected int size;
	
	
	// set the default
	public Battleship() {
		this.isSunk = false;
		this.health = 2;
		this.size = 2;
	}
	
	
	
	// getters and setters
	public boolean isSunk() {
		return isSunk;
	}
	public void setSunk(boolean isSunk) {
		this.isSunk = isSunk;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
	
	// decrease the health when being hit and update the event
	public void decreaseHealth() {
		this.health -= 1;
	}
	
	
	public void getHit() {
		if(!this.isSunk) {
			this.health -= 1;
		}
		if(this.health == 0){
			this.isSunk = true;
		}
	}
 
	
}
