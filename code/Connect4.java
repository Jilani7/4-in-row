import java.util.Scanner;

public class Connect4 {

	public static void main(String[] args) {

		// Defining 10x10 long game variables
		char[][] matrix = new char[10][10];
		Scanner in = new Scanner(System.in);
		
		//2D game Matrix Initialization;
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[0].length; j++){
				matrix[i][j] = ' ';
			}
		}
		
		int turn = 1;
		char player = 'R';
		boolean winner = false;		
		
		//play a turn
		while (winner == false && turn <= 100){
			boolean validPlay;
			int play;
			do {
				display(matrix);
				
				System.out.print("Player " + player + ", choose a jumn: ");
				play = in.nextInt();
				
				//validate play
				validPlay = validate(play,matrix);
				
			}while (validPlay == false);
			
			//drop the checker
			for (int i = matrix.length-1; i >= 0; i--){
				if(matrix[i][play] == ' '){
					matrix[i][play] = player;
					break;
				}
			}
			
			//determine if there is a winner
			winner = isWinner(player,matrix);
			
			//switch players
			if (player == 'R'){
				player = 'B';
			}else{
				player = 'R';
			}
			
			turn++;			
		}
		display(matrix);
		
		if (winner){
			if (player=='R'){
				System.out.println("Black won");
			}else{
				System.out.println("Red won");
			}
		}else{
			System.out.println("Tie game");
		}
		in.close();	
	}
	
	public static void display(char[][] matrix){
		System.out.println(" 0 1 2 3 4 5 6 7 8 9");
		System.out.println("---------------------");
		for (int i = 0; i < matrix.length; i++){
			System.out.print("|");
			for (int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j]);
				System.out.print("|");
			}
			System.out.println();
		}
		System.out.println("---------------------");
		System.out.println(" 0 1 2 3 4 5 6 7 8 9");
		System.out.println();
	}
	
	public static boolean validate(int column, char[][] matrix){
		//valid column?
		if (column < 0 || column > matrix[0].length){
			return false;
		}
		
		//full column?
		if (matrix[0][column] != ' '){
			return false;
		}
		
		return true;
	}
	
	public static boolean isWinner(char player, char[][] matrix){
		// Horizontal Checking for matching 
		for(int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[0].length - 3; j++){
				if (matrix[i][j] == player   && 
					matrix[i][j + 1] == player &&
					matrix[i][j + 2] == player &&
					matrix[i][j + 3] == player){
					return true;
				}
			}			
		}
		// Vertically Checking for matching
		for(int i = 0; i < matrix.length - 3; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if (matrix[i][j] == player   && 
					matrix[i + 1][j] == player &&
					matrix[i + 2][j] == player &&
					matrix[i + 3][j] == player){
					return true;
				}
			}
		}
		return false;
	}
}
