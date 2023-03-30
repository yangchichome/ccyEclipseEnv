package lintcode;

public class Lint117_greedy {

}
public class Solution {
    /**
     * @param a: A list of integers
     * @return: An integer
     */
    public int jump(int[] a) {
        // write your code here
        if (a.length == 0 || a == null) {
            return 0;
        }

        int n = a.length;
        int left = 0, right = 0;
        int count = 0;

        while(right < n-1){
            int farthest = 0;
            for (int i=left; i<right+1; i++){
                farthest = Math.max(farthest, i + a[i]);
            }
            left = right + 1;
            right = farthest;
            count++;
        }

        return count;
    }
}