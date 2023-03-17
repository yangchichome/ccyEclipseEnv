package lintcode;

public class Lint124 {

}
public class Solution {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        // write your code here
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<num.length;i++){
            set.add(num[i]);
        }

        int maxLength =0;
        for (int i =0;i<num.length;i++){
            int down = num[i] - 1;
            while(set.contains(down)){
                set.remove(down);
                down--;
            }

            int up = num[i] + 1;
            while(set.contains(up)){
                set.remove(up);
                up++;
            }

            maxLength = Math.max(maxLength,up - down -1);
        }

        return maxLength;

    }
}