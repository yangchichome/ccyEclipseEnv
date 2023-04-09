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
class Point {
    int time;
    int flag;

    public Point(int time, int flag){
        this.time = time;
        this.flag = flag;
    }

    public static Comparator<Point> PointCompare = new Comparator<Point>(){
        public int compare(Point p1, Point p2){
            if (p1.time == p2.time) return p1.flag - p2.flag;
            else return p1.time - p2.time;
        }
    };
}

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        List<Point> points = new ArrayList<>(intervals.size()*2);
        for (Interval inter : intervals){
            points.add(new Point(inter.start, 1));
            points.add(new Point(inter.end, -1));
        }

        Collections.sort(points,Point.PointCompare);
        int count = 0;
        int ans = 0;

        for (Point point : points){
            count += point.flag;

            ans = Math.max(ans, count);
        }

        return ans;
    }
}