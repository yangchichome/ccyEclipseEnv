package lintcode;

public class lint605 {

}
public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        Map<Integer, Set<Integer>> graph = buildGraph(seqs);
        Map<Integer, Integer> indegrees = getIndegrees(graph);
        List<Integer> topoOrder = getTopoOrder(graph, indegrees);

        if(topoOrder == null || topoOrder.size() != org.length){
            return false;
        }

        for(int i=0; i<org.length; i++){
            if (org[i] != topoOrder.get(i)){
                return false;
            }
        }

        return true;


    }

    private Map<Integer, Set<Integer>> buildGraph(int[][] seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap();
        for (int[] seq : seqs) {
            for (int i = 0; i < seq.length; i++) {
                if (!graph.containsKey(seq[i])) {
                    graph.put(seq[i], new HashSet<Integer>());
                }
            }
        }
        for (int[] seq : seqs) {
            for (int i = 1; i < seq.length; i++) {
                graph.get(seq[i - 1]).add(seq[i]);
            }
        }
        return graph;
    }

   private Map<Integer, Integer> getIndegrees(Map<Integer, Set<Integer>> graph) {
        Map<Integer, Integer> indegrees = new HashMap();
        for (Integer node : graph.keySet()) {
            indegrees.put(node, 0);
        }
        for (Integer node : graph.keySet()) {
            for (Integer neighbor : graph.get(node)) {
                indegrees.put(neighbor, indegrees.get(neighbor) + 1);
            }
        }
        return indegrees;
    }
    private List<Integer> getTopoOrder(Map<Integer, Set<Integer>> graph, Map<Integer, Integer> indegrees) {
        
        Queue<Integer> queue = new LinkedList();
        List<Integer> topoOrder = new ArrayList();
        
        for (Integer node : graph.keySet()) {
            if (indegrees.get(node) == 0) {
                queue.offer(node);
                topoOrder.add(node);
            }
        }
        
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return null;
            }
            
            Integer node = queue.poll();
            for (Integer neighbor : graph.get(node)) {
                indegrees.put(neighbor, indegrees.get(neighbor) - 1);
                if (indegrees.get(neighbor) == 0) {
                    queue.offer(neighbor);
                    topoOrder.add(neighbor);
                }
            }
        }
        
        if (graph.size() == topoOrder.size()) {
            return topoOrder;
        }
        
        return null;
    }
}