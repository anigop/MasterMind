package algo;

import objects.Move;
import setup.Board;
import setup.FeedBack;
import setup.IO;

public class Engine {
	private static Engine e;
	public Board board;	
	private Engine(){
		initializeBoard();
	}
	
	public static Engine getEngineInstance(){
		if(e == null){
			 e = new Engine();
		}
		return e;
	}
	
	private void initializeBoard(){
		System.out.println("Initializing Board");
		board = Board.getBoardInstance();
	}
	
	public void start(){
		Move m = new Move("1122");
		m.populateBucket();
		Compute.getComputeInstance().setLastplayed(m);
		board.getBoardInstance().updateState(m);
		board.getBoardInstance().displayBoard();
		
		while(true){
			String fb = IO.getUserInput();
			
			if(fb.equals("BBBB")){
				System.out.println("Game Over! ");
				break;
			}
			if(FeedBack.validateFeedback(fb)){
				m = Compute.getComputeInstance().computeMove(fb);
			}else{
				System.err.println("Invalid Feedback, try again ");
			}
			board.getBoardInstance().updateState(m);
			board.getBoardInstance().displayBoard();
			
		}
	}
}
