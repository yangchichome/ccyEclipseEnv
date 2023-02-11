package leetcode;

public class FindKClosestElements {

    /**
     * @param a: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] a, int target, int k) {
        // write your code here

        int index = findFisrtcloest(a,target);

        int[] ans = new int[k];

        int left = index;
        int right = index+1;
        for (int i=0;i<k;i++){
            if (isLeftCloser(a,target,left,right)){
                ans[i] = a[left];
                left--;
            }else{
                ans[i] = a[right];
                right++;
            }
        }
        return ans;

    }
    public boolean isLeftCloser(int[] a,int target,int left,int right){
        if (left < 0) {
            return false;
        }else if (right >= a.length){
            return true;
        }else if (target - a[left] == a[right] - target){
            return true;
        }else{
            return target - a[left] < a[right] - target;
        }
    }

    public int findFisrtcloest(int[] a,int target){
        int start = 0;
        int end = a.length-1;
        while (start+1 < end){
            int mid = start + (end-start)/2;
            if (a[mid] > target ){
                end = mid;
            }else if (a[mid] == target) {
                end = mid;
            }else{
                start = mid;
            }
        }
        if (target - a[start] == a[end] - target) {
            return start;
        }

        return target - a[start] < a[end] - target ? start : end; 
    }
}