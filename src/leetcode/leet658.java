package leetcode;

public class leet658 {

}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result; 

        int start = findLowest(arr, x);
        int end = start + 1;
        System.out.println("start:"+start);
        Integer[] temp = new Integer[k];

        for(int i=0; i<k; i++){
            if (isStartClosest(arr, start, end, x)){
                temp[i] = arr[start];
                System.out.println("start:"+start);
                start--;
            }else{
                temp[i] = arr[end];
                System.out.println("end:"+end);
                end++;
            }            
        }   
        Arrays.sort(temp);
        result = Arrays.asList(temp);
        return result;
    }

    public boolean isStartClosest(int[] arr, int start, int end, int x){    
        int n = arr.length;
        if (start < 0) {
            return false;
        }else if (end > n-1) {
            return true;
        }

        return Math.abs(arr[start] - x) <= Math.abs(arr[end] - x) ? true : false;
    }

    public int findLowest(int[] arr, int x){

        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while (start+1 < end){
            int mid = start + (end - start)/2;
            if (arr[mid] < x){  
                start = mid;
            }else{
                end = mid;
            }
        }

        return Math.abs(arr[start] - x) <= Math.abs(arr[end] - x) ? start : end;
    }
}