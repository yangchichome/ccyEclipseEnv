package leetcode;

public class leet210 {

}
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int s = prerequisites.length;
        List[] posts = new ArrayList[n];
        int[] level = new int[n];

        for (int i=0; i<n; i++){
            posts[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<s; i++){
            int post = prerequisites[i][0];
            int pre = prerequisites[i][1];
            level[post]++;
            posts[pre].add(post);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            if (level[i] == 0){
                queue.add(i);
                System.out.println("queue:"+i);
            }
        }
        
        int[] result = new int[n];
        int count = 0;
        while(!queue.isEmpty()){
            int first = queue.poll();
            int size = posts[first].size();
            System.out.println("count:"+count);
            result[count++] = first;
            for (int i=0; i<size; i++){ 
                int post = (int) posts[first].get(i);
                level[post]--;
                if (level[post] == 0){
                    queue.offer(post);
                }
            } 
        }

        return count == n ? result : new int[0];

    }
}