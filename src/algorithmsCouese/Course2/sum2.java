package algorithmsCouese.Course2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
public class sum2 {
	public static File file = new File("src/algorithmsCouese/Course2/algo1-programming_prob-2sum.txt");
	public static HashMap<Long,ArrayList<Long>> dividedMap = new HashMap<Long,ArrayList<Long>>();
	public static boolean[] answers = new boolean[20002];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		setDividedMap();
		BufferedReader input = new BufferedReader(new FileReader(file));
		String line = input.readLine();
		while (line != null) {
			Long x = Long.parseLong(line);
			Long ymin = -x-10000l;
			Long ymax = -x+10000l;
			Long reaminderymin = Long.remainderUnsigned(ymin, 20001l);
			Long quotientymin = Long.divideUnsigned(ymin, 20001l);
			Long reaminderymax = Long.remainderUnsigned(ymax, 20001l);
			Long quotientymax = Long.divideUnsigned(ymax, 20001l);
			if (dividedMap.containsKey(quotientymin)) {
				ArrayList<Long> remainders = dividedMap.get(quotientymin);
				for(Long remainder : remainders) {
					if (remainder >= reaminderymin) {
						Long y = quotientymin*20001l+remainder;
						Long sumL = x+y;
						int sum = sumL.intValue();
						answers[sum+10000]=true;
					}
				}
			}
			if (dividedMap.containsKey(quotientymax)) {
				ArrayList<Long> remainders = dividedMap.get(quotientymax);
				for(Long remainder : remainders) {
					if (remainder <= reaminderymax) {
						Long y = quotientymax*20001l+remainder;
						Long sumL = x+y;
						int sum = sumL.intValue();
						answers[sum+10000]=true;
					}
				}
			}
			line = input.readLine();
		}
		input.close();
		int count =0;
		for (int i=0;i<answers.length;i++) {
			if (answers[i] == true) {
				count++;
				System.out.println("Sum in target : "+answers[i]);
			}
		}
		System.out.println("Count = "+count);
		System.out.println("End");
	}
	private static void setDividedMap() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new FileReader(file));
;		try {
			// Read a line of text from the file
			String line = input.readLine();
			while (line != null) {
				// Split the line of text into a vector of Strings
				Long dividend = Long.parseLong(line);
				Long reaminder = Long.remainderUnsigned(dividend, 20001l);
				Long quotient = Long.divideUnsigned(dividend, 20001l);
				ArrayList<Long> remainders = new ArrayList<>();
				if (dividedMap.containsKey(quotient)) {
					remainders = dividedMap.get(quotient);
				}
				remainders.add(reaminder);
				dividedMap.put(quotient, remainders);
				line = input.readLine();
			} // while
		} // try
		finally {
			input.close();
		} // finally
	}
}
