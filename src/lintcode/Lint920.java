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
        if (intervals == null || intervals.size() == 0) return true;

        intervals.sort(new Comparator<Interval>(){
            public int compare(Interval l1, Interval l2){
                return l1.start -l2.start;
            }
        });
        int end = intervals.get(0).end;
        for (int i=1; i<intervals.size(); i++){
             if (intervals.get(i).start < end){
                 return false;
             }
             end = Math.max(end,intervals.get(i).end);
        }

        return true;
    }
}