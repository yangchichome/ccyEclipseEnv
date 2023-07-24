package leetcode;

public class leet973_PQ_Class {

}
class coordinate{
    int x;
    int y;
    public coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}


class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (points.length <= k){
            return points;
        }

        Comparator<coordinate> coorCompare = new Comparator<>(){
            public int compare(coordinate c1, coordinate c2){
                return (c2.x*c2.x + c2.y*c2.y) - (c1.x*c1.x + c1.y*c1.y);
            }
        };
        
        PriorityQueue<coordinate> pq = new PriorityQueue<>(coorCompare);

        for (int[] coor: points){
            pq.offer(new coordinate(coor[0], coor[1]));

            if (pq.size() > k){
                pq.poll();
            }
        }

        int[][] result = new int[k][2];
        for(int i=k-1; i>=0; i--){
            coordinate c = pq.poll();
            result[i][0] = c.x;
            result[i][1] = c.y;
        }

        return result;
    }
}