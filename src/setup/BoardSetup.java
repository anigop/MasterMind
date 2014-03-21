package setup;

import java.util.ArrayList;
import java.util.HashMap;



public class BoardSetup {

	ArrayList<FeedBack> possibleFeedbacks;
	HashMap<String,ArrayList<String>> feedbackBucket;
	public BoardSetup(){
		possibleFeedbacks = new ArrayList<FeedBack>();
		
		int[] possiblevals = {0,1,2,3,4};
		int[] wbpairs = new int[2];
		
		generatefeedBacks(possiblevals,wbpairs,0);
		
		try{
			buildBucketMap();
		}catch(Exception e){
			e.printStackTrace();
		}
	}		
	public Board initializeboard(){
		Board board = Board.getBoardInstance();
		return board;
	}

	private void generatefeedBacks(int[] possiblevals,int[] fbpairs,int index){
		if(index >= 2){
			if(((fbpairs[0]+fbpairs[1])>4) || (fbpairs[0]==3) &&(fbpairs[1]==1)){
				return;
			}else{
				possibleFeedbacks.add(new FeedBack(fbpairs[0], fbpairs[1]));
				return;
			}
		}
		for(int i =0;i<possiblevals.length;i++){
			fbpairs[index] = possiblevals[i];
			generatefeedBacks(possiblevals, fbpairs, index+1);
		}
		
		
	}
	
	private HashMap<String,ArrayList<String>> buildBucketMap(){
		
		if(possibleFeedbacks.size() == 0){
			System.err.println("Possible Feedbacks have not been generated");
			return null;
		}
		else{
			HashMap<String,ArrayList<String>> feedbackBucket = new HashMap<String,ArrayList<String>>();
			for(FeedBack fb : possibleFeedbacks){
				feedbackBucket.put(fb.toString(), null);
			}
			this.feedbackBucket = feedbackBucket;
			return feedbackBucket;
		}
	}
	
	public HashMap<String,ArrayList<String>> getNewBucket(){
		try{
			if(feedbackBucket != null){
				HashMap<String, ArrayList<String>> feedBucket = new HashMap<String, ArrayList<String>>();
				for(String s : feedbackBucket.keySet()){
					feedBucket.put(s, null);
				}
				return feedBucket;
			}
			return buildBucketMap();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}
