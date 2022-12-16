package algorithmsCouese.quicksort;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QuickSort_simple {
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
	
	public static void quicksort(int[] A,int L,int R,int mode) {
		if (L < R) {
			int len = R-L+1;
			count = count+len-1;
//			System.out.println("count 0 :"+count);
//			System.out.println("L="+L+", R="+R+", p=?"+", before1 :"+Arrays.toString(A));
			if (mode==2) {
				int swap = A[R];
				A[R]=A[L];
				A[L]=swap;	
			}
			else if(mode==3){
				int mid0 = 0;
				int M = 0;

				if (len%2 ==0) {
					M = L+len/2-1;
					mid0 = A[M];
				}
				else {
					M = L+len/2;
					mid0 = A[M];
				}
				int[] myNum = {mid0,A[L],A[R]};
//				System.out.println("Length : "+len+" ,mid index= "+M);
//				System.out.println("myNum : "+Arrays.toString(myNum));
				Arrays.sort(myNum);
//				System.out.println("myNum sorted : "+Arrays.toString(myNum));
				int mid = myNum[1];
//				System.out.println("mid value= "+mid+"  from"+Arrays.toString(myNum));
				
				if (mid == A[R]) {
					int swap = A[L];
					A[L]=A[R];
					A[R]=swap;	
				}
				else if (mid == mid0) {
					int swap = A[L];
					A[L]=A[M];
					A[M]=swap;	
				}
			}
			int p = A[L];
			int i = L+1;
//			System.out.println("L="+L+", R="+R+", p="+p+", before2 :"+Arrays.toString(A));
			for (int j=L+1;j<=R;j++) {
				if (A[j] < p) {
					int swap = A[j];
					A[j]=A[i];
					A[i]=swap;
					i++;
				}
			}
//			System.out.println("L="+L+", R="+R+", p="+p+", after1 :"+Arrays.toString(A));
			int swap = A[L];
			A[L]=A[i-1];
			A[i-1]=swap;
//			System.out.println("L="+L+", R="+R+", p="+p+", after2 :"+Arrays.toString(A));
			quicksort(A,L,i-2,mode);
			quicksort(A,i,R,mode);
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub  
		System.out.print("sort2"+'\n');
		ArrayList<Integer> stngFile = new ArrayList<Integer>();
		Scanner scnr = new Scanner(new FileReader("src/algorithmsCouese/quicksort/quicksortData.txt"));
		Integer str;
		while (scnr.hasNext()) {
		            str = Integer.valueOf(scnr.next());
		            stngFile.add(str);
		        }
		count =0;
		int[] ints1 = stngFile.stream().mapToInt(i->i).toArray();
		quicksort(ints1,0,ints1.length-1,1);
		System.out.print("recursive call for Quicksort3 is :"+count+'\n');
		
		count =0;
		int[] ints2 = stngFile.stream().mapToInt(i->i).toArray();
		quicksort(ints2,0,ints2.length-1,2);
		System.out.print("recursive call for Quicksort3 is :"+count+'\n');
//		System.out.println("ints2 :"+Arrays.toString(ints2));
		
		count =0;
		int[] ints3 = stngFile.stream().mapToInt(i->i).toArray();
		quicksort(ints3,0,ints3.length-1,3);
		System.out.print("recursive call for Quicksort3 is :"+count+'\n');
//		System.out.println("ints3 :"+Arrays.toString(ints3));
	}
}
