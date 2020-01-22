package assignment2;
//Linh Nguyen
import algs4.StdAudio;
import algs4.StdIn;

public class PlayTones {

	public static void main(String[] args) {
		//reads a file of double values 
		//representing sound frequencies into an 
		//array. It then iterates through the array
		//and plays each frequency for one quarter 
		//second. Create and place in the data folder
		//a file called a2song.txt with the frequencies of 
		//your choice. Write your program so that it reads 
		//from that file.
		
		StdIn.fromFile("data/a2song.txt");//opens and reads text file
		double[] freq = StdIn.readAllDoubles();
		
		//iterate through file:
		for(double t:freq){
			playTone(t,0.25);
		}
		
		
		//close and exit
		StdAudio.close();
        System.exit(0);

	}
	
	public static void playTone(double frequency, double duration) {
		final int sliceCount = (int) (StdAudio.SAMPLE_RATE * duration);
		final double[] slices = new double[sliceCount+1];
		for (int i = 0; i <= sliceCount; i++) {
			slices[i] = Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
		}
		StdAudio.play(slices);
	}

}
