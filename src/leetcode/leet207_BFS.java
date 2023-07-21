package leetcode;

public class leet207_BFS {

}
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0 || prerequisites[0].length == 0){
            return true;
        }

        List[] nextCourses = new List[numCourses];
        int[] degree = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            nextCourses[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<prerequisites.length; i++){
            int preC = prerequisites[i][1];
            int nextC = prerequisites[i][0];
            degree[nextC]++;
            nextCourses[preC].add(nextC); 
        }
        Queue<Integer> queue = new LinkedList(); 

        for(int i=0; i<numCourses; i++){
            if (degree[i] == 0){
                queue.offer(i);
            }
        }

        int count=0;
        while(!queue.isEmpty()){
            int preC = queue.poll();
            count++;
            List<Integer> nextCs = nextCourses[preC];
            for(int point: nextCs){
                degree[point]--;
                if (degree[point] == 0){
                    queue.offer(point);
                }
            }
        }

        return count == numCourses;
    }
}