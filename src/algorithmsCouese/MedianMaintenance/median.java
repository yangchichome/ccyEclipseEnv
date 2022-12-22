package algorithmsCouese.MedianMaintenance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class median {
	public static File file = new File("src/algorithmsCouese/MedianMaintenance/mediansC1.txt");
	
	public static void addNumber (int number,PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		if (lowers.size() == 0 || number < lowers.peek()) {
			lowers.add(number);
		}else {
			highers.add(number);
		}
	}
	
	public static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
		
		if (biggerHeap.size() - smallerHeap.size() >=2) {
			smallerHeap.add(biggerHeap.poll());
		}
	}
	
	public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
		
		if (biggerHeap.size() == smallerHeap.size()) {
			return ((double)biggerHeap.peek() + smallerHeap.peek()) / 2;
		}else {
			return biggerHeap.peek();
		}
	}
	
	public static double[] getMedians(int[] array) {
		PriorityQueue<Integer> lowers = new PriorityQueue<Integer> (new Comparator<Integer> () {
			public int compare(Integer a,Integer b) {
				return -1 * a.compareTo(b);
			}
		});
		PriorityQueue<Integer> highers = new PriorityQueue<Integer> ();
		double[] medians = new double[array.length];
		for (int i = 0;i<array.length;i++) {
			int number = array[i];
			addNumber(number,lowers,highers);
			rebalance(lowers,highers);
			medians[i] = getMedian(lowers,highers);
		}
		return medians;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] arrayInt = getinput();
		double[] medians = getMedians(arrayInt);
		double answers = Arrays.stream(medians).sum() % 10000 ;
		System.out.println("End");
	}
	
	private static int[] getinput() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new FileReader(file));
		ArrayList<Integer> listInt = new ArrayList<>();
;		try {
			// Read a line of text from the file
			String line = input.readLine();
			while (line != null) {
				// Split the line of text into a vector of Strings
//		    	String[] vector = line.split(" ");
				String[] vector = line.split("\t");

				// get node and edge
				int tmpvertices = Integer.parseInt(vector[0]);

				listInt.add(tmpvertices);

				// Read a new line of text
				line = input.readLine();
			} // while
		} // try
		finally {
			input.close();
		} // finally

//		Integer[] arrInt = new Integer[listInt.size()];
		int[] arrInt = listInt.stream().mapToInt(i->i).toArray();
		return arrInt;
	}

}
