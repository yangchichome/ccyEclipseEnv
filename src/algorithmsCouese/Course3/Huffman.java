package algorithmsCouese.Course3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class Huffman {
	public static class bitInfo{
		public String left;
		public String right;
		public bitInfo(String left, String right) {
			this.left =left;
			this.right =right;
		}
	}
	public static class symBol{
		public String name;
		public Integer weight;
		public symBol(String name, Integer weight) {
			this.name =name;
			this.weight =weight;
		}
	}
	
	public static class symbolCompare implements Comparator<symBol>{
		public int compare (symBol s1,symBol s2) {
			if (s1.weight > s2.weight) {
				return 1;
			}
			else if (s1.weight < s2.weight) {
				return -1;
			}
			return 0;
		}
	}
	private static File file = new File("src/algorithmsCouese/Course3/huffman.txt");
//	private static File file = new File("src/algorithmsCouese/Course3/input_random_48_10000.txt");
//	private static File file = new File("src/algorithmsCouese/Course3/case2.txt");
	private static HashMap<String,bitInfo> bitInfos = new HashMap<String,bitInfo>();
	private static HashMap<String,Integer> weights = new HashMap<String,Integer>();
	private static PriorityQueue<symBol> symbols = new PriorityQueue<symBol>(4000,new symbolCompare());
	private static HashMap<String,String> codewords = new HashMap<String,String>();
	private static Integer maxLen = Integer.MIN_VALUE;
	private static Integer minLen = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		setSymbols();
		
		while(symbols.size()>1) {
			//get symbols
			symBol smalls = symbols.poll();
			symBol bigs = symbols.poll();
			
			//set new symbol value
			System.out.println("smaller0	"+smalls.name+"	weight	"+smalls.weight+"	bigs1	"+bigs.name+"	weight	"+bigs.weight);
			Integer weightNew = smalls.weight + bigs.weight;
			String nameNew = smalls.name+"_"+bigs.name;
			symBol symbolNew = new symBol(nameNew,weightNew);
			
			symbols.add(symbolNew);
			
			bitInfo childs = new bitInfo(smalls.name, bigs.name);
			bitInfos.put(nameNew, childs);
			//update old parent
		}
		String root = symbols.poll().name;
		setcodes(root,"");
		
		for (Map.Entry<String, String> entey : codewords.entrySet()) {
			System.out.println("name : "+entey.getKey()+" weight :"+weights.get(entey.getKey())+" code: "+entey.getValue() );
		}
		
		System.out.println("maxLen : "+maxLen);
		System.out.println("minLen : "+minLen);
		System.out.println("End");
	}
	private static void setcodes(String parent,String word) {
		// TODO Auto-generated method stub
		String childLeft = bitInfos.get(parent).left;
		String childRight = bitInfos.get(parent).right;
		String leftWord = word+"0";
		String rightWord = word+"1";
		
		if (bitInfos.containsKey(childLeft)) {
			setcodes(childLeft,leftWord);
		}else {
			
			if (maxLen < leftWord.length()) 
				maxLen = leftWord.length();
			if (minLen > leftWord.length()) 
				minLen = leftWord.length();
			
			codewords.put(childLeft, leftWord);
		}
		if (bitInfos.containsKey(childRight)) {
			setcodes(childRight,rightWord);
		}else {
			
			if (maxLen < rightWord.length()) 
				maxLen = rightWord.length();
			if (minLen > rightWord.length()) 
				minLen = rightWord.length();
			
			codewords.put(childRight, rightWord);
		}
			
	}
	private static void setSymbols() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new FileReader(file));
		try {
			// Read a line of text from the file
			String line = input.readLine();
//			remove first line 
			line = input.readLine();
			Integer count = 1;
			while (line != null) {
				// Split the line of text  a vector of Strings
				symBol sTmp = new symBol(count.toString(),Integer.parseInt(line));
//				bitInfo bitInit = new bitInfo("","");
				symbols.add(sTmp);
				weights.put(count.toString(), Integer.parseInt(line));
//				bitInfos.put(line, bitInit);
				// Read a new line of text
				line = input.readLine();
				count++;
			} // while
		} // try
		finally {
			input.close();
		} // finally
	}

	//https://www.youtube.com/watch?v=21_bJLB7gyU
	//https://www.coursera.org/learn/algorithms-greedy/discussions/forums/NchaxXblEeaa3A5N6H7-Uw/threads/knryxt6AEeajfg47tRIthA
}
