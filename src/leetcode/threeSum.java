package leetcode;

public class threeSum {

    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     *          we will sort your return value in output
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();

        if (numbers == null || numbers.length < 3){
            return results;
        }

        Arrays.sort(numbers);

        for (int i=0 ;i < numbers.length-2; i++){
            if (i > 0 && numbers[i] == numbers[i-1])
                continue;
            int target = -numbers[i];
            int left = i+1,right = numbers.length-1;

            twoSum(numbers,left,right,target,results);
        }

        return results;

    }
    public void twoSum(int[] nums,
                       int left,
                       int right, 
                       int target,
                       List<List<Integer>> results){
            while (left < right){
                if (nums[left]+nums[right] == target){
                    List<Integer> answer = new ArrayList<>();
                    answer.add(-target);
                    answer.add(nums[left]);
                    answer.add(nums[right]);
                    results.add(answer);

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right+1]){
                        right--;
                    }
                }else if (nums[left]+nums[right] < target){
                    left++;                    
                }else{
                    right--;
                }
            }
    }
}