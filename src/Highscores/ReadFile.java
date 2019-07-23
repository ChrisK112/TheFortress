package Highscores;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile {
	private String path;
	
	public ReadFile(String file_path) {
		path = file_path;
	}
	
	public String[] OpenFile() throws IOException{
		
		FileReader filereader = new FileReader(path);
		BufferedReader textReader = new BufferedReader(filereader);
		
		int numberOfLines = 10;
		String[] textData = new String[numberOfLines];
		
		for (int i=0; i < numberOfLines; i++) {
			textData[i] = textReader.readLine();
			}
		textReader.close( );
		return textData;
	}
	
	
	
	
	
	
	
	
	
	
}
