package lintcode;

public class GraphValidTree178 {

    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (n == 0) return false;
        if (edges.length != n-1) return false;

        HashMap<Integer,Set<Integer>> graph = initGraph(edges);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Set<Integer> result = new HashSet<>();
        result.add(0);

        while(!queue.isEmpty()){
            int curNode = queue.poll();

            if (!graph.containsKey(curNode)) continue;

            for (int nei : graph.get(curNode)){
                if (!result.contains(nei)) {
                    queue.add(nei);
                    result.add(nei);
                }
            }
        }

        return (result.size() == n);

    }

    private HashMap<Integer,Set<Integer>> initGraph(int[][] edges){
        HashMap<Integer,Set<Integer>> graph = new HashMap<>();

        for (int[] edge :edges){

            int v1 = edge[0];
            int v2 = edge[1];

            if (!graph.containsKey(v1)){
                graph.put(v1,new HashSet<Integer>());
            }
            if (!graph.containsKey(v2)){
                graph.put(v2,new HashSet<Integer>());
            }
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        return graph;
    }
}