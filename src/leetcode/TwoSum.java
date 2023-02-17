package leetcode;

public class TwoSum {

    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        if (numbers == null ||numbers.length == 0){
            return new int[]{};
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i=0; i < numbers.length ; i++){
            if (map.get(target-numbers[i]) != null){
                int index1 = map.get(target-numbers[i]);
                int index2 = i;
                return new int[]{index1,index2};
            }
            map.put(numbers[i], i);
        }
        
        return new int[]{};
    }
}