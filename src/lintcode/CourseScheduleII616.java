package lintcode;

public class CourseScheduleII616 {

    /**
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        List[] edges = new ArrayList[numCourses];
        int[] degrees = new int[numCourses];

        for (int i=0;i<numCourses;i++){
            edges[i] = new ArrayList<Integer>();
        }

        for (int i=0;i<prerequisites.length;i++){
            int preC = prerequisites[i][1];
            int nextC = prerequisites[i][0];
            degrees[nextC]++;
            edges[preC].add(nextC);
        }

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i=0;i<degrees.length;i++){
            if (degrees[i] == 0){
                System.out.println("0:"+i);
                queue.add(i);
            }
        }
        
        int[] result = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()){
            int curC = queue.poll();
            // System.out.println("Course:"+curC);
            result[count] = curC;
            count++;
            int n = edges[curC].size();
            
            for (int i=0;i<n;i++){
                int nextC = (int)edges[curC].get(i);
                degrees[nextC]--;
                if (degrees[nextC]==0){
                    queue.add(nextC);
                }
            }
        }

        return result;
    }
}