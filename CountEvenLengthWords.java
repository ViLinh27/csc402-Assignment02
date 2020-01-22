package assignment2;
//Linh Nguyen
import algs4.StdIn;
import algs4.StdOut;

public class CountEvenLengthWords {

	public static void main(String[] args) {
		String textSource = "data/tale.txt";
		StdIn.fromFile(textSource);
		String bookText = StdIn.readAll();
		String[] bookWords = bookText.split("\\s+");
		
		//loop through bookwords to figure out which are even
		int eWcounter=0;
		for(String word: bookWords) {
			if(word.length()%2==0) {
				//add to eWcounter if even words
				eWcounter+=1;
			}
		}
		
		//print # of even words
		StdOut.println("There are are "+ eWcounter+" words with an even length of words in tale.txt");
	}

}
