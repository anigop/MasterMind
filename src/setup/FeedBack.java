package setup;

public class FeedBack {

	private int whites; // right color, wrong position
	private int blacks; // correct color wrong position
	
	public FeedBack(int whites, int blacks){
		this.whites = whites;
		this.blacks = blacks;
	}
	public int getWhites() {
		return whites;
	}
	public void setWhites(int whites) {
		this.whites = whites;
	}
	public int getBlacks() {
		return blacks;
	}

	public void setBlacks(int blacks) {
		this.blacks = blacks;
	}
	
	@Override public String toString(){
		StringBuilder sb = new StringBuilder();
		if(whites == 0 && blacks == 0){
			return sb.append("NONE").toString();
		}
        try{
        	if(blacks!=0){
    			for(int i=1; i<=blacks;i++){
    				sb.append("B");
    			}
    		}
    		if(whites!=0){
    			for(int i=1; i<=whites;i++){
    				sb.append("W");
    			}
    		}
    		return sb.toString();
        }
        catch(Exception e){
        	System.err.println("Cannot convert object to String "+e.toString());
        	return null;
        }
	}
	
	public static boolean validateFeedback(String fb){
		try{
			if(fb.length() == 0){
				fb ="NONE";
			}
			if(Board.getBoardInstance().getnewBucket().containsKey(fb)){
				return true;
			}
			return false;
		}
		catch(Exception e){
			System.err.println("Could not validate feedback "+e.toString());
			e.printStackTrace();
			return false;
		}
	}
}
	