import java.util.Random;

public class Board {
	
	//attributes
	private int rowNum = 10;
	private int columnNum = 10;
	private Square[][] board = new Square[rowNum][columnNum];
	
	private int smallShipNum = 3;
	private int mediumShipNum = 2;
	private int largeShipNum = 1;

	
    
	// getters and setters
	public Square[][] getBoard() {
		return board;
	}


	public void setBoard(Square[][] board) {
		this.board = board;
	}
    
	
	// Board default constructor
		public Board() {
			this.rowNum = 10;
			this.columnNum = 10;
		}

	// Board constructor
	public Board(int rowNum, int columnNum) {
		this.rowNum = rowNum;
		this.columnNum = columnNum;
	}
	
	
	// populate the board data structure with Square
	public void makeBoard() {         
		// assign each square with locations using loops
		for (int row = 0; row < 10; row++){
			for (int col = 0; col < 10; col++){
				Square s = new Square(row, col);
				board[row][col] = s;
		    }
		}
	}
	
	
	// Printing out the board (since there is already a toString method in Square, we can simply use System.out.print
	public void printBoard() {
		for (int row = 0; row < board[0].length; row++){
			for (int col = 0; col < board[1].length; col++){
				System.out.print(board[row][col]);
		    }
			System.out.println();
		}
	}
	
	
	
	// generating the original battleships with length of 2 and place them randomly on the board
	public void generateShip() {
		int shipNum = 5;

		int i = 0;
		
		while(i != shipNum) { // when there are 5 ships generated, stop the loop
			
			// randomly place the ships
			Random r = new Random();
			int rowNum = r.nextInt(10);
			int colNum = r.nextInt(10);
			int rowNum2;
			int colNum2;
			
			
			// randomly choose vertically or horizontally place the ships
			boolean isVer = r.nextBoolean();
			
			
			// use -1 to get the neighbor square to avoid setting ships out of boundaries
			if(isVer) {
				rowNum2 = rowNum - 1;
				colNum2 = colNum;
			}
			else {
				colNum2 = colNum - 1;
				rowNum2 = rowNum;
			}
			if(rowNum == 0 || colNum == 0) {
				continue;
			}
			
			// assign the squares with battleship
			if((board[rowNum][colNum].isHasShip() == false) && (board[rowNum2][colNum2].isHasShip() == false)) {	// make sure the ships don't overlap
				Battleship ship = new Battleship();
				board[rowNum][colNum].setShip(ship);
				board[rowNum2][colNum2].setShip(ship);
				//count the amount of ships created until there are 5 in total
				i++;
			} else {
				continue; // if the ships overlap, just run the loop again and create a new random place
			}
			
			
			// Check the Generation of the ship
			System.out.println("creating ship " + i);	
			System.out.println(rowNum);
			System.out.println(colNum);
			System.out.println(rowNum2);
			System.out.println(colNum2);
			
		}
	}
			
			
			
			
		// generating battleships and place them randomly on the board
		public void generateExpandedShip() {
			
			// generate the 1 large ship
			int k = 0;
			
			while(k != largeShipNum) {
				// randomly place the ships
				Random r = new Random();
				int rowNum = r.nextInt(10);
				int colNum = r.nextInt(10);
				int rowNum2;
				int colNum2;
				int rowNum3;
				int colNum3;
				
				
				// randomly choose vertically or horizontally place the ships
				boolean isVer = r.nextBoolean();
				
				
				// use -1 to get the neighbor square to avoid setting ships out of boundaries
				if(isVer) {
					rowNum2 = rowNum - 1;
					rowNum3 = rowNum - 2;
					colNum2 = colNum;
					colNum3 = colNum;
				}
				else {
					colNum2 = colNum - 1;
					colNum3 = colNum - 2;
					rowNum2 = rowNum;
					rowNum3 = rowNum;
				}
				
				// assign the squares with the large battleship
				if((rowNum == 0 || colNum == 0 || rowNum2 >= 1 || colNum2 >= 1)) {	// make sure the ships don't go out of boundary and don't overlap. Large is the first ship to be made so there is no need to check for overlaps
					LargeBattleship ship = new LargeBattleship();
					board[rowNum][colNum].setShip(ship);
					board[rowNum2][colNum2].setShip(ship);
					board[rowNum3][colNum3].setShip(ship);
					k++;
					
					
					//To check the location of the ship
					//System.out.println(rowNum + " " + colNum);
					//System.out.println(rowNum2 + " " + colNum2);
					//System.out.println(rowNum3 + " " + colNum3);

				}
			
			}
			
			
			
			// generate the medium ships
				int i = 0;
				
				while(i != mediumShipNum) { // when there are 3 medium ships generated, stop the loop
				
				// randomly place the ships
				Random r3 = new Random();
				int rowNumMe = r3.nextInt(10); // set the location with rowNum + Medium
				int colNumMe = r3.nextInt(10);
				int rowNumMe2;
				int colNumMe2;
				
				// randomly choose vertically or horizontally place the ships
				boolean isVer2 = r3.nextBoolean();
				
				
				// use -1 to get the neighbor square to avoid setting ships out of boundaries
				if(isVer2) {
					rowNumMe2 = rowNumMe - 1;
					colNumMe2 = colNumMe;
				}
				else {
					colNumMe2 = colNumMe - 1;
					rowNumMe2 = rowNumMe;
				}
				if(rowNumMe == 0 || colNumMe == 0) {
					continue;
				}
				
				// Assign the Square with a battleship
				if((board[rowNumMe][colNumMe].isHasShip() == false) && (board[rowNumMe2][colNumMe2].isHasShip() == false)) {	// make sure the ships don't overlap
					MediumBattleship ship = new MediumBattleship();
					board[rowNumMe][colNumMe].setShip(ship);
					board[rowNumMe2][colNumMe2].setShip(ship);
					//count the amount of ships created until there are 5 in total
					i++;

					//To check the location of the ship
					//System.out.println(i);
					//System.out.println(rowNumMe + " " + colNumMe);
					//System.out.println(rowNumMe2 + " " + colNumMe2);

				} else {
					continue; // if the ships overlap, just run the loop again and create a new random place
				}
			
			}
				
			
			
			
			// generate the small ships
			int j = 0;
			
			while(j != smallShipNum) { // when there are 3 medium ships generated, stop the loop
				// randomly place the ships
				Random r2 = new Random();
				int rowNumSm = r2.nextInt(10);
				int colNumSm = r2.nextInt(10);
				
				// The ship has size 1 so there is no need to see whether it is vertical or not, just assign the ship on the square
				
				
				// Assign the Square with the battleship
				if((board[rowNumSm][colNumSm].isHasShip() == false)) {	// make sure the ships don't overlap
					SmallBattleship ship = new SmallBattleship();
					board[rowNumSm][colNumSm].setShip(ship);
					//count the amount of ships created until there are 3 in total
					j++;
					
					
					//To check the location of the ship
					//System.out.println(j);
					//System.out.println(rowNumSm + " " + colNumSm);

				} else {
					continue; // if the ships overlap, just run the loop again and create a new random place
				}
			}
				
				
			
			
			
			
			
			
		}
		
		
		
		
		
	}
	
	
	
	
