package lintcode;

public class lint607 {

}
public class TwoSum {
    /**
     * @param number: An integer
     * @return: nothing
     */
    public Map<Integer,Integer> map = new HashMap<>();
    public void add(int number) {
        // write your code here
        if (map.containsKey(number)){
            map.put(number, map.get(number)+1);
        }else{
            map.put(number, 1);
        }
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        for(int x: map.keySet()){
            map.put(x, map.get(x)-1);
            if(map.containsKey(value - x) && map.get(value-x) >= 1){
                return true;
            }
            map.put(x, map.get(x)+1);
        }

        return false;
    }
}