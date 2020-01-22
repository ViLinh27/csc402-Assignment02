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
		double sd1 = sd1Away(num);
		double sd2 = sd2Away(num);
		double sd3 = sd3Away(num);
		/*
		 Need to find condition for 1,2,3 SD away from mean
		 */
		StdOut.println("Statistic on the data/normaldistribution.txt file: ");
		StdOut.println("\nThe mean is "+mean);
		StdOut.println("\nThe standard deviation is "+sd);
		//what I should get as range:
		/* Approximately 68% of the data values will fall within 1 standard deviation of the mean, from 
		 -1.0160800091362 to 1.0071442759868.*/
		StdOut.println("\nPercentage of values 1 SD away from mean: "+sd1);
		//what I should get as range:
		/*Approximately 95% of the data values will fall within 2 standard deviations of the mean, from 
		 -2.0276921516977 to 2.0187564185484.*/
		StdOut.println("\nPercentage of values 2 SD away from mean: "+sd2);
		//what I should get as range:
		/*Approximately 99.7% of the data values will fall within 3 standard deviations of the mean, from 
		-3.0393042942593 to 3.0303685611099.*/
		StdOut.println("\nPercentage of values 3 SD away from mean: "+sd3);
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
	public static double sd1Away(double[]num) {
		double cMean = calcMean(num);
		double sd1 = calcMean(num)-calcDeviation(num);
		double sd1Top =calcMean(num)+calcDeviation(num);
		double perc1Count = 0;
		for (double val: num) {
			if(val<=sd1Top && val>=sd1) {
				perc1Count++;
			}
		}
		double perc1 = (perc1Count/num.length)*100;
		return perc1;
	}
	public static double sd2Away(double[]num) {
		double cMean = calcMean(num);
		double sd2 =calcMean(num)-(2*calcDeviation(num));
		double sd2Top=calcMean(num)+(2*calcDeviation(num));
		double  perc2Count = 0;
		for (double val: num) {
			if(val<=sd2Top && val>=sd2) {
				perc2Count++;
			}
		}
		double perc2 = (perc2Count/num.length)*100;
		return perc2;
	}
	public static double sd3Away(double[] num) {
		double cMean = calcMean(num);
		double sd3 =calcMean(num)-(3*calcDeviation(num));
		double sd3Top=calcMean(num)+(3*calcDeviation(num));
		double perc3Count = 0;
		for(double val: num) {
			if(val<=sd3Top && val>=sd3) {
				perc3Count++;
			}
		}
		double perc3 = (perc3Count/num.length)*100;
		return perc3;
	}
}
