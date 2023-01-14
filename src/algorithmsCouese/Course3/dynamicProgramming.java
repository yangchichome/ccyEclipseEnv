package algorithmsCouese.Course3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class dynamicProgramming {
	
	private static File file = new File("src/algorithmsCouese/Course3/mwis.txt");
//	private static File file = new File("src/algorithmsCouese/Course3/input_random_40_4000.txt");
//	private static File file = new File("src/algorithmsCouese/Course3/case2.txt");
	private static int[] A = new int[4001];
	private static int[] weight = new int[4001];
	private static int arraySize = 1;
	private static HashSet<Integer> mwIS = new HashSet<Integer>();
	private static int[] ansList = new int[]{1,2,3,4,17,117,517,997};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		setWeightArray();
		int i = arraySize;
		while (i>=1){
			if (i==1) {
				if (A[0] >= weight[0]) {
					mwIS.add(i);
					i--;
				}
			}
			else {
				if (A[i-1] >= (A[i-2]+weight[i])) {
					i--;
				}
				else {
					mwIS.add(i);
					i-=2;
				}
			}

		}
		System.out.print("Answers : ");
		for (int j=0;j<ansList.length;j++) {
			if (mwIS.contains(ansList[j])) {
				System.out.print(1);
			}else {
				System.out.print(0);
			}
		}
		System.out.println("	End");
	}
	private static void setWeightArray() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new FileReader(file));
		try {
			// Read a line of text from the file
			String line = input.readLine();
//			remove first line 
			line = input.readLine();
			A[0]=0;
			int i = 1;
			while (line != null) {
				// Split the line of text  a vector of Strings
				if (i == 1) {
					A[1]=Integer.parseInt(line);
				}else {
					A[i]=Math.max(A[i-1], A[i-2]+Integer.parseInt(line));
				}
				weight[i] = Integer.parseInt(line);
				// Read a new line of text
				line = input.readLine();
				i++;
			} // while
			arraySize = i-1;
		} // try
		finally {
			input.close();
		} // finally
	}
}
