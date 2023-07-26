package lintcode;

public class lint685 {

}
class firstUnique{
    Set<Integer> unique = new LinkedHashSet<>();
    Set<Integer> all = new HashSet<>();

    public firstUnique(){
        // for(int x: nums){
        //     add(x);
        // }
    }

    public int showFirstUnique(){
        if (unique.isEmpty()){
            return -1;
        }
        return unique.iterator().next();
    }

    public void add(int value){
        if (all.add(value)){
            unique.add(value);
        } else{
            unique.remove(value);
        }
    }
}

public class Solution {
    /**
     * @param nums: a continuous stream of numbers
     * @param number: a number
     * @return: returns the first unique number
     */
    public int firstUniqueNumber(int[] nums, int number) {
        // Write your code here
        firstUnique fU = new firstUnique();

        for(int i=0; i<nums.length; i++){
            fU.add(nums[i]);
            if (nums[i] == number){
                return fU.showFirstUnique();
            }
        }

        return -1;
    }
}