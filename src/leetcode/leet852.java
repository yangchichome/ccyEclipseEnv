package leetcode;

public class leet852 {

}
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int start = 0;
        int end = arr.length-1;

        while (start+1 < end){
            int mid = start + (end - start)/2;
            if (arr[mid] < arr[mid-1]){
                end = mid;
            } else if (arr[mid] < arr[mid+1]){
                start = mid;
            } else{
                return mid;
            }
            System.out.println("start:"+start+" end:"+end);

        }
        System.out.println("start:"+start+" end:"+end);
        return arr[start] > arr[end] ? start : end;
    }
}