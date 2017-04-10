package controller;
import utils.FileUtil;
import utils.NetworkUtil;
import utils.SearchUtil;

/**
 * 
 * @author Andreas
 *
 */
public class MainController {
	
	private NetworkUtil networkUtil;
	private FileUtil fileUtil;
	public SearchUtil searchUtil;
	
	private String blackListFileName, blackListNoiseFileName;
	
	public MainController(String blackListFileName, String noiseFileName ){
		this.blackListFileName = blackListFileName;
		this.blackListNoiseFileName = noiseFileName;
		init();
		setBlackListContent();
		setBlackListNoiseContent();
		setRetrievedXML();
	}
	
	private void init(){
		networkUtil = new NetworkUtil();
		fileUtil = new FileUtil();
		searchUtil = new SearchUtil();
	}
	
	public void setBlackListContent(){
		fileUtil.setCriminalsContentFromFile(blackListFileName);
	}
	
	public void setBlackListNoiseContent(){
		fileUtil.setCriminalsContentFromFile(blackListNoiseFileName);
	}
	
	public void setRetrievedXML(){
		networkUtil.parseXML();
	}
	
	public void getBlackListName(String blackListName){
		searchUtil.searchName(blackListName);
	}
	
	
	
	
}
