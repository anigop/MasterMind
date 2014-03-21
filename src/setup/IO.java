package setup;

import java.util.Scanner;

import objects.Rows;

public class IO {

	public static String getUserInput(){
		try{
			String fb = "";
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter feedback ");
			fb = scan.next();
			return fb;
			
		}
		catch(Exception e){
			System.err.println("Error while receiving user feedback "+e.toString());
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static void display(){
		/*
		 * For UI
		 */
		System.out.println(" Board ");
		Board b = Board.getBoardInstance();
		
		for(Rows r : b.board){
			System.out.println(r);
		}
	}
}
