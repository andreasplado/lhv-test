package model;

import java.util.ArrayList;

/**
 * List of all blacklist retrieved from the file
 * @author Andreas
 *
 */

public class Criminals {
	private static ArrayList<String> wholeNameList;

	public static ArrayList<String> getWholeNameList() {
		return wholeNameList;
	}

	public static void setWholeNameList(ArrayList<String> wholeNameList) {
		Criminals.wholeNameList = wholeNameList;
	}

}
