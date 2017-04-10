package utils;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import model.Terrorists;

/**
 * Class for handling XML data.
 * This class persists retrieved XML data into the model fields.
 * @author Andreas
 *
 */
public class XMLHandler extends DefaultHandler {
	
	boolean bLastName = false;
	boolean bFirstName = false;
	boolean bMiddleName = false;
	boolean bWholeName = false;
	boolean bGender = false;
	boolean bFunction = false;
	
	private ArrayList<String> lastNameList = new ArrayList<>();
	private ArrayList<String> firstNameList = new ArrayList<>();
	private ArrayList<String> middleNameList = new ArrayList<>();
	private ArrayList<String> wholeNameList = new ArrayList<>();
	private ArrayList<String> genderList = new ArrayList<>();
	private ArrayList<String> functionList = new ArrayList<>();

	
	@Override
	public void startElement(String uri, String localName, 
			String qName, Attributes attributes) 
			throws SAXException {
		// TODO Auto-generated method stub
		if(qName.equalsIgnoreCase("LASTNAME")){
			bLastName = true;
		} else if(qName.equalsIgnoreCase("FIRSTNAME")){
			bFirstName = true;
		}else if(qName.equalsIgnoreCase("MIDDLENAME")){
			bMiddleName = true;
		}else if(qName.equalsIgnoreCase("WHOLENAME")){
			bWholeName = true;
		}else if(qName.equalsIgnoreCase("GENDER")){
			bGender = true;
		}else if(qName.equalsIgnoreCase("FUNCTION")){
			bFunction = true;
		}
	}
	@Override
	public void characters(char[] ch, int start, int length) 
			throws SAXException {
		if(bLastName){
			String lastName = new String(ch, start, length);
			lastNameList.add(lastName);
			bLastName = false;
		}
		if(bFirstName){
			String firstName = new String(ch, start, length);
			firstNameList.add(firstName);
			bFirstName = false;
		}
		if(bMiddleName){
			String middleName = new String(ch, start, length);
			middleNameList.add(middleName);
			bMiddleName = false;
		}
		if(bWholeName){
			String wholeName = new String(ch, start, length);
			wholeNameList.add(wholeName);
			bWholeName = false;
		}
		if(bGender){
			String gender = new String(ch, start, length);
			genderList.add(gender);
			bGender = false;
		}
		if(bFunction){
			String function = new String(ch, start, length);
			functionList.add(function);
			bFunction = false;
		}

	}
	@Override
	public void endDocument() throws SAXException {
		Terrorists.setLastNameList(lastNameList);
		Terrorists.setFirstNameList(firstNameList);
		Terrorists.setMiddleNameList(middleNameList);
		Terrorists.setWholeNameList(wholeNameList);
		Terrorists.setGenderList(genderList);
		Terrorists.setFunctionList(functionList);
		
	}

}
