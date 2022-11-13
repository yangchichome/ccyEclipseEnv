package leedcode;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[len] = true;
        for (int i=len-1;i>=0;i--){
        	System.out.println("s index:"+i);
            for (String w:wordDict){
            	System.out.println("Sub String:"+w);
                int wlen = w.length();
                if((i+wlen) <= len) {
                	String subS = s.substring(i, i+wlen);
                	if(w.equals(subS)) {
                    	System.out.println("Match:");
                    	dp[i] = dp[i+wlen];
                	}
                }
                if (dp[i])  break;
            }
        }
        return dp[0];            
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> wordList = new ArrayList<String>();
		wordList.add("leet");
		wordList.add("code");
		System.out.println(wordBreak("leetcode",wordList));
	}
}
