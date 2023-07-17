package leetcode;

public class leet215_PriorityQ {

}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> p1-p2);

        for(int x: nums){
            if(pq.size() < k){
                pq.offer(x);
            }else{
                if (pq.peek() < x){
                    pq.poll();
                    pq.offer(x);
                }
            }
        }

        return pq.poll();

    }
}