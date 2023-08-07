package lintcode;

public class lint607 {

}
public class TwoSum {
    /**
     * @param number: An integer
     * @return: nothing
     */
    private Map<Integer,Integer> map = new HashMap<>();
    public void add(int number) {
        // write your code here
        if (!map.containsKey(number)){
            map.put(number, 1);
        }else{
            map.put(number, map.get(number)+1);
        }
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int other = value - entry.getKey();
            if (other == entry.getKey()) {
                if (entry.getValue() > 1){
                    return true;
                }
            }else if (map.containsKey(other)){
                return true;
            }
        }

        return false;
    }
}