package leetcode;

public class Leet775 {

}
class KthLargest {

    public Queue<Integer> priorityQ = new PriorityQueue<>();
    private int size ;
    public KthLargest(int k, int[] nums) {
        size = k;
        for (int n : nums){
            add(n);
        }

    }
    
    public int add(int val) {

        if (priorityQ.size() < size){
            priorityQ.add(val);
        }else if (priorityQ.peek() < val){
            priorityQ.poll();
            priorityQ.add(val);
        }

        return priorityQ.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */