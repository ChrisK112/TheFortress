package Highscores;
import java.io.IOException;
import java.util.Scanner;


public class NewScore {
	static String name;
	static int score;
	
	
	public NewScore(int score, String name){
		this.name = name;
		this.score = score;
		try {
			DataFile.sortScores();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addNewScore(int score, String name){
		try {
			DataFile.sortScores();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void newPlayer(){

		addNewScore(score, name);
	
	}
	
}
