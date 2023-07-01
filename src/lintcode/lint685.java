package lintcode;

public class lint685 {

}
class DataStream {
    private ListNode head, tail;
    private Map<Integer, ListNode> preNode;
    private Set<Integer> duplicates;

    public DataStream (){
        head = new ListNode(0);
        tail = head;
        preNode = new HashMap<>();
        duplicates = new HashSet<>();
    }

    public void add(int x){
        if (duplicates.contains(x)){
            return;
        }

        if (preNode.containsKey(x)){
            remove(x);
            duplicates.add(x);
        }else{
            ListNode nodeNew = new ListNode(x);
            preNode.put(x, tail);
            tail.next = nodeNew;
            tail = nodeNew;
        }
    }

    public void remove (int x){
        ListNode pre = preNode.get(x);

        pre.next = pre.next.next;
        preNode.remove(x);

        if (pre.next != null){
            preNode.put(pre.next.val, pre);
        }else{
            tail = pre;
        }

    }

    public int firstUnique(){
        if (head.next != null){
            return head.next.val;
        }
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

        for (int i=0; i<nums.length; i++){
            ds.add(nums[i]);
            if (nums[i] == number){
                return ds.firstUnique();
            }
        }

        return -1;
    }

}