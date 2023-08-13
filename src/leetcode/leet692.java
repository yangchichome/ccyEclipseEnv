package leetcode;

public class leet692 {

}
class wordinfo{
    public String str;
    public int count;
    public wordinfo(String str, int count){
        this.str =  str;
        this.count = count;
    }
}


class Solution {
    private Comparator<wordinfo> wordCompare = new Comparator<wordinfo>(){
            public int compare(wordinfo w1, wordinfo w2){
                if (w1.count == w2.count){
                    return w2.str.compareTo(w1.str);
                }else{
                    return w1.count - w2.count;
                }
            }
    };

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word: words){
            if(!map.containsKey(word)){
                map.put(word, 1);
            }else{
                map.put(word, map.get(word)+1);
            }
        }

        PriorityQueue<wordinfo> pq = new PriorityQueue<>(wordCompare);

        for(Map.Entry<String,Integer> entry: map.entrySet()){
            pq.offer(new wordinfo(entry.getKey(), entry.getValue()));
            if (pq.size() > k){
                pq.poll();
            }
        }

        List<String> result = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        while(!pq.isEmpty()){
            tmp.add(pq.poll().str);
        }
        for(int i=tmp.size()-1; i>=0; i--){
            result.add(tmp.get(i));
        }

        return result;
    }
}