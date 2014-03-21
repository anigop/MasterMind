package setup;

import java.util.ArrayList;
import java.util.HashMap;

import objects.Move;
import objects.Rows;

public class Board {

	public ArrayList<Rows> board;
	public ArrayList<String> possibleMoves;
	private static Board b;
	private BoardSetup bset;
	
	
	public static Board getBoardInstance(){
		if(b == null){
			b = new Board();
		}
		return b;
	}
	
	private Board(){
		board = new ArrayList<Rows>();
		bset = new BoardSetup();
		possibleMoves = new ArrayList<String>();
		loadMoves();
	}
	
	public HashMap<String,ArrayList<String>> getnewBucket(){
		return bset.getNewBucket();
	}
	
	private void loadMoves(){
		int[] colorpegs = {1,2,3,4,5,6};
		String colorString = "";
		
		System.out.println("Loading possible moves..");
		
		loadInitialMoves(colorpegs,colorString, 0);

		System.out.println(possibleMoves);
		System.out.println("Initial possible moves "+possibleMoves.size());
	}
	
	private void loadInitialMoves(int[] colorpegs,String colorString,int depth){
		if(depth >= 4){
			possibleMoves.add(colorString);
			return;
		}
		for(int i=0;i<colorpegs.length;i++){
			loadInitialMoves(colorpegs,colorString+colorpegs[i], depth+1);
		}
	}
	
	public void setPossibleMoves(ArrayList<String> possibleMov){
		this.possibleMoves = new ArrayList<String>();
		this.possibleMoves = possibleMov;
	}
	
	public void updateState(Move m){
		Rows row = new Rows(m.getmString().toCharArray());
		board.add(row);
	}
	
	public void displayBoard(){
		IO.display();
	}
	
	
}
