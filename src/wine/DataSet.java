package wine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public final class DataSet {

	private DataSample[] dataArray;

	public DataSet(String filename) {

		try {
			this.dataArray = new DataSample[getDataSetSize(filename)];
			readDataSet(filename);
		} catch (FileNotFoundException e) {
			System.out.println("Error occured when loading a file " + filename);
			System.out.println(e);
		}

		/*
		 * while (input.hasNextLine()) { String[] sampleArr =
		 * ((input.next()).split(",")); double[] attr = new
		 * double[sampleArr.length - 1]; label_s =
		 * Integer.parseInt(sampleArr[0]);
		 * 
		 * for (int j = 0; j < (sampleArr.length - 1); j++) { attr[j] =
		 * Double.parseDouble(sampleArr[j + 1]); } DataSample data = new
		 * DataSample(label_s, attr);
		 * 
		 * dataArray[i] = data; i++; } String taskOutputString =
		 * "Mean of class 1: " + Arrays.toString(this.getMean(1)) + "\n" +
		 * "Std of class 1: " + Arrays.toString(this.getStd(1)) + "\n" +
		 * "Mean of class 2: " + Arrays.toString(this.getMean(2)) + "\n" +
		 * "Std of class 2: " + Arrays.toString(this.getStd(2)) + "\n" +
		 * "Mean of class 3: " + Arrays.toString(this.getMean(3)) + "\n" +
		 * "Std of class 3: " + Arrays.toString(this.getStd(3)) + "\n";
		 */
	}

	private void readDataSet(String fileName) throws FileNotFoundException {
		File file = new File(fileName);

		Scanner input = new Scanner(file);

		int i = 0;

		while (input.hasNextLine()) {
			String[] sampleArr = ((input.next()).split(","));
			double[] attr = new double[sampleArr.length - 1];

			int label = Integer.parseInt(sampleArr[0]);

			for (int j = 0; j < (sampleArr.length - 1); j++) {
				attr[j] = Double.parseDouble(sampleArr[j + 1]);
			}

			dataArray[i++] = new DataSample(label, attr);
		}
		input.close();

	}

	public int getDataSetSize(String filename) {				
		int samples = 0;
		File file = new File(filename);
		
		try {
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				input.nextLine();
				samples++;
			}
			input.close();		
		} catch (FileNotFoundException e) {
			System.out.println("Error occured when loading a file " + filename);
			System.out.println("# of samples set to 0");
			System.out.println(e);
		}	

		return samples;
	}

	public double[] getMean(int label) {
		return null;
	}

	public double[] getStd(int label) {
		return null;
	}

	public DataSample[] getDataSet() {
		return dataArray;
	}
}
