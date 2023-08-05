package lintcode;

public class Lint919 {

}
/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
class book {
    public int time;
    public int num;
    public book (int time, int num){
        this.time = time;
        this.num = num;
    }
}
public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        PriorityQueue<book> pq = new PriorityQueue<>((b1, b2) -> b1.time - b2.time);
        for(Interval s: intervals){
            pq.add(new book(s.start, 1));
            pq.add(new book(s.end, -1));
        }
        int count = 0;
        int max = 0;
        while(!pq.isEmpty()){
            book tmp = pq.poll();
            count += tmp.num;
            max = Math.max(max, count);
        }

        return max;
    }
}