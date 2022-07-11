import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class scattergories {

	public static void main(String[] args) {
		// set up game
		String answers[] = {"x","x"};
		String answers2[] = {"x","x"};
		int currentAnswers = 0;
		int currentAnswers2 = 0;
		ArrayList<String> words = new ArrayList<>();
		char letters[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		try {
			File myObj = new File("file1.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				words.add(data);
			}
			myReader.close();
			System.out.println(words);
		} catch (FileNotFoundException e) { 
			System.out.println("An error occured.");
			e.printStackTrace();
							
		}

		//randomly select letter
		Random rand = new Random();
		int randomLetter = rand.nextInt(26);
		char gameLetter = letters[randomLetter];

		
		Scanner myScan = new Scanner(System.in);
		System.out.println("Would you like to play?");
		String userInput = myScan.nextLine();
		System.out.println(userInput);
		
		if (userInput.equals("yes")){
			boolean game = true;
			while (game == true) {
			// answer one, buildings
	
			if (answers[0].equals("x")){
				System.out.println("Give me a building that starts with " + gameLetter);
				userInput = myScan.nextLine();
				if(userInput.equals("skip")) {
					answers[0]=answers[0];
				}
				else if(userInput.charAt(0) == gameLetter) {
					answers[0]=userInput;
					currentAnswers +=1;
				}
			}
			
			if (answers[1].equals("x")) {
				System.out.println("Give me a person that's name starts with a " + gameLetter);
				userInput = myScan.nextLine();
				if(userInput.equals("skip")) {
					answers[1]=answers[1];
				}
				else if(userInput.charAt(0) == gameLetter) {
					answers[1]=userInput;
					currentAnswers += 1;
			//player 2
					
			if (currentAnswers == 2) {
				System.out.println("Player 2's turn:");
				boolean player2Game = true;
				while(player2Game == true) {
					if (answers2[0].equals("x")){
						System.out.println("Give me a building that starts with " + gameLetter);
						userInput = myScan.nextLine();
						if(userInput.equals("skip")) {
							answers2[0]=answers2[0];
						}
						else if(userInput.charAt(0) == gameLetter) {
							answers2[0]=userInput;
							currentAnswers2 +=1;
					}
					}
					if (answers2[1].equals("x")) {
						System.out.println("Give me a person that's name starts with a " + gameLetter);
						userInput = myScan.nextLine();
						if(userInput.equals("skip")) {
							answers2[1]=answers[1];
						}
						else if(userInput.charAt(0) == gameLetter) {
							answers2[1]=userInput;
							currentAnswers2 += 1;
					if (currentAnswers2 == 2) {
						break;
					}
					}
			}
				}
			// results
			System.out.println("Player 1 Answers:\r\nBuilding:" + answers[0] + "\r\nPeople: " + answers[1]);
			System.out.println("Player2, how many of Player 1's answers were valid?");
			userInput = myScan.nextLine();
			String player1Score = userInput;
			System.out.println(answers2[1]);
			System.out.println("Player1, how many of Player2's answers were valid?");
			userInput = myScan.nextLine();
			String player2Score = userInput;
			System.out.println("Final Score:\r\nPlayer1: " + player1Score + "\r\nPlayer2: " + player2Score + "\r\nThank you for playing!");
			}
	
			}
		
		} 
		}
		

		
			System.out.println(answers);
	} else {
		System.out.println("Somethingggg went wrong");
		
	}

	}
}
