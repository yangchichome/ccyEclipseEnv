package lintcode;

public class threeSumClosest59 {

    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        if (numbers==null || numbers.length==0){
            return 0;
        }
        Arrays.sort(numbers);
        int ans = numbers[0]+numbers[1]+numbers[2];
        for (int i=0;i<numbers.length;i++){
            int left = i+1;
            int right = numbers.length-1;
            while (left < right) {
                int sum = numbers[i]+numbers[left]+numbers[right];
                if (Math.abs(target - sum) < Math.abs(target - ans)){
                    ans = sum;
                }
                if (sum < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return ans;
    }
}