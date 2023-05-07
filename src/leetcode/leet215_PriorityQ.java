package leetcode;

public class leet215_PriorityQ {

}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int x: nums){
            if (queue.size() < k){
                queue.offer(x);
            }else{
                int tmp = queue.peek();
                if (tmp < x){
                    queue.poll();
                    queue.offer(x);
                }
            }
        }

        return queue.peek();
    }
}