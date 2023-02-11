package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Longest_Palindrome_S2 {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()){
            if (set.contains(c)) set.remove(c);
            else set.add(c);
        }
        int remains = set.size();
        if(remains > 0) remains--;

        return s.length()-remains;

    }
}