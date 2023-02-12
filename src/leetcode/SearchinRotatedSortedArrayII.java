package leetcode;

public class SearchinRotatedSortedArrayII {

    /**
     * @param a: an integer ratated sorted array and duplicates are allowed
     * @param target: An integer
     * @return: a boolean 
     */
    public boolean search(int[] a, int target) {
        // write your code here
        for (int i =0;i<a.length;i++){
            if (a[i] == target){
                return true;
            }
        }
        return false;
    }
}