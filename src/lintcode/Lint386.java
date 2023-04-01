package lintcode;

public class Lint386 {

}
public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        HashMap<Character,Integer> map = new HashMap<>();

        int size = 0;
        int start = 0;

        for (int end=0; end<s.length(); end++){
            map.put(s.charAt(end),end);

            if (map.size() > k){
                int indexS = end;
                for (int index: map.values()){
                    indexS = Math.min(indexS,index);
                }

                start = indexS + 1;
                map.remove(s.charAt(indexS));
            }

            size = Math.max(size, end - start + 1);
        }

        return size;
    }
}