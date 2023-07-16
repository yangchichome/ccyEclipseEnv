package leetcode;

public class leet852 {

}
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = n-1;

        while(l+1 < r){
            int mid = l + (r-l)/2;
            if (arr[mid] < arr[mid+1]){
                l = mid;
            }else if (arr[mid] < arr[mid-1]){
                r = mid;
            }else{
                return mid;
            }
        }
        if (arr[l] > arr[r]){
            return l;
        }
        return r;
        
    }
}