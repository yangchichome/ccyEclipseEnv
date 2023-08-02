package leetcode;

public class leet88 {

}
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        while(n > 0 || m > 0){
            if (n == 0) break;
            int n1 = m>0? nums1[m-1]:Integer.MIN_VALUE;
            int n2 = n>0? nums2[n-1]:Integer.MIN_VALUE;

            if (n1 >= n2){
                nums1[n+m-1] = n1;
                m--;
            }else {
                nums1[n+m-1] = n2;
                n--;
            }
        }
    }
}