package leedcode;

import java.util.Arrays;

public class LongestPalindrome {
	public static int longestPalindrome(String s) {
        boolean[] barry = new boolean[128];
        int len = 0;
        for (char c : s.toCharArray()) {
        	
            barry[c] = !barry[c];         // flip on each occurrence, false when seen n*2 times
            System.out.println("The string representation of array is:");
            System.out.println(c);  
            System.out.println(Arrays.toString(barry));  
            if (!barry[c]) len+=2;
        }
        if (len < s.length()) len++; // if more than len, atleast one single is present
        return len;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
//		int nan = longestPalindrome("aabbabc");
	}
}
