package utils;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * 
 * @author Andreas
 *
 */
public class NetworkUtil {

	public void parseXML() {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			XMLHandler userhandler = new XMLHandler();
			saxParser.parse(Constants.TERRORISTS_URL, userhandler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
