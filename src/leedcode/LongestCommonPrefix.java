package leedcode;

import java.util.Arrays;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "flower","flow","flight"};
		System.out.println(Arrays.toString(strs));
		Arrays.sort(strs);
		System.out.println(Arrays.toString(strs));
	}
}
