package leetcode;

public class leet721_UF {

}
class UnionFind{
    private int[] parent;
    private int[] level;
    public UnionFind(int size){
        parent = new int[size];
        level = new int[size];
        for(int i=0; i<size; i++){
            parent[i] = i;
            level[i] = 0;
        }
    }

    public int Find(int x){
        if (parent[x] != x){
            parent[x] = Find(parent[x]);
        }
        return parent[x];
    }

    public void Union(int x, int y){
        int xp = Find(x);
        int yp = Find(y);

        if (xp == yp) return;

        if(level[xp] > level[yp]){
            parent[yp] = xp;
        } else if (level[xp] < level[yp]){
            parent[xp] = yp;
        }else{
            parent[yp] = xp;
            level[xp]++;
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        //Store all mail to UF and initialize
        Map<String, Integer> mToI = new HashMap<>();
        List<String> userName = new ArrayList<>();
        int index = 0;
        for(List<String> account: accounts){
            String name = account.get(0);
            for(int i=1; i<account.size(); i++){
                String mail = account.get(i);
                if (!mToI.containsKey(account.get(i))){
                    mToI.put(account.get(i), index++);
                    userName.add(name);
                }
            }
        }

        //Start Union all mails :
        UnionFind UF = new UnionFind(userName.size());
        for(List<String> account: accounts){
            for(int i=2; i<account.size(); i++){
                String mail1 = account.get(i);
                String mail2 = account.get(i-1);
                UF.Union(mToI.get(mail1), mToI.get(mail2));

            }
        }

        //get Unions by Find
        Map<Integer, List<String>> tmpAns = new HashMap<>(); 
        for(Map.Entry<String, Integer> entry: mToI.entrySet()){
            String mail = entry.getKey();
            int i = entry.getValue();
            int p = UF.Find(i);
            if (!tmpAns.containsKey(p)){
                tmpAns.put(p, new ArrayList<>());
            }
            tmpAns.get(p).add(mail);
        }

        // Convert to Result
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> entry: tmpAns.entrySet()){
            int i = entry.getKey();
            List<String> mailList = entry.getValue();
            String name = userName. get(i);
            Collections.sort(mailList);
            mailList.add(0, name);
            result.add(mailList);
        }

        return result;

    }
}