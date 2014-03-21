package objects;

public class Rows {

	char[] r;
	public Rows(char[] r){
		this.r = r;
	}
	
	

	@Override public String toString(){
		StringBuilder sb = new StringBuilder();
		for(char c : r){
			sb.append(" "+c);
		}
		return sb.toString();
	}

}
