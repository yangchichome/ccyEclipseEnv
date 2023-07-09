package leetcode;

public class leet378_pq {

}
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((p1, p2) -> (p2 - p1));
        int n = matrix.length;
        int m = matrix[0].length;
        
        for (int i=0; i<n; i++){
            if (pq.size() == k && pq.peek() <= matrix[i][0]){
                break;
            }
            for(int j=0; j<m; j++){
                // System.out.println("val:"+matrix[i][j]);
                if (pq.size() < k){
                    pq.offer(matrix[i][j]);
                }else if (pq.peek() > matrix[i][j]){
                    pq.poll();
                    pq.offer(matrix[i][j]);
                }
            }
        }    

        return pq.peek();
    }
}