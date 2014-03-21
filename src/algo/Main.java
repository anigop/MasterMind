package algo;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			Engine e = Engine.getEngineInstance();
			e.start();
			
		}
		catch (Exception et) {
			et.printStackTrace();
			// TODO: handle exception
		}
		
	}

}
