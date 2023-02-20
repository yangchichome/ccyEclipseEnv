package lintcode;

public class SequenceReconstruction605 {

    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        HashMap<Integer,Set<Integer>> graph = getSeqGraph(seqs);
        HashMap<Integer,Integer> degrees = getSeqDegrees(graph);
        List<Integer> topoOrder = getTopoOrder(graph,degrees);

        if (topoOrder == null || org.length != topoOrder.size()){
            return false;
        }
        for (int i=0;i< org.length;i++){
            if(org[i] != topoOrder.get(i)){
                return false;
            }
        }
        return true;
    }

    private HashMap<Integer,Set<Integer>> getSeqGraph (int[][] seqs) {
        HashMap<Integer,Set<Integer>> graph = new HashMap<>();

        for (int[] seq : seqs){
            for (int node:seq){
                if (!graph.containsKey(node)){
                    graph.put(node,new HashSet<>());
                }
            }
        }

        for (int[] seq:seqs){
            for(int i=0;i<seq.length -1 ;i++){
                int preNode = seq[i];
                int nextNode = seq[i+1]; 
                graph.get(preNode).add(nextNode);
            }
        }

        return graph;
    }
    private HashMap<Integer,Integer> getSeqDegrees(HashMap<Integer,Set<Integer>> graph){
        HashMap<Integer,Integer> degrees = new HashMap<>();

        for (int node : graph.keySet()){
            if(!degrees.containsKey(node)){
                degrees.put(node,0);
            }
        }

        for (int node : graph.keySet()){
            for (int nei : graph.get(node)){
                degrees.put(nei,degrees.get(nei)+1);
            }
        }

        return degrees;
    }

    private List<Integer> getTopoOrder (HashMap<Integer,Set<Integer>> graph,HashMap<Integer,Integer> degrees){

        Queue<Integer> queue = new LinkedList<Integer>();
        List<Integer> result = new ArrayList<>();
        for (int x : degrees.keySet()){
            if (degrees.get(x) == 0){
                result.add(x);
                queue.add(x);
            }
        }

        while(!queue.isEmpty()){
            if(queue.size()>1){
                return null;
            }
            int node = queue.poll();
            Set<Integer> neighbors = graph.get(node);
            for (int nei:neighbors){
                degrees.put(nei,degrees.get(nei)-1);
                if (degrees.get(nei) == 0){
                    queue.add(nei);
                    result.add(nei);
                }
            }
        }
        return result;
    }
}