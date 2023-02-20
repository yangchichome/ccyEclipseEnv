package lintcode;

public class CloneGraph137 {

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>();
 *     }
 * }
 */

    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) return node;

        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();

        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

        queue.offer(node);
        map.put(node, new UndirectedGraphNode(node.label));

        while(!queue.isEmpty()){
            UndirectedGraphNode nodeCur = queue.poll();
            for (UndirectedGraphNode nei : nodeCur.neighbors){
                if (!map.containsKey(nei)){
                    map.put(nei,new UndirectedGraphNode(nei.label));
                    queue.offer(nei);
                }
                map.get(nodeCur).neighbors.add(map.get(nei));
            }
        }

        return map.get(node);
    }
}