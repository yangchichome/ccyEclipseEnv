package lintcode;

public class lint178_BFS {

}
public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (n-1 != edges.length){
            return false;
        }

        Map<Integer,Set<Integer>> graph = buildGraph(n, edges);

        //BFS
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(0);
        set.add(0);

        while(!queue.isEmpty()){
            int node = queue.poll();
            for (Integer e: graph.get(node)){
                if (set.contains(e)){
                    continue;
                }
                
                set.add(e);
                queue.offer(e);
            }
        }

        return (set.size() == n);
    }

    public Map<Integer, Set<Integer>> buildGraph(int n, int[][] edges){
        Map<Integer, Set<Integer>> map = new HashMap();
        for (int i=0; i<n; i++){
            if (!map.containsKey(i)){
                map.put(i, new HashSet<>());
            }
        }

        for(int i=0; i<n-1; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            map.get(u).add(v);
            map.get(v).add(u);
        }

        return map;
    }
}