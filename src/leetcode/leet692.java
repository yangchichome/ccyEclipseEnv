package leetcode;

public class leet692 {

}
class Pair {
    String key;
    int value;
    Pair (String key, int value){
        this.key = key;
        this.value = value;
    }
}

class Solution {
    private Comparator<Pair> pairCompare = new Comparator<Pair>() {
        public int compare (Pair p1, Pair p2){
            if (p1.value != p2.value){
                return p1.value - p2.value;
            }
            return p2.key.compareTo(p1.key);
        }
    };

    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        if (k == 0) {
            return result;
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (String word: words){
            if (map.containsKey(word)){
                map.put(word, map.get(word)+1);
            }else{
                map.put(word,1);
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k, pairCompare);
        for (String word: map.keySet()){
            Pair oldPair = pq.peek();
            Pair newPair = new Pair(word, map.get(word));
            if (pq.size() < k){
                pq.add(newPair);
            }else if (pairCompare.compare(newPair, oldPair) > 0){
                pq.poll();
                pq.add(newPair);
            }
        }

        String[] temp = new String[pq.size()];
        int i = pq.size()-1;
        while (pq.size() > 0){
            temp[i--] = pq.poll().key;
        }
        for (int j=0; j<temp.length; j++){
            result.add(temp[j]);
        }

        return result;

    }
}