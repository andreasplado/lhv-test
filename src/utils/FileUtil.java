package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Criminals;

/**
 * 
 * @author Andreas
 *
 */
public class FileUtil {
	
	private ArrayList<String> wholeNameList = new ArrayList<>();
	
	
	/**
	 * Sets the data of criminals from the file.
	 * @param filename
	 */
	public void setCriminalsContentFromFile(String filename){
		File file = new File(System.getProperty("user.dir")+"/"+ filename);
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()){
				wholeNameList.add(scanner.nextLine());
				
			}
			Criminals.setWholeNameList(wholeNameList);
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
