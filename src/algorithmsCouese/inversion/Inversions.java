package algorithmsCouese.inversion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Inversions {
	
	public static Integer CountInverse(int[] ints) {
		int len = ints.length;
		if (len == 1) return 0;
		else {
			
			int mid = len/2;
//			System.out.println("ints is :"+Arrays.toString(ints));
			int[] intsleft = Arrays.copyOfRange(ints, 0, mid);
//			System.out.println("intsleft is :"+Arrays.toString(intsleft));
			int[] intsright = Arrays.copyOfRange(ints, mid, len);
//			System.out.println("intsright is :"+Arrays.toString(intsright));
			int left = CountInverse(intsleft);	
			int right = CountInverse(intsright);	
			int split = CountSplit(ints);
			System.out.println("left:"+left);
			System.out.println("right:"+right);
			System.out.println("split:"+split);
			
			int sum = left+right+split;
			System.out.println("sum:"+sum);
			return left + right + split;
		}
	}
	
	public static Integer CountSplit(int[] ints) {
		int len = ints.length;
		if (len == 1) return 0;
		else {
			int mid = len/2;
			int count = 0;
			for (int i=0;i<mid;i++) {
				for(int j=mid;j<len;j++) {
//					System.out.println("i:"+i+" j:"+j);
					if (ints[i]>ints[j])	count++;	
				}
			}
			System.out.println("count:"+count);
			return count;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub 
		List<Integer> stngFile = new ArrayList<Integer>();
		Scanner scnr = new Scanner(new FileReader("src/algorithmsCouese/intsData.txt"));
		Integer str;
		while (scnr.hasNext()) {
		            str = Integer.valueOf(scnr.next());
		            stngFile.add(str);
		        }
//		int[] ints = new int[stngFile.size()];
		int[] ints = stngFile.stream().mapToInt(i->i).toArray();
//		ints = stngFile.toArray();
//		int[] ints = { 54044, 14108, 79294, 29649, 25260, 60660, 2995, 53777, 49689, 9083};
		
		int sum = CountInverse(ints);
		System.out.print("Inverse total is :"+sum);
		
	}

}
