package leetcode;

public class leet973_PQ_Class {

}
class Coor {
    int x;
    int y;
    public Coor(int x, int y){
        this.x = x;
        this.y = y;
    }

}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Coor> pq = new PriorityQueue<>((p1, p2) -> ( p2.x*p2.x+p2.y*p2.y -p1.x*p1.x-p1.y*p1.y));

        for(int[] point: points){
            pq.offer(new Coor(point[0], point[1]));
            if (pq.size() > k){
                pq.poll();
            }
        }
        List<Coor> tmp = new ArrayList<>();
        while(!pq.isEmpty()){
            tmp.add(pq.poll());
        }
        int[][] result = new int[tmp.size()][2];
        for(int i=0; i<tmp.size(); i++){
            result[i][0] = tmp.get(i).x;
            result[i][1] = tmp.get(i).y;
        }

        return result;
    }
}