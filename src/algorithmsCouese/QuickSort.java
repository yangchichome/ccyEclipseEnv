package algorithmsCouese;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
	public static int count =0;
	
	public static int middleOfThree(int a, int b, int c)
	{
	    // Checking for b
	    if ((a < b && b < c) || (c < b && b < a))
	       return b;
	 
	    // Checking for a
	    else if ((b < a && a < c) || (c < a && a < b))
	       return a;
	 
	    else
	       return c;
	}
	
	public static int[] merge(int[] A,int p,int[] B) {
        int length = A.length + B.length+1;
        int[] result = new int[length];
        System.arraycopy(A, 0, result, 0, A.length);
        result[A.length] = p;
        System.arraycopy(B, 0, result, A.length+1, B.length);
		return result;
	}
	
	public static int[] merge(int p,int[] A) {
        int length = A.length + 1;
        int[] result = new int[length];
        result[0] = p;
        System.arraycopy(A, 0, result, 1, A.length);
		return result;
	}
	public static int[] merge(int[] A, int p) {
        int length = A.length + 1;
        int[] result = new int[length];
        System.arraycopy(A, 0, result, 0, A.length);
        result[A.length] = p;
		return result;
	}
	
	public static int[] quicksort(int[] A,int mode) {
		
		if (A.length >= 2)  {
			count = count+A.length-1;
//			System.out.println("count 0 :"+count);
			int L =0;
			int R =A.length-1;

//			System.out.println("Before Swap :"+Arrays.toString(A));
			if (mode == 2) {
				int swap0 = A[R];
				A[R]=A[0];
				A[0]=swap0;			
//				System.out.println("Before Swap 2 :"+Arrays.toString(A));
			}
			else if(mode ==3) {
				int mid0 = 0;
				int index = 0;
				if (A.length%2 ==0) {
					mid0 = A[A.length/2-1];
					index = A.length/2-1;
				}
				else {
					mid0 = A[A.length/2];
					index = A.length/2;
				}
				int mid = middleOfThree(mid0,A[L],A[R]);
				if (mid == A[R]) {
					int swap = A[R];
					A[R]=A[L];
					A[L]=swap;	
				}
				else if (mid == mid0) {
					int swap = A[R];
					A[R]=A[index];
					A[index]=swap;	
				}
//				System.out.println("Before Swap 3 :"+Arrays.toString(A));
			}
//			System.out.println("pivot :"+A[0]);
			int p = A[L];
			int i = L+1;
			for (int j=L+1;j<=R;j++) {
				if (A[j] < p) {
					int swap = A[j];
					A[j]=A[i];
					A[i]=swap;
					i++;
//					System.out.println("Swaping :"+Arrays.toString(A));
				}
			}
//			System.out.println("After Swap :"+Arrays.toString(A));
			if (i == 1 || i > R) {
				int[] ltmp = Arrays.copyOfRange(A, L+1, R+1);
//				System.out.println("1st :"+Arrays.toString(ltmp));
				int[] leftA = quicksort(ltmp,mode);
				if (i == 1) return merge(A[0],leftA);
				else return merge(leftA,A[0]);
				
			}
			else {
				int swap = A[L];
				A[L]=A[i-1];
				A[i-1]=swap;
				int[] ltmp = Arrays.copyOfRange(A, L, i-1);
				int[] rtmp = Arrays.copyOfRange(A, i,R+1);
//				System.out.println("1st :"+Arrays.toString(ltmp));
//				System.out.println("2st :"+Arrays.toString(rtmp));
				int[] leftA = quicksort(ltmp,mode);
				int[] rightA = quicksort(rtmp,mode);
				return merge(leftA,A[i-1],rightA);
			}
		}
		else if (A.length == 1)  {
			count = count+1;
		}
		return A;
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub 
		System.out.print("sort2"+'\n');
		ArrayList<Integer> stngFile = new ArrayList<Integer>();
		Scanner scnr = new Scanner(new FileReader("src/algorithmsCouese/quicksortData3.txt"));
		Integer str;
		///Leedcodepractice/src/algorithmsCouese/quicksortData2.txt
		while (scnr.hasNext()) {
		            str = Integer.valueOf(scnr.next());
		            stngFile.add(str);
		        }
		int[] ints1 = stngFile.stream().mapToInt(i->i).toArray();
		int[] sort1 = quicksort(ints1,1);
		System.out.print("recursive call for Quicksort1 is :"+count+'\n');
		System.out.println("sort 1 :"+Arrays.toString(sort1));
		count =0;
		
		int[] ints2 = stngFile.stream().mapToInt(i->i).toArray();
		int[] sort2 = quicksort(ints2,2);
		System.out.print("recursive call for Quicksort2 is :"+count+'\n');
		System.out.println("sort 2 :"+Arrays.toString(sort2));
		
		count =0;
		int[] ints3 = stngFile.stream().mapToInt(i->i).toArray();
		int[] sort3 = quicksort(ints3,3);
		System.out.print("recursive call for Quicksort3 is :"+count+'\n');
		System.out.println("sort 3 :"+Arrays.toString(sort3));
	}
}
