package lintcode;

public class TopologicalSorting127 {

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     List<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * }
 */

    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        HashMap<DirectedGraphNode,Integer> degrees = new HashMap<>();

        Queue<DirectedGraphNode> queue = new LinkedList<>();
        ArrayList<DirectedGraphNode> result = new ArrayList<>();

        for (DirectedGraphNode node : graph){
            for (DirectedGraphNode nei : node.neighbors){
                if (!degrees.containsKey(nei)){
                    degrees.put(nei,1);
                }else{
                    degrees.put(nei,degrees.get(nei)+1);
                }
            }
        }

        for (DirectedGraphNode node : graph){
            if (!degrees.containsKey(node)){
                queue.offer(node);
                result.add(node);
            }
        }

        while (!queue.isEmpty()){
            DirectedGraphNode nodeCur = queue.poll();    
            for(DirectedGraphNode nei : nodeCur.neighbors){
                degrees.put(nei,degrees.get(nei)-1);
                if (degrees.get(nei) == 0){
                    queue.offer(nei);
                    result.add(nei);
                }
            }
        }
        return result;
    }
}