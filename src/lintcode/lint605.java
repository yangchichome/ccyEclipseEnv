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
        Map<Integer,Set<Integer>> graph = buildGraph(seqs);
        List<Integer> topOrder = getTopOrder(graph);

        if (topOrder == null || topOrder.size() != org.length) {
            return false;
        }

        for (int i=0; i<org.length; i++){
            if (org[i] != topOrder.get(i)){
                return false;
            }
        }

        return true;
    }

    public Map<Integer, Set<Integer>> buildGraph(int[][] seqs){
        Map<Integer, Set<Integer>> graph = new HashMap();

        for (int[] seq: seqs){
            for (int i=0; i<seq.length; i++){
                if (!graph.containsKey(seq[i])){
                    graph.put(seq[i], new HashSet<>());
                }
            }
        }

        for (int[] seq: seqs){
            for (int i=1; i<seq.length; i++){
                int s = seq[i-1];
                int e = seq[i];
                graph.get(s).add(e);
            }
        }

        return graph;
    }

    public Map<Integer, Integer> getOrder(Map<Integer, Set<Integer>> graph){
        Map<Integer, Integer> order = new HashMap();

        for(Integer node: graph.keySet()){
            order.put(node, 0);
        }
        for(Integer node: graph.keySet()){
            for (Integer edge: graph.get(node)){
                order.put(edge, order.get(edge)+1);
            }
        }

        return order;
    }

    public List<Integer> getTopOrder(Map<Integer, Set<Integer>> graph){
        Map<Integer,Integer> order = getOrder(graph);
        List<Integer> topOrder = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for (Integer node: order.keySet()){
            if (order.get(node) == 0){      
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()){
            if (queue.size() > 1){
                return null;
            }

            Integer node = queue.poll();
            topOrder.add(node);
            for (Integer edges: graph.get(node)){
                order.put(edges, order.get(edges)-1);

                if (order.get(edges) == 0){
                    queue.offer(edges);
                }
            }
        }

        if (graph.size() == topOrder.size()){
            return topOrder;
        }

        return null;
    }

}