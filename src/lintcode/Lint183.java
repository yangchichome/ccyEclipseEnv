package lintcode;

public class Lint183 {

}
public class Solution {
    /**
     * @param l: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] l, int k) {
        // write your code here
        int start = 1;
        int end = 0;
        for (int s : l){
            end = Math.max(end,s);
        }

        int result = 0;
        while(start <= end ){
            int mid = end + (start-end)/2;

            if (count(l,mid) >= k) {
                result = mid;
                start = mid+1;
            }else {
                end = mid-1;
            }
        }

        return result;
    }

    public int count(int[] lens, int len){
        int count = 0;
        for (int wlen : lens){
            count += wlen/len;
        }

        return count;
    }
}