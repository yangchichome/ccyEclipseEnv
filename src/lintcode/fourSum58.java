package lintcode;

public class fourSum58 {

    /**
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     *          we will sort your return value in output
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here

        Arrays.sort(numbers);

        for (int x: numbers){
             System.out.print(x+",");
        }
        System.out.println("");
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for (int i=0 ; i < numbers.length ; i++){

            if (i !=0 && numbers[i] == numbers[i-1]) {
                continue;
            }

            for (int j=i+1; j < numbers.length ;j++) {

                if (j != i+1 && numbers[j] == numbers[j-1]) {
                    continue;
                }

                int left = j+1;
                int right = numbers.length-1;
                while(left < right){
                    int sum = numbers[i]+numbers[j]+numbers[left]+numbers[right];
 
                    if (sum > target){
                        right--;
                    }else if (sum < target){
                        left++;
                    }else {
                        List<Integer> tempAns = new ArrayList<>();
                        System.out.println("get");
                        tempAns.add(numbers[i]);
                        tempAns.add(numbers[j]);    
                        tempAns.add(numbers[left]);
                        tempAns.add(numbers[right]);    
                        ans.add(tempAns);

                        left++;
                        right--;

                        while (left < right && numbers[left] == numbers[left-1]){
                            left++;
                        }
                        while (left < right && numbers[right] == numbers[right+1]){
                            right--;
                        }                        

                    }
                }
            }
        }

        return ans;

    }
}