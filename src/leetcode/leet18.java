package leetcode;

public class leet18 {

}
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        // System.out.print("nums:{");
        // for(int x:nums){
        //     System.out.print(x+",");
        // }
        // System.out.println("}");

        for(int i=0; i<nums.length; i++){
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j=i+1; j<nums.length; j++){
                if (j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }                
                long tarNew = (long)target - (long)nums[i] - (long)nums[j];
                int s = j+1;
                int e = nums.length-1;
                while(s<e){
                    // System.out.println("tarNew:"+tarNew);
                    // System.out.println("    i:"+i+" ,j:"+j+" ,s:"+s+" ,e:"+e);
                    // System.out.println("    i:"+nums[i]+" ,j:"+nums[j]+" ,s:"+nums[s]+" ,e:"+nums[e]);
                    long sum = (long)nums[s] + (long)nums[e];
                    // System.out.println("sum:"+sum);
                    if(tarNew > sum){
                        s++;
                    }else if (tarNew < sum){
                        e--;
                    }else{
                        // System.out.println("ok");
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[s]);
                        temp.add(nums[e]);
                        result.add(temp);
                        s++;
                        e--;
                        while(s<e && nums[e] == nums[e+1]){
                            e--;
                        }
                        while(s<e && nums[s] == nums[s-1]){
                            s++;
                        }
                    }
                }
            }
        }
        return result;
    }
}