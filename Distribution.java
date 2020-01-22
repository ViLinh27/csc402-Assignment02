package assignment2;
//Linh Nguyen
import algs4.StdIn;
import algs4.StdOut;

import java.lang.Math;

public class Distribution {

	public static void main(String[] args) {
		StdIn.fromFile("data/normaldistribution.txt");//opens and reads file
		double[] num = StdIn.readAllDoubles(); //goes through values to put into array num
		
		//print out everything:
		double mean = calcMean(num);
		double sd=calcDeviation(num);
		/*
		 Need to find condition for 1,2,3 SD away from mean
		 */
		StdOut.println("Statistic on the data/normaldistribution.txt file: ");
		StdOut.println("\nThe mean is "+mean);
		StdOut.println("\nThe standard deviation is "+sd);
		//what I should get as range:
		/* Approximately 68% of the data values will fall within 1 standard deviation of the mean, from 
		 -1.0160800091362 to 1.0071442759868.*/
		StdOut.println("\nPercentage of values 1 SD away from mean: ");
		//what I should get as range:
		/*Approximately 95% of the data values will fall within 2 standard deviations of the mean, from 
		 -2.0276921516977 to 2.0187564185484.*/
		StdOut.println("\nPercentage of values 2 SD away from mean: ");
		//what I should get as range:
		/*Approximately 99.7% of the data values will fall within 3 standard deviations of the mean, from 
		-3.0393042942593 to 3.0303685611099.*/
		StdOut.println("\nPercentage of values 3 SD away from mean: " );
		StdOut.println("\n");
	}
	
	public static double calcMean(double[] num) {
		//calc mean:
		double total = 0;
		// This is a for-each loop
		for (double value: num) {
			total += value;
		}
		double mean = (double)total/num.length;
		return mean;
	}
	
	public static double calcDeviation(double [] num) {
	//calc standard dev:
		double tSqres = 0;
		
		for(double value: num) {
			double nDif =value-calcMean(num);//subtract mean from each num.
			double Sqres = nDif*nDif;

			tSqres+=Sqres;//add up squares of nDif
		}

		//work out mean of Sqres and square root that
		double SqMean=(double)tSqres/num.length;
		double sdev=Math.sqrt(SqMean);
		
		return sdev;
	}
	public static void sdAway(double[]num) {//make sure to change return type to double and add return statement eventually
		double cMean = calcMean(num);
		double sd1 = calcDeviation(num)-cMean;
		double sd1Top = calcDeviation(num)+cMean;
		double sd2 = calcDeviation(num)-(2*cMean);
		double sd2Top= calcDeviation(num)+(2*cMean);
		double sd3;
		double sd3Top;
		//percent 1 SD
		//percent 2 SD
		//percent 3 SD
	}
}
