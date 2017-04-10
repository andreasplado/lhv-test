package utils;

import java.util.ArrayList;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.language.Soundex;
import model.Criminals;
import model.Terrorists;

/**
 * 
 * @author Andreas
 *
 */
public class SearchUtil {
	
	private boolean userExistsInBlackList = false;
	private int numOfReturnedResults = 1;
	private boolean atLeastOnePhoneticMatch = false;
	private ArrayList<String> possibleAnswers = new ArrayList<>();
	public boolean showSuggestions = false;
	
	public void searchName(String nameInput){
		//Replaces all commas from the string with spaces(more from the substring match)
		
		String commasRemovedFromName = nameInput.replace(",", " ");
	
		
		ArrayList<String> wholeNameList = Terrorists.getWholeNameList();
		ArrayList<String> blackList = Criminals.getWholeNameList();
		

		
		for(int i=0; i< wholeNameList.size(); i++){
			String nameFromXMLWithSpecialChars = wholeNameList.get(i);
			//replace all special characters with nothing(eg. arab chars)
			//if this wont happen the Soundex throws exception because of unmapped charaters.
			String nameFromXML = nameFromXMLWithSpecialChars.replaceAll("[ ](?=[ ])|[^-_,A-Za-z0-9 ]+", ""); 
			for(int j=0; j< blackList.size(); j++){
				String nameFromFile = blackList.get(j);
				
				// check whether the XML data contains text form .txt file.
				// and with the given parameter that user typed or does the input have phonetic match eg. "Toomas" will be retrieved after input "Tomas"(typo).
				phoneticMatch(commasRemovedFromName, nameFromXML, nameFromFile);
				if(substringMatch(commasRemovedFromName, nameFromXML, nameFromFile)){
					
					printOutResult(nameFromXML, true);
				}
			}

		}
		showPossibleAnswers(nameInput);

	}
	
	/**
	 * Show possible variants if you return result with phonetic search
	 * @param nameInput
	 */
	private void showPossibleAnswers(String nameInput) {
		if(!userExistsInBlackList){
			System.out.println("\"" + nameInput + "\" does not exist in blacklist!");
			if(atLeastOnePhoneticMatch){
				
				//if there are at least one phonetic match then
				if(possibleAnswers.size() > 0){
					showSuggestions = true;
					System.out.print("Did you mean \"");
					
					
					for(int i=0; i<possibleAnswers.size(); i++){
						if(possibleAnswers.size() > 1){
							System.out.print( possibleAnswers.get(i) + " ");
						}else{
							System.out.print( possibleAnswers.get(i));
						}
						
						if(i == possibleAnswers.size() -1){
							System.out.print("\"?");
						}
					}
					possibleAnswers.clear();
				}
			}
			System.out.println("");
		}
	}
	
	public void printOutResult(String namefromXML, boolean substringMatch){
		System.out.println("Result " + numOfReturnedResults +":"+ namefromXML);
		numOfReturnedResults++;
		if(substringMatch){
			userExistsInBlackList = true;
		}
	}
	
	private boolean substringMatch(String nameInput, String nameFromXML, String nameFromFile){
		return nameFromXML.toLowerCase().contains(nameFromFile.toLowerCase())
		&& nameFromFile.toLowerCase().contains(nameInput.toLowerCase());
	}
	
	/**
	 * This metod returns the results of phonetic search. Eg. if you make type during search
	 * you want to search for "Osama" but type in "Obama" it returns the possible search item that is in names.txt blacklist
	 * @param nameInput a user input for search query
	 * @param nameFromXML name gotten from xml(terrorists data)
	 * @param nameFromFile name gotten from file(criminals data)
	 * @return
	 */
	private void phoneticMatch(String nameInput, String nameFromXML, String nameFromFile){
		Soundex soundex = new Soundex(); // library for phonetic string match
		ArrayList<Boolean> matchList = new ArrayList<>();
		if(nameFromXML.contains(" ")){
			//iterate all words separated by space(for every word difference)
			for(String singleWordFromXML : nameFromXML.split(" ")) {
				for(String singleWordFromFile: nameFromFile.split(" ")){
					try {
						int compareInputWithFile = soundex.difference(nameInput, singleWordFromFile.toLowerCase());
						int compareInputWithXML = soundex.difference(nameInput, singleWordFromXML.toLowerCase());
						if(compareInputWithFile > 2 && compareInputWithXML > 2){
							//add boolean true into matchList if difference equals 2 (4 means the closest result for search query)
							
							if(!possibleAnswers.contains(singleWordFromFile)){
								possibleAnswers.add(singleWordFromFile);
								matchList.add(true);
							}
							matchList.add(false);
						}else{

						}
					} catch (EncoderException e) {
						e.printStackTrace();
					}
				}

			}
		}
		for(int i=0; i<matchList.size(); i++){
			//if single word separated by space is in list
			if(matchList.get(i)== true){
				//one of the searchable word matches with returned result.
				atLeastOnePhoneticMatch = true;
			}
		}

	}
}
