package lintcode;

public class Lint657 {
	
}
public class RandomizedSet {
    ArrayList<Integer> nums;
    HashMap<Integer,Integer> numsIndex;
    Random rand; 

    public RandomizedSet() {
        // do intialization if necessary
        nums = new ArrayList<>();
        numsIndex = new HashMap<>();
        rand = new Random();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        // write your code here
        if (numsIndex.containsKey(val)){
            return false;
        }
        numsIndex.put(val,nums.size());
        nums.add(val);
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        // write your code here
        if (!numsIndex.containsKey(val)) return false;

        int index = numsIndex.get(val);
        if (index != nums.size()-1){
            int lastVal = nums.get(nums.size()-1);
            nums.set(index,lastVal);
            numsIndex.put(lastVal,index);
        }
        nums.remove(nums.size()-1);
        numsIndex.remove(val);
        return true;
    }
    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        // write your code here
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */