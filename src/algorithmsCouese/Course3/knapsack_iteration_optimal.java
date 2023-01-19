package algorithmsCouese.Course3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class knapsack_iteration_optimal {
	
	public static class itemInfo {
		public int value;
		public int weight;
		public itemInfo(int value,int weight) {
			this.value=value;
			this.weight=weight;
		}
	}
	
	
	private static File file = new File("src/algorithmsCouese/Course3/knapsack1.txt");
//	private static File file = new File("src/algorithmsCouese/Course3/input_random_40_1000000_2000.txt");
//	private static File file = new File("src/algorithmsCouese/Course3/case1.txt");
	private static ArrayList<itemInfo> items = new ArrayList<>(); 
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		setitemList();
		
		//Initialization Array 2D
		int itemsNumber = items.get(0).weight;
		int knapsacksize = items.get(0).value;
		
		int[] Afinal = new int[knapsacksize+1];
		
		for (int i=1;i<=itemsNumber;i++) {
			
			int[] Aold = Arrays.copyOf(Afinal, Afinal.length);
			int[] Anew = new int[knapsacksize+1];
			
			for (int x=0;x<=knapsacksize;x++) {
				int newX = x-items.get(i).weight;
				if (newX >=0) {
					Anew[x]=Math.max(Aold[x], Aold[x-items.get(i).weight]+items.get(i).value);
				}else {
					Anew[x]=Math.max(Aold[x], 0);
				}
			}
			Afinal = Arrays.copyOf(Anew, Anew.length);
		}
		System.out.println("Answer :"+Afinal[knapsacksize]);
	}
	private static void setitemList() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new FileReader(file));
		try {
			// Read first line of text from the file
			String line = input.readLine();
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
