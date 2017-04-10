package model;


import java.util.ArrayList;

/**
 * List of all terrorists
 * @author Andreas
 *
 */
public class Terrorists {
	private static ArrayList<String> lastNameList;
	private static ArrayList<String> firstNameList;
	private static ArrayList<String> middleNameList;
	private static ArrayList<String> wholeNameList;
	private static ArrayList<String> genderList;
	private static ArrayList<String> functionList;
	public static ArrayList<String> getLastNameList() {
		return lastNameList;
	}
	public static void setLastNameList(ArrayList<String> lastNameList) {
		Terrorists.lastNameList = lastNameList;
	}
	public static ArrayList<String> getMiddleNameList() {
		return middleNameList;
	}
	public static void setMiddleNameList(ArrayList<String> middleNameList) {
		Terrorists.middleNameList = middleNameList;
	}
	public static ArrayList<String> getFirstNameList() {
		return firstNameList;
	}
	public static void setFirstNameList(ArrayList<String> firstNameList) {
		Terrorists.firstNameList = firstNameList;
	}
	public static ArrayList<String> getGenderList() {
		return genderList;
	}
	public static void setGenderList(ArrayList<String> genderList) {
		Terrorists.genderList = genderList;
	}
	public static ArrayList<String> getFunctionList() {
		return functionList;
	}
	public static void setFunctionList(ArrayList<String> functionList) {
		Terrorists.functionList = functionList;
	}
	public static ArrayList<String> getWholeNameList() {
		return wholeNameList;
	}
	public static void setWholeNameList(ArrayList<String> wholeNameList) {
		Terrorists.wholeNameList = wholeNameList;
	}
}
