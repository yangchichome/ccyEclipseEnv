package lintcode;

public class Lint685 {

}
class DataStream{
    private ListNode head,tail;
    private Map<Integer,ListNode> preNode;
    private Set<Integer> duplicates;

    public DataStream(){
        head = new ListNode(0);
        tail = head;

        preNode = new HashMap<>();
        duplicates = new HashSet<>();
    }

    public void remove(int number){
        ListNode prev = preNode.get(number);
        prev.next = prev.next.next;
        preNode.remove(number);

        if (prev.next != null){
            preNode.put(prev.next.val,prev);
        }else{
            tail = prev;
        }
    }

    public void add(int number){
        if (duplicates.contains(number)){
            return;
        }
        if (preNode.containsKey(number)){
            remove(number);
            duplicates.add(number);
        }else{
            ListNode node = new ListNode(number);
            preNode.put(number,tail);
            tail.next = node;
            tail = node;
        }
    }

    public int getFirstUnique(){
        if (head.next != null) return head.next.val;
        return -1;
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
        DataStream ds = new DataStream();
        for(int i=0;i<nums.length;i++){
            ds.add(nums[i]);
            if (nums[i] == number) return ds.getFirstUnique();
        }
        return -1;
    }
}