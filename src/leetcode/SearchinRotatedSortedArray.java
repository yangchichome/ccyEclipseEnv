package leetcode;

public class SearchinRotatedSortedArray {

    /**
     * @param a: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] a, int target) {
        // write your code here
        if (a == null || a.length == 0){
            return -1;
        }

        int start=0;
        int end = a.length-1;
        while(start+1 < end){
            int mid = start + (end - start)/2;
            if (a[mid] == target){
                return mid;
            }
            if (a[start]>a[mid]){
                if (a[mid] <= target && target <= a[end]){
                    start = mid;
                }else{
                    end = mid;
                }
            }else{
                if (a[start]<=target && target <= a[mid]){
                    end = mid;
                }else{
                    start = mid;
                }
            }
        }

        if (a[start]==target) return start;
        if (a[end]== target) return end;
        return -1;
    }
}