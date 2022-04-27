package sudoku_solver;

public class Application {

	public static final int GRID_SIZE = 9;
	
	public static void main(String[] args) {
		
		int[][] board = {
				{7,0,2,1,5,0,6,0,0},
				{0,0,0,0,0,3,0,0,0},
				{1,0,0,0,0,9,5,0,0},
				{8,0,0,0,0,0,0,9,0},
				{0,4,3,0,0,0,7,5,0},
				{0,9,0,0,0,0,0,0,8},
				{0,0,9,7,0,0,0,0,5},
				{0,0,0,2,0,0,0,0,0},
				{0,0,7,0,4,0,2,0,3}
			};
		
		printBoard(board);
		System.out.println(isNumberInRow(board, 7, 1));
		System.out.println(isNumberInColumn(board, 3, 4));
		System.out.println(isNumberInBox(board, 7, 1, 1));
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
