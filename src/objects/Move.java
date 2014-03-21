package objects;

import java.util.ArrayList;
import java.util.HashMap;

import algo.Compute;

import setup.Board;

public class Move {

	private String mString;
	private int minmaxval;
	
	private HashMap<String,ArrayList<String>> bucket;
	private ArrayList<String> maxpool;
	public Move(String mString){
		try{
			this.mString = mString;
			this.minmaxval = 0;
			this.maxpool = new ArrayList<String>();
			this.bucket = Board.getBoardInstance().getnewBucket();
		    
		}
		catch(Exception e){
			System.err.println("Error while creating Move Instance "+e.toString());
			e.printStackTrace();
		}
	}
	
	public void populateBucket(){
		ArrayList<String> possibleMoves = Board.getBoardInstance().possibleMoves;
		try{

			for(String s : possibleMoves){
				String fb = Compute.getComputeInstance().getFeedBack(mString, s);
				
				if(bucket.get(fb)!=null){
					ArrayList<String> pool = bucket.get(fb);
					pool.add(s);
					bucket.put(fb,pool);
					if(maxpool.size() < pool.size()){
						maxpool = pool;
					}
					pool = null;
				}else{
					ArrayList<String> pool = new ArrayList<String>();
					pool.add(s);
					bucket.put(fb,pool);
				}
			}
			
			//System.out.println("Result:");
			
			//System.out.println(maxpool.size()+" ");
		
		}
		catch(Exception e){
			System.err.println("@@ Move.populatebucket");
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getNewMovesList(String fb){
		if(bucket.get(fb)!=null){
			ArrayList<String> moves = bucket.get(fb);
			return moves;
		}else{
			System.err.println("No Valid Moves");
			return null;
		}
	}

	public String getmString() {
		return mString;
	}

	public void setmString(String mString) {
		this.mString = mString;
	}

	public int getMinmaxval() {
		return minmaxval;
	}

	public void setMinmaxval(int minmaxval) {
		this.minmaxval = minmaxval;
	}

	public ArrayList<String> getMaxpool() {
		return maxpool;
	}

	public void setMaxpool(ArrayList<String> maxpool) {
		this.maxpool = maxpool;
	}
	
	@Override public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(mString+":");
		sb.append(maxpool.size());
		return sb.toString();
	}
}
