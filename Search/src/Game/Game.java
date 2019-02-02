package Game;

public class Game {
	int[][] board = new int[8][8];
	int pointsBlack = 2;
	int pointsWhite = 2;
	static final int WHITE = 1, BLACK = -1, EMPTY = 0;
	static final int NORTH = -1, EAST = 1, SOUTH = 1, WEST = -1, STATIONARY = 0;

	public Game() {
		// start a new board
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++)
				board[i][j] = EMPTY;
		}

		// place pebbles
		board[3][3] = WHITE;
		board[4][3] = BLACK;
		board[3][4] = BLACK;
		board[4][4] = WHITE;
	}

	// calculate the total points by placing a pebble in (sx,y), remember to check legality before making the move
	void makeMove(int x, int y, int player) {
		for (int j = -1; j < 1; j++) {
			for (int i = -1; i < 1; i++)
				updateDirection(x, y, j, i, player);
		}
	}

	// checks the legality of a move
	boolean checkMoveLegality(int x, int y, int player) {
		if(board[x][y] != EMPTY)
			return false;
		for (int j = -1; j < 1; j++) {
			for (int i = -1; i < 1; i++)
				if (checkLegalityDirection(x, y, j, i, player))
					return true;
		}
		return false;
	}

	// calculates the points in one direction
	boolean checkLegalityDirection(int startx, int starty, int vertical, int horizontal, int player) {
		int opponent = BLACK;
		if (player == BLACK)
			opponent = WHITE;
		
		int i = 1;
		int indexX = startx + horizontal;
		int indexY = starty + vertical;
		
		while(board[indexX][indexY] == player) {
			
		}
		
		if (board[indexX][indexY] == opponent) {
			return true; 
		}
		if (board[indexX][indexY] == EMPTY) 
			return false; 
	}
	
	// calculates the points in one direction
	int updateDirection(int startx, int starty, int vertical, int horizontal, int player) {
		int points = 0;
		int opponent = BLACK;
		if (player == BLACK)
			opponent = WHITE;
		int i = 1;
		int indexX = startx + i * horizontal;
		int indexY = starty + i * vertical;
		while (opponent == board[indexX][indexY]) {
			points++;
			i++;
			indexX = startx + i * horizontal;
			indexY = starty + i * vertical;
			// #TODO check if we fall off the board

		}
		if (board[indexX][indexY] == EMPTY) {
			return points = 0;
		}
		return points;
	}

	// prints the game current board
	public void printBoard() {
		for (int i = 0; i < 8; i++) {
			System.out.print("|");
			for (int j = 0; j < 8; j++) {
				if (board[i][j] == BLACK)
					System.out.print("B");
				if (board[i][j] == WHITE)
					System.out.print("W");
				if (board[i][j] == EMPTY)
					System.out.print(" ");
				System.out.print("|");
			}
			System.out.println("");
		}
	}

}
