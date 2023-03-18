package lintcode;

public class Lint471 {

}
class Pair{
    String key;
    int value;

    Pair(String key,int value){
        this.key=key;
        this.value=value;
    }
}

public class Solution {
    /**
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    private Comparator<Pair> pairComparator = new Comparator<Pair>(){
        public int compare(Pair left,Pair right){
            if (left.value != right.value){
                return left.value - right.value;
            }
            return right.key.compareTo(left.key);
        }
    };

    public String[] topKFrequentWords(String[] words, int k) {
        if (k == 0) return new String[0];
        // write your code here
        Map<String,Integer> map = new HashMap<>();
        for (String word: words){
            if (map.containsKey(word)){
                map.put(word,map.get(word)+1);
            }else{
                map.put(word,1);
            }
        }

        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(k,pairComparator);
        for (String word: map.keySet()){
            Pair peek = queue.peek();
            Pair newPair = new Pair(word,map.get(word));
            if (queue.size()<k) {
                queue.add(newPair);
            }else if (pairComparator.compare(newPair,peek) > 0){
                queue.poll();
                queue.add(newPair);
            }
        }
        String[] result = new String[k];
        int index = 0;

        for (int i=k-1;i >= 0;i--){
            result[i] = queue.poll().key;
        }
        return result;
    }
