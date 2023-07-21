package leetcode;

public class leet210 {

}
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List[] nexts = new List[numCourses];
        int[] order = new int[numCourses];
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            nexts[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<prerequisites.length; i++){
            int preCourse = prerequisites[i][1];
            int nextCourse = prerequisites[i][0];
            // System.out.println("pre:"+preCourse+", next:"+nextCourse);
            order[nextCourse]++;
            nexts[preCourse].add(nextCourse);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if (order[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int preCourse = queue.poll();
            result.add(preCourse);
            List<Integer> nextCourses = nexts[preCourse];
            for(int c: nextCourses){
                order[c]--;
                if(order[c] == 0){
                    queue.offer(c);
                }
            }
        }

        // if (result.size() == 0){
        //     return new int[0];
        // }
        // System.out.println("result Size:"+result.size());
        int[] ans = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            ans[i] =  result.get(i);
        }

        return result.size() == numCourses? ans:new int[0];

    }
}