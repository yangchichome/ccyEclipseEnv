package leetcode;

public class leet973_PQ_NoClass {

}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>
            ((p1,p2) -> ((p2[0]*p2[0]+p2[1]*p2[1]) - (p1[0]*p1[0]+p1[1]*p1[1])));

        for (int[] p : points){

            pq.offer(p);

            if (pq.size() > k){

                pq.poll();
            }
        }
        
        int[][] result = new int[k][2];

        for (int i=k-1; i>=0; i--){
            result[i] = pq.poll();
        }

        return result;
    }
}