package leetcode;

public class leet703 {

}
class KthLargest {
    private PriorityQueue<Integer> pq;
    private int size;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((p1, p2) -> p1-p2);
        size = k;
        for(int x: nums){
            add(x);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>size){
            pq.poll();
        }
        
        int ans = pq.poll();
        pq.offer(ans);
        return ans;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */