package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import objects.Move;
import objects.MoveComparator;
import setup.Board;
import setup.FeedBack;

public class Compute {

	private Move lastplayed;
	private PriorityQueue<Move> bestMove;
	private static Compute c;
	private Board board;
	public static Compute getComputeInstance(){
		if(c == null){
			c = new Compute();
		}
		return c;
	}
	private Compute(){
		//
		board = Board.getBoardInstance();
		bestMove = new PriorityQueue<Move>(256, new MoveComparator());
	}
	public String getFeedBack(String m1 , String m2){
		
		int whites = 0;
		int blacks = 0;
		HashMap<String,Integer> countM1 = new HashMap<String, Integer>();
		HashMap<String,Integer> countM2 = new HashMap<String,Integer>();
		String[] mS1 = m1.split("");
		String[] mS2 = m2.split("");
		
		try{
			if(m1.length() != m2.length() || m2.length() == 0 || m1.length() == 0){
				//Throw Exception
				System.out.println("Invalid String Comparision S1:"+m1+" S2:"+m2);
			}
			for(int i = 1 ; i <mS1.length ;i++){
				if(mS1[i].equals(mS2[i])){
					blacks++;
					continue;
				}
				if(countM1.get(mS1[i]) != null){
					countM1.put(mS1[i], countM1.get(mS1[i])+1);
				}else{
					countM1.put(mS1[i],1);
				}
				if(countM2.get(mS2[i]) != null){
					countM2.put(mS2[i], countM2.get(mS2[i])+1);
				}else{
					countM2.put(mS2[i], 1);
				}
			}
			for(String s : countM1.keySet()){
				while(true){
					if(countM2.get(s) != null && (countM2.get(s)>0 && countM1.get(s)>0)){
						whites++;
						countM1.put(s, countM1.get(s)-1);
						countM2.put(s,countM2.get(s)-1);
					}else{
						break;
					}
				}
			}
			
			FeedBack fb = new FeedBack(whites, blacks);
			return fb.toString();
		}
		catch(Exception e){
			System.err.println("Error while calculating feedback "+e.toString());
			return  null;
		}

	}
	
	public Move computeMove(String fb){
		try{
			ArrayList<String> newpossibleMoveList = lastplayed.getNewMovesList(fb);
			board.setPossibleMoves(newpossibleMoveList);
			
			for(String move : newpossibleMoveList){
				//System.out.println("For "+move);
				Move m = new Move(move);
				m.populateBucket();
				bestMove.add(m);
			}
			
			Move selected = bestMove.remove();
			bestMove = new PriorityQueue<Move>(256, new MoveComparator());
			lastplayed = selected;
			return selected;

		}catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
				
		
	}
	public Move getLastplayed() {
		return lastplayed;
	}
	public void setLastplayed(Move lastplayed) {
		this.lastplayed = lastplayed;
	}
	
}
