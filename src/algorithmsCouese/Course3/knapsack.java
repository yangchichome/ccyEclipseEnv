package algorithmsCouese.Course3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import algorithmsCouese.Course3.Huffman.symBol;

public class knapsack {
	
	public static class itemInfo {
		public int value;
		public int weight;
		public itemInfo(int value,int weight) {
			this.value=value;
			this.weight=weight;
		}
	}
	
//	private static File file = new File("src/algorithmsCouese/Course3/knapsack1.txt");
	private static File file = new File("src/algorithmsCouese/Course3/input_random_10_100_10.txt");
//	private static File file = new File("src/algorithmsCouese/Course3/case2.txt");
	private static ArrayList<itemInfo> items = new ArrayList<>(); 
	private static int knapsacksize;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		setitemList();
		
		//Initialization Array 2D
		int itemsNumber = items.get(0).weight;
		int knapsacksize = items.get(0).value;
		
		int[][] A2d = new int[itemsNumber+1][knapsacksize+1];
		for (int i=0;i<=knapsacksize;i++) {
			A2d[0][i]=0;
		}
		for (int i=1;i<=itemsNumber;i++) {
			for (int x=0;x<=knapsacksize;x++) {
				int newX = x-items.get(i).weight;
				if (newX >=0) {
					A2d[i][x]=Math.max(A2d[i-1][x], A2d[i-1][x-items.get(i).weight]+items.get(i).value);
				}
			}
		}
		System.out.println("Answer :"+A2d[itemsNumber][knapsacksize]);
		System.out.print("End");
	}
	private static void setitemList() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new FileReader(file));
		try {
			// Read first line of text from the file
			String line = input.readLine();
//			String[] strs = line.split(" ");
//			knapsacksize = Integer.parseInt(strs[0]);
////			remove first line 
//			line = input.readLine();
			while (line != null) {
				// Split the line of text  a vector of Strings
				String[] itemStr = line.split(" ");
				int itemValue = Integer.parseInt(itemStr[0]);
				int itemWeight = Integer.parseInt(itemStr[1]);
				itemInfo item = new itemInfo(itemValue,itemWeight);
				items.add(item);
				// Read a new line of text
				line = input.readLine();
			} // while
		} // try
		finally {
			input.close();
		} // finally
	}
}
