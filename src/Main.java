
import java.util.Scanner;

import controller.MainController;
/**
 * 
 * @author Andreas
 *
 */
public class Main {
	
	
	
	private static MainController mainController;
	
	public static void main(String [] args)
	{
		mainController = new MainController("names.txt",
				"noise_words.txt ");
		System.out.println("Please enter the name you want to search for:");
		
		//gets the user input
		Scanner input =new Scanner(System.in);
		String string=input.nextLine();
		mainController.getBlackListName(string);
		while(mainController.searchUtil.showSuggestions){
			String searchable =input.nextLine();
			mainController.getBlackListName(searchable);
		}
		
		input.close();
		
		
		
	}

}
