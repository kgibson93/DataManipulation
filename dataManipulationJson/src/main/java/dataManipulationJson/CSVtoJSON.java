package dataManipulationJson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.ArrayList;
public class CSVtoJSON {
	
	void makeJson() throws IOException{
		
		//Reads in the CSV and Makes the file to write the JSON too
		BufferedReader csvFile= new BufferedReader(new FileReader("C:/Users/Kevin/Documents/kaggle/PokemonTest.csv"));
		BufferedWriter jsonFile=new BufferedWriter(new FileWriter("C:/Users/Kevin/Documents/kaggle/converted.txt"));

		//Reads Data Line by line
		String csvData = csvFile.readLine();
				
		//Saves the first line as the key values
		String header = csvData;
		String[] splitHeader = header.split(",");
				
		csvData = csvFile.readLine();
		while (csvData != null){
			//initializes the string which will hold the jsons
			StringBuilder jsonString = new StringBuilder();

			//Split the CSV by commas and iterate through to match all values with their keys
			String[] splitData = csvData.split(",");
			for(int i = 0; i < splitHeader.length;i++){
				if (i == 0){
					jsonString.append("{");
					jsonString.append("\"" + splitHeader[i] + "\"" + " : " + "\"" + splitData[i] + "\",");
					//.out.println("{");
					//System.out.println("\"" + splitHeader[i] + "\"" + " : " + "\"" + splitData[i] + "\",");
				}
				else if (i == splitHeader.length - 1){
					jsonString.append("\"" + splitHeader[i] + "\"" + " : " + "\"" + splitData[i] + "\"");
					jsonString.append("}");
					//System.out.println("\"" + splitHeader[i] + "\"" + " : " + "\"" + splitData[i] + "\"");
					//System.out.println("}");
				}
				else{
					jsonString.append("\"" + splitHeader[i] + "\"" + " : " + "\"" + splitData[i] + "\",");
					//System.out.println("\"" + splitHeader[i] + "\"" + " : " + "\"" + splitData[i] + "\",");
				}
			}

			//Writes out json so each json is on its own line
			jsonFile.write(jsonString.toString());
			jsonFile.newLine();

			//read the next line of the csv
			csvData = csvFile.readLine();
		}
				
		//close stringing
		csvFile.close();
		jsonFile.close();
	}
	
	public static void main(String Args[]) throws IOException{
		
		//IDEAS IDEAS IDEAS IDEAS IDEAS IDEAS IDEAS IDEAS IDEAS IDEAS IDEAS IDEAS IDEAS IDEAS 
			//account for missing values in the data set (is "type 2": "" better then excluding type 2?)
			//You might be able to handle a second file contatining the header information or that can be an input value (that is Future Future Kevin's problem)
			//make the makeJson method take in a string and set Args[0] to be the csv file location
		
		
		CSVtoJSON CTJ = new CSVtoJSON();
		CTJ.makeJson();


	}
}
