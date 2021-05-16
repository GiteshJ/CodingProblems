import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

	int computer1 = 1;
	int computer2 = 2;
	final int SIZE;
	Piece[][]  board;
	List<Integer> moves;
	public TicTacToe(int size){
		this.SIZE = size;
		this.board = new Piece[size][size];
		this.moves = new ArrayList<Integer>(size*size);
		this.initialiseBoard();
		Collections.shuffle(this.moves);
	}
	
	enum Piece{
		
		
		Empty(" "), X("X"), O("O");
		
		String action;
		
		Piece(String action) {
			this.action = action;
		}
		
		public String getAction() {
			return this.action;
		}
		
	}
	
	class Check{
		public int row,col, rowIncrement, colIncrement;
		
		public Check(int row,int col,int rowIncrement, int colIncrement) {
			this.row = row;
			this.col = col;
			this.rowIncrement = rowIncrement;
			this.colIncrement = colIncrement;
		}
		
		public void increment() {
			row += rowIncrement;
			col += colIncrement;
		}
		public boolean isWithinBounds() {
			return row>=0 && col>=0 && row<SIZE && col<SIZE;
		}
	}
	
	public void initialiseBoard() {
		for(int row=0;row<SIZE;row++){
			for(int col=0;col<SIZE;col++){
				board[row][col] = Piece.Empty;
				
			}
		}
		
		for (int i=0; i<SIZE*SIZE; i++)
			moves.add(i);
	}
	
	public void displayBorad() {
		for(int row=0;row<SIZE;row++){
			System.out.print(" | ");
			for(int col=0;col<SIZE;col++){
				System.out.print(board[row][col].getAction() + " | ");
			}
			
			System.out.println();
		}
		
		System.out.println("______________________");
		System.out.println();
	}
	
	Piece hasWon() {
		ArrayList<Check> instructions = new ArrayList<Check>();
		for(int i=0;i<SIZE;i++) {
			instructions.add(new Check(0,i,1,0));
			instructions.add(new Check(i,0,0,1));
		}
		instructions.add(new Check(0,0,1,1));
		instructions.add(new Check(0,SIZE-1,1,-1));
		for(Check inst: instructions) {
			Piece winner = hasWon(inst);
			if(winner!=Piece.Empty) return winner;
		}
		return Piece.Empty;
		
	}
	
	Piece hasWonOptimized(int row, int col) {
		ArrayList<Check> instructions = new ArrayList<Check>();
		
		instructions.add(new Check(0,col,1,0));
		instructions.add(new Check(row,0,0,1));
		if(row==col)instructions.add(new Check(0,0,1,1));
		if(row+col == SIZE-1)instructions.add(new Check(0,SIZE-1,1,-1));
		for(Check inst: instructions) {
			Piece winner = hasWon(inst);
			if(winner!=Piece.Empty) return winner;
		}
		return Piece.Empty;
		
	}
	
	Piece hasWon(Check inst) {
		Piece first = board[inst.row][inst.col];
		while(inst.isWithinBounds()) {
			if(board[inst.row][inst.col]!=first) return Piece.Empty;
			inst.increment();
			
		}
		return first;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Enter Board Size: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.close();
		int moveIndex =  0,x = 0,y = 0;
		TicTacToe game = new TicTacToe(size);
		int whoseTurn = game.computer1;
		game.displayBorad();
		while (game.hasWonOptimized(x,y) == Piece.Empty &&  moveIndex != game.SIZE*game.SIZE)
	    {
	        if (whoseTurn == game.computer1)
	        {
	            x = game.moves.get(moveIndex) / game.SIZE;
	            y = game.moves.get(moveIndex) % game.SIZE;
	            game.board[x][y] = Piece.X;
	            game.displayBorad();
	            moveIndex ++;
	            whoseTurn = game.computer2;
	        }
	          
	        else if (whoseTurn == game.computer2)
	        {
	        	x = game.moves.get(moveIndex) / game.SIZE;
	            y = game.moves.get(moveIndex) % game.SIZE;
	            game.board[x][y] = Piece.O;
	            game.displayBorad();
	            moveIndex ++;
	            whoseTurn = game.computer1;
	        }
	    } 
		
		
		if(game.hasWonOptimized(x,y)==Piece.Empty) {
			System.out.println("Match Drawn");
		}
		else if(game.hasWonOptimized(x,y)==Piece.X) {
			System.out.println("Computer 1 Won!");
		}
		else if(game.hasWonOptimized(x,y)==Piece.O) {
			System.out.println("Computer 2 Won!");
		}
		return;
		
	}
	
}
