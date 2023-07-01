package leetcode;

public class leet387 {

}
class Solution {
    public int firstUniqChar(String s) {
        if (s.length() == 0) return 0;

        int n = s.length();
        int[] chars = new int[256];

        for(int i=0; i<n; i++){
            chars[s.charAt(i)]++;
        }
        for(int i=0; i<n; i++){
            if (chars[s.charAt(i)] == 1){
                return i;
            }
        }

        return -1;
    }
}