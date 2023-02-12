package leetcode;

public class FindPeakElement {

    /**
     * @param a: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] a) {
        // write your code here
        int start=1;
        int end = a.length-2;
        while(start+1 < end){
            int mid = start + (end-start)/2;
            if (a[mid]<a[mid+1]){
                start = mid;
            }else if(a[mid]<a[mid-1]){
                end = mid;
            }else{
                return mid;
            }
        }

        return a[start] > a[end] ? start : end;
    }
}