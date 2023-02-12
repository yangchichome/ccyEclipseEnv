package leetcode;

public class ClosestNumberinSortedArray {

    /**
     * @param a: an integer array sorted in ascending order
     * @param target: An integer
     * @return: an integer
     */
    public int closestNumber(int[] a, int target) {
        // write your code here
        if (a==null || a.length==0){
            return -1;
        }
        int start =0;
        int end = a.length-1;
        while (start+1 < end){
            int mid = start + (end - start)/2;
            if (a[mid] > target) {
                end = mid;
            }else{
                start = mid;
            }
        }

        return target - a[start] < a[end] - target ? start : end;
    }
}