package algorithmsCouese.Course3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class knapsack_recursive {
	
	public static class itemInfo {
		public int value;
		public int weight;
		public itemInfo(int value,int weight) {
			this.value=value;
			this.weight=weight;
		}
	}
	public static class corrdinate {
		public int X;
		public int Y;
		public corrdinate(int X,int Y) {
			this.X=X;
			this.Y=Y;
		}
	}
	
//	private static File file = new File("src/algorithmsCouese/Course3/knapsack1.txt");
	private static File file = new File("src/algorithmsCouese/Course3/input_random_10_100_10.txt");
//	private static File file = new File("src/algorithmsCouese/Course3/case1.txt");
	private static ArrayList<itemInfo> items = new ArrayList<>(); 
	private static HashMap<corrdinate,Integer> valueMap = new HashMap<corrdinate,Integer>(); 
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		setitemList();
		
		//Initialization Array 2D
		int itemsNumber = items.get(0).weight;
		int knapsacksize = items.get(0).value;
		
		int maxValue = knapsack(itemsNumber,knapsacksize);
		
		System.out.println("Answer :"+maxValue);
	}
	private static int knapsack(int itemsNumber, int knapsacksize) {
		// TODO Auto-generated method stub
		
		corrdinate corNow = new corrdinate(itemsNumber,knapsacksize);
		if (valueMap.containsKey(corNow)) return valueMap.get(corNow);
		
		if (itemsNumber == 0 || knapsacksize ==0) {
			valueMap.put(corNow, 0);
			System.out.println("X :"+itemsNumber+" Y :"+knapsacksize);
			return 0;
		}
		int valueExcluded = knapsack(itemsNumber-1,knapsacksize);
		int valueIncluded = 0;
		if (knapsacksize >= items.get(itemsNumber).weight) {
			valueIncluded =	knapsack(itemsNumber-1,knapsacksize-items.get(itemsNumber).weight)+items.get(itemsNumber).value;
		}
		int maxFinal = Math.max(valueExcluded, valueIncluded);
		valueMap.put(corNow, maxFinal);
		System.out.println("X :"+itemsNumber+" Y :"+knapsacksize);
		return maxFinal;
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
