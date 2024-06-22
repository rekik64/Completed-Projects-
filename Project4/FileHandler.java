/*
* Author: Rekik Amme 
* Course: COP3503
* Project #: 4
* Title : GUI
* Due Date: 4/28/2024
*/
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// TODO: Auto-generated Javadoc
/**
 * The Class FileHandler.
 */
public class FileHandler {

    /** The survey file. */
    private String surveyFile = "survey_results.csv";
    
    /** The file output. */
    private FileWriter fileOutput;
    
    /** The print writer. */
    private PrintWriter printWriter;
    
    /**
     * Instantiates a new file handler.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public FileHandler() throws IOException{
    	try(FileWriter fileWriter = new FileWriter(surveyFile, false);
    			PrintWriter printWriter = new PrintWriter(fileWriter)){
    				printWriter.println("DateTime,FirstName,LastName,PhoneNumber,Email,"
    						+ "Sex,Water,Meal,Wheat,Sugar,Dairy,Miles,Weight");// Write the header line to csv file
    			}
    	
    	String surveyFile = "survey_results.csv";
    	
    }
    
    /**
     * Write results.
     *
     * @param surveyData the survey data
     */
    public void writeResults(String surveyData) {
    	try(FileWriter fileWriter = new FileWriter(surveyFile, true);
    			PrintWriter printWriter = new PrintWriter(fileWriter)){
    				
    				String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yy HH:mm:ss"));//Get current data & time
    				printWriter.println(dateTime + "," + surveyData);//Write survey data 
    			}catch (IOException ioException) {//Error message
    				System.out.println(ioException.getMessage());
    				ioException.printStackTrace();
    			}
    }

	/**
	 * Gets the file output.
	 *
	 * @return the file output
	 */
	public FileWriter getFileOutput() {
		return fileOutput;
	}

	/**
	 * Sets the file output.
	 *
	 * @param fileOutput the new file output
	 */
	public void setFileOutput(FileWriter fileOutput) {
		this.fileOutput = fileOutput;
	}

	/**
	 * Gets the prints the writer.
	 *
	 * @return the prints the writer
	 */
	public PrintWriter getPrintWriter() {
		return printWriter;
	}

	/**
	 * Sets the prints the writer.
	 *
	 * @param printWriter the new prints the writer
	 */
	public void setPrintWriter(PrintWriter printWriter) {
		this.printWriter = printWriter;
	}
}
