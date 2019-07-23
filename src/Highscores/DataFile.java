package Highscores;
import java.io.File;
import java.io.IOException;

import Game.Highscores;

public class DataFile {
	private static int newScore = NewScore.score;
	private static String newName = NewScore.name;
	private static String[] names;
	private static int[] scores;
	
			

	public static void sortScores() throws IOException{		
		String file_name = "/C:/Users/Chris112/Desktop/highscores.txt/";
		String new_file_name = "/C:/Users/Chris112/Desktop/newhighscores.txt/";	
		File oldFileName = new File("/C:/Users/Chris112/Desktop/highscores.txt/");
	    File newFileName = new File("/C:/Users/Chris112/Desktop/newhighscores.txt/");
	    WriteFile data = new WriteFile(new_file_name, true);
			ReadFile file = new ReadFile(file_name);
			String[] aryLines = file.OpenFile( );
			String name, oldName, score;
			int scoreInt, oldScore;
			int[] scoreArray = new int[10];
			String[] nameArray = new String[10];
			
			for (int i=0; i < aryLines.length; i++ ) {
				name =  aryLines[i].replaceAll("\\d+.*", "");
				score =  aryLines[i].replaceAll("\\D", "");
				scoreInt = Integer.parseInt(score);

				if(newScore>scoreInt){
					oldScore = scoreInt;
					scoreInt = newScore;
					newScore = oldScore;
					oldName = name;
					name = newName;
					newName = oldName;
									
				}
				scoreArray[i] = scoreInt;	
				nameArray[i] = name;
				data.writeToFile(nameArray[i] + scoreArray[i]);
				}
			scores = scoreArray;
			names = nameArray;

			oldFileName.delete();
			newFileName.renameTo(oldFileName);
			
		
		
	}
	public static int[] getScores(){
		return scores;
	}
	public static String[] getNames(){
		return names;
	}
}


//new score -- open score file -- read score file -- compare new score to old scores 
//-- replace if bigger than an old score -- close score file
