package leetcode;

public class leet207_BFS {

}
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int len = prerequisites.length;
        List[] posts = new ArrayList[n];
        int[] level = new int[n];

        for (int i=0; i<n; i++){
            posts[i] = new ArrayList<Integer>();
        }
        for (int i=0; i<len; i++){
            int pre = prerequisites[i][1];
            int post = prerequisites[i][0];
            level[post]++;
            posts[pre].add(post); 
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<n; i++){
            if(level[i] == 0){
                queue.offer(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty()){
            int pre = queue.poll();
            int size = posts[pre].size();
            count++;
            for (int i=0; i<size; i++){
                int post = (int) posts[pre].get(i);
                level[post]--;
                if (level[post] == 0){
                    queue.offer(post);
                }
            }
        }

        return count == n;
    }
}