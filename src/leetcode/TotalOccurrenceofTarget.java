package leetcode;

public class TotalOccurrenceofTarget {

    /**
     * @param a: A an integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int totalOccurrence(int[] a, int target) {
        // write your code here
        if (a==null || a.length==0){
            return 0;
        }

        int start = getFirstTarget(a,target);
        if (start == -1){
            return 0;
        }
        int end = getFinalTarget(a,target);

        return end - start + 1;
    }

    public int getFirstTarget(int[] a, int target){
        int start = 0 ;
        int end = a.length - 1;
        
        while(start+1 < end){
            int mid = start + (end - start)/2;
            if (a[mid] > target){
                end = mid;
            }else if (a[mid]==target){
                end = mid;
            }else{
                start = mid;
            }
        }
        if (a[start]==target){
            return start;
        }else if (a[end]==target){
            return end;
        }
        return -1;
    }
    public int getFinalTarget(int[] a, int target){
        int start = 0 ;
        int end = a.length - 1;
        
        while(start+1 < end){
            int mid = start + (end - start)/2;
            if (a[mid] > target){
                end = mid;
            }else if (a[mid]==target){
                start = mid;
            }else{
                start = mid;
            }
        }
        if (a[end]==target){
            return end;
        }else if (a[start]==target){
            return start;
        }
        return -1;
    }    
}