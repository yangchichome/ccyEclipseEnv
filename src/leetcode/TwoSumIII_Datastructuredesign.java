package leetcode;

public class TwoSumIII_Datastructuredesign {

    private HashMap<Integer,Integer> counter;

    public TwoSumIII_Datastructuredesign(){
        counter = new HashMap<Integer,Integer>();
    }
    /**
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        // write your code here
        counter.put(number,counter.getOrDefault(number,0)+1);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        for (Integer num1 : counter.keySet()){
            int num2 = value - num1;
            int neededCount = num1==num2 ? 2:1;
            if (counter.getOrDefault(num2, 0) >= neededCount){
                return true;
            }
        }
        return false;
    }
}