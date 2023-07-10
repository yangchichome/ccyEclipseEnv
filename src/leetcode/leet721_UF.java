package leetcode;

public class leet721_UF {

}
class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        Map<String, Integer> emailToAcc = new HashMap<>();

        int i = 0;
        for(List<String> emails: accounts){
            for(int j=1; j<emails.size(); j++){
                String email = emails.get(j);
                if (emailToAcc.containsKey(email)){
                    // System.out.println("union:"+i+", "+emailToAcc.get(email));
                    uf.union(i, emailToAcc.get(email));
                    int val = emailToAcc.get(email);
                    // System.out.println("Parent "+i+" :"+uf.find(i)+", "+val+" :"+uf.find(val));
                }else{
                    // System.out.println(i+" add"+email);
                    emailToAcc.put(email, i);
                }
            }
            i++;
        }

        Map<Integer,List<String>> emailGroup = new HashMap<>();
        emailToAcc.forEach((e, index) ->{
            int leader = uf.find(index);
            // System.out.println("index:"+index+ " ,parent"+leader+",mail"+e);
            List<String> emails = emailGroup.getOrDefault(leader, new ArrayList<>());
            emails.add(e);
            emailGroup.put(leader, emails);
        });

        List<List<String>> result = new ArrayList<>();
        emailGroup.forEach((index, emails) ->{
            Collections.sort(emails);
            String name = accounts.get(index).get(0);
            emails.add(0, name);
            result.add(emails);

        });

        return result;
    }
}