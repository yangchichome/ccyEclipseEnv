package leetcode;

public class leet703 {

}
class KthLargest {
    private PriorityQueue<Integer> pq;
    private int size; 

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((q1, q2) -> q1 - q2);
        size = k;
        for (int val : nums){
            add(val);
        }
    }
    
    public int add(int val) {

        if (pq.size() >= size){
            if (pq.peek() < val){

                pq.poll();

                pq.offer(val);
            }
        }else{

            pq.offer(val);
        }
       
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */