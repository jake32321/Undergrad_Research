import java.util.*;
import uk.ac.wlv.sentistrength.*;


public class SentiTool {

	/**
	 * @param args
	 * @author jacob reed
	 * @category sentiment analysis
	 */
	
	private static final String SENTI_DATA_PATH = "/home/jacob/Development/Undergrad_Research/SentiStrength/SentStrength_Data_Sept2011/";
	private static String mode, textOrFile;
	private static char explainStat = ' ';
	private static Scanner in = new Scanner(System.in); // This will read user input and will allow 
	
	public static void main(String[] args) {
		System.out.println("Please enter text to be analyzed:");
		textOrFile = in.nextLine();
		while(explainStat != 'y' && explainStat != 'n'){
			System.out.println("Would you like to have the results explained?[y/n]");
			explainStat = in.next().charAt(0);
		}
		execSentiStrength(textOrFile, explainStat); // Makes a call that runs SentiStrength with the given data
	}
	
	/**
	 * @param userInput String or file path for the text to be examined
	 * @param explainFLag String that determines if the user wants the results explained
	 * */
	public static void execSentiStrength(String userInput, char explainFlag){
		 ArrayList<String> sshInitializationAndText;
		
		//Creates the list where the the various parts of the command to run SentiStrength will be stored
		sshInitializationAndText = new ArrayList<String>();
		sshInitializationAndText.add("sentidata");
		sshInitializationAndText.add(SENTI_DATA_PATH);
		sshInitializationAndText.add("text"); 
		sshInitializationAndText.add(userInput); 
		
		// Checks to see if the user wishes to have the results explained to them
		if(explainFlag == 'y'){
			sshInitializationAndText.add("explain");
		}
		
		// Converts the list to  a string form to be passed as the input 
		String cliArgs[] = sshInitializationAndText.toArray(new String[sshInitializationAndText.size()]);
		
		// Runs SentiStrength using the user declared variables 
		SentiStrength.main(cliArgs); 
	}

}
