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
        Map<Integer, Set<Integer>> nextNodes = buildNextNodes(seqs);
        Map<Integer, Integer> nodeLevels = buildNodeLevel(nextNodes);
        // System.out.prtinln()
        Queue<Integer> queue = new LinkedList<>();
        for(int key: nodeLevels.keySet()){
            // System.out.println("key"+key+" ,val"+nodeLevels.get(key));
            if(nodeLevels.get(key) == 0){
                queue.offer(key);
            }
        }
        
        List<Integer> paths = new ArrayList<>();
        while(!queue.isEmpty()){
            if (queue.size() > 1){
                return false;
            }
            int preNode = queue.poll();
            paths.add(preNode);
            for(int nextN: nextNodes.get(preNode)){
                nodeLevels.put(nextN, nodeLevels.get(nextN)-1);
                if(nodeLevels.get(nextN) == 0){
                    queue.offer(nextN);
                }
            }
        }

        if (paths.size() != org.length) return false;

        for(int i=0 ;i<paths.size(); i++){
            if(paths.get(i) != org[i]) return false;
        }

        return true;
    }

    private Map<Integer,Set<Integer>> buildNextNodes(int[][] seqs){
        Map<Integer, Set<Integer>> result = new HashMap<>();
        for(int[] seq: seqs){
            for(int i=0; i<seq.length; i++){
                if (!result.containsKey(seq[i])){
                    result.put(seq[i], new HashSet<>());
                }
            }
        }
        for(int[] seq: seqs){
            for(int i=1; i<seq.length; i++){
                result.get(seq[i-1]).add(seq[i]);
            }
        }
        return result;
    }

    private Map<Integer,Integer> buildNodeLevel(Map<Integer,Set<Integer>> nextNodes){
        Map<Integer, Integer> levels = new HashMap<>();
        for(int key: nextNodes.keySet()){
            levels.put(key, 0);
        }

        for(int key: nextNodes.keySet()){
            for(int x: nextNodes.get(key)){
                levels.put(x, levels.get(x)+1);
            }
        }

        return levels;
    }
}