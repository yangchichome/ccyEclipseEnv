package lintcode;

public class Lint547 {

}
public class Solution {
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     *          we will sort your return value in output
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] tmp = new int[nums1.length];
        int index = 0;
        int i=0,j=0;
        
        while(i<nums1.length && j<nums2.length){
            if (nums1[i] == nums2[j]){
                if (index == 0 || tmp[index-1] != nums1[i]){
                    tmp[index++] = nums1[i];
                }
                i++;
                j++;
            }
            else if (nums1[i] > nums2[j]){
                j++;
            }else{
                i++;
            }
        }

        int[] result = new int[index];
        for (int k=0;k < index;k++){
            result[k] = tmp[k];
        }
        return result;
    }
}