package algorithmsCouese.Course1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Inversions {
	
	public static Long CountInverse(long[] longs) {
		int len = longs.length;
		if (len == 1) return 0l;
		else {
			
			int mid = len/2;
//			System.out.prLongln("Longs is :"+Arrays.toString(Longs));
			long[] Longsleft = Arrays.copyOfRange(longs, 0, mid);
//			System.out.prLongln("Longsleft is :"+Arrays.toString(Longsleft));
			long[] Longsright = Arrays.copyOfRange(longs, mid, len);
//			System.out.prLongln("Longsright is :"+Arrays.toString(Longsright));
			Long left = CountInverse(Longsleft);	
			Long right = CountInverse(Longsright);	
			Long split = CountSplit(longs);
			System.out.println("left:"+left);
			System.out.println("right:"+right);
			System.out.println("split:"+split);
			
			Long sum = left+right+split;
			System.out.println("sum:"+sum);
			return left + right + split;
		}
	}
	
	public static Long CountSplit(long[] longs) {
		int len = longs.length;
		if (len == 1) return 0l;
		else {
			int mid = len/2;
			Long count = 0l;
			for (int i=0;i<mid;i++) {
				for(int j=mid;j<len;j++) {
//					System.out.prLongln("i:"+i+" j:"+j);
					if (longs[i]>longs[j])	count++;	
				}
			}
			System.out.println("count:"+count);
			return count;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub 
		List<Long> stngFile = new ArrayList<Long>();
		Scanner scnr = new Scanner(new FileReader("src/algorithmsCouese/Course1/IntegerArray.txt"));
		Long str;
		while (scnr.hasNext()) {
		            str = Long.valueOf(scnr.next());
		            stngFile.add(str);
		        }
		long[] Longs = stngFile.stream().mapToLong(i->i).toArray();
		Long sum = CountInverse(Longs);
		System.out.println("Inverse total is :"+sum);
		
	}

}
