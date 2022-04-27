package sudoku_solver;

public class Application {

	public static final int GRID_SIZE = 9;
	
	public static void main(String[] args) {
		
		int[][] board = {
				{7, 0, 2, 0, 5, 0, 6, 0, 0},
				{0, 0, 0, 0, 0, 3, 0, 0, 0},
				{1, 0, 0, 0, 0, 9, 5, 0, 0},
				{8, 0, 0, 0, 0, 0, 0, 9, 0},
				{0, 4, 3, 0, 0, 0, 7, 5, 0},
				{0, 9, 0, 0, 0, 0, 0, 0, 8},
				{0, 0, 9, 7, 0, 0, 0, 0, 5},
				{0, 0, 0, 2, 0, 0, 0, 0, 0},
				{0, 0, 7, 0, 4, 0, 2, 0, 3}
			};
		
		printBoard(board);
		
		if(solveBoard(board)) {
			System.out.println();
			System.out.println("======== Solved Sudoku ========");
			System.out.println();
			printBoard(board);
		}
		else {
			System.out.println("Unable to solve this game! :(");
		}		
	}
	
	
		
	public static boolean isNumberInRow(int[][] board, int number, int row) {
		for(int i = 0; i < GRID_SIZE; i++) {
			if(number == board[row][i]) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isNumberInColumn(int[][] board, int number, int column) {
		for(int i = 0; i < GRID_SIZE; i++) {
			if(number == board[i][column]) {
				return true;
			}
		}
		return false;
	}
	
	
	public static boolean isNumberInBox(int[][] board, int number, int row, int column) {
		// find the coordinates of the top left corner of the box
		int firstRow = row - row % 3;
		int firstColumn = column - column % 3;
		
		for(int i = firstRow; i < firstRow + 3; i++) {
			for(int j = firstColumn; j < firstColumn + 3; j++) {
				if(number == board[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	public static boolean isValidPosition(int[][] board, int number, int row, int column) {
		return !isNumberInRow(board, number, row) &&
				!isNumberInColumn(board, number, column) &&
				!isNumberInBox(board, number, row, column);
	}
	
	
	public static boolean solveBoard(int[][] board) {
		for(int row = 0; row < GRID_SIZE; row++) {
			for(int column = 0; column < GRID_SIZE; column++) {
				if(board[row][column] == 0) {
					for(int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++ ) {
						if(isValidPosition(board, numberToTry, row, column)) {
							board[row][column] = numberToTry;
							
							if(solveBoard(board)) {
								return true;
							}
							else { //if the recursive call return false, the last position is set back to zero and the application tries a different number
								board[row][column] = 0;
							}
						}
					}
					return false; // if the for loop test all possible number and nothing is valid, it returns false and the application go back to the last position to try a different combination of numbers to solve the board
				}
			}
		}
		return true;
	}
	
	
	public static void printBoard(int[][] board) {
		for(int i = 0; i < GRID_SIZE; i++) {
			if(i % 3 == 0 && i != 0) {
				System.out.println("---------------------");
			}
			for(int j = 0; j < GRID_SIZE; j++) {
				if(j % 3 == 0 && j != 0) {
					System.out.print("| ");
				}
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	
}
