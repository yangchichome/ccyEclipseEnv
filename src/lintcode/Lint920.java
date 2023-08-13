package lintcode;

public class Lint920 {

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

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        Comparator<Interval> IntervalCompare = new Comparator<>(){
            public int compare (Interval l1, Interval l2){
                return l1.start - l2.start;
            }
        };

        Collections.sort(intervals, IntervalCompare);
        int start = 0;
        int end = 0;
        for (Interval interval: intervals){
            start = interval.start;
            if(end > start){
                return false;
            }
            end = Math.max(end, interval.end);
        }

        return true;
    }
}