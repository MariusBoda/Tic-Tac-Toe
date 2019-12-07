import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;



public class board {
	public static char board[][] = new char[3][3]; // - = vacant x = x o = o
	public boolean PlayerWon = false; 
	public static boolean GameOver = false;
	public boolean ComputerWon = false; 
	public static boolean start = false;
	public static int turn = 0;
	public static boolean GameTie = false;
	public static int score1 = 0;
	public static int score2 = 0;
	public static int counterX = 0;
	public static int counterO = 0;
	public static String player = "";
	public static boolean test = false;

	//	int moves = 0;
	//	int gridsleft = 9;


	public static void initialBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(turn == 0 || GameOver == true) {
					board[i][j] = '-';
				}
			}
		}
		print();
	}

	public static void xoButton() {
		if(turn%2 == 0) {
			if(board[draw.row][draw.col] == '-') {
				board[draw.row][draw.col] = 'x';
				print();
				turn ++;
				draw.x = (draw.col*143) + 80;
				draw.y = (draw.row*143) + 150;


			}
		}
		if(turn%2 == 1) {
			if(board[draw.row][draw.col] == '-') {
				board[draw.row][draw.col] = 'o';
				print();
				turn ++;
				draw.x = (draw.col*143) + 80;
				draw.y = (draw.row*143) + 150;

			}
		}


	}

	public static void checkGame() {

		if(turn%2 == 1) {
			for(int i = 0; i <=2; i++) {
				for(int j = 0; j <= 2; j++) {
					if(board[i][0] == 'x' && board[i][1] == 'x' && board[i][2] == 'x') {
						GameOver = true;
						//System.out.println(GameOver);
						GameOver();
					}
					if(board[0][i] == 'x' && board[1][i] == 'x' && board[2][i] == 'x') {
						GameOver = true;
						//System.out.println(GameOver);
						GameOver();
					}

					if(board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x') {
						GameOver = true;
						//System.out.println(GameOver);
						GameOver();

					}

					if(board[0][2] == 'x' && board[1][1] == 'x' && board[2][0] == 'x') {
						GameOver = true;
						//System.out.println(GameOver);
						GameOver();
					}
					else if(turn >= 9) {
						GameTie = true;
						GameOver();
					}
				}
			}

		}
		if(turn%2 == 0) {
			for(int i = 0; i <=2; i++) {
				for(int j = 0; j <= 2; j++) {
					if(board[i][0] == 'o' && board[i][1] == 'o' && board[i][2] == 'o') {
						GameOver = true;
						//System.out.println(GameOver);
						GameOver();
					}
					if(board[0][i] == 'o' && board[1][i] == 'o' && board[2][i] == 'o') {
						GameOver = true;
						//System.out.println(GameOver);
						GameOver();
					}
					if(board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] == 'o') {
						GameOver = true;
						//System.out.println(GameOver);
						GameOver();


					}

					if(board[0][2] == 'o' && board[1][1] == 'o' && board[2][0] == 'o') {
						GameOver = true;
						//System.out.println(GameOver);
						GameOver();
					}
					else if(turn >= 9) {
						GameTie = true;
						GameOver();
					}

				}
			}
		}
	}


	public static void changeBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(board[i][j] == 'x' || board[i][j] == 'o') {
					GameOver = true;
					if(GameOver == true) {
						//initialBoard();
						//print();
					}
					board[i][j] = '-';
					print();
				}

			}
		}
	}
	
	public static void Restart() {
		test = true;
		
	
	}

	public static void print() {
		System.out.println();
		// Prints the board on the console
		//initialBoard();
		//changeBoard();

		//xoButton();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}

	}

	public static void GameOver() {
		if(turn%2 == 1) {
			//System.out.print("Player 1 Wins");
			score1 ++;
			player = "1";
			//turn = 0;
			initialBoard();
			print();

		}

		if(GameTie == true) {
			initialBoard();
			print();
		}
		if(turn%2 == 0) {
			//System.out.print("Player 2 Wins");
			score2 ++;
			player = "2";
			//turn = 0;
			initialBoard();
			print();
		}
	}





	public static void startButton() {


	}
}
