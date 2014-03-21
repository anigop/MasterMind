package objects;

import java.util.Comparator;

public class MoveComparator implements Comparator<Move> {

	@Override
	public int compare(Move arg0, Move arg1) {
		// TODO Auto-generated method stub
		if(arg0.getMaxpool().size() > arg1.getMaxpool().size()){
			return -1;
		}else{
			return 1;
		}
	}

}
