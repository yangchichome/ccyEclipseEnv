package lintcode;

public class lint178_Union_Find {

}
public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */

    class Union {
        Map<Integer, Integer> father = new HashMap();
        public Union (int n){
            for(int i=0; i<n; i++){
                father.put(i, i);
            }
        }

        int father_compress(int x){
            int f = father.get(x);
            while (f != father.get(f)){
                f = father.get(f);
            }

            int temp = -1;
            int fa = father.get(x);
            father.put(x, f);
            while(fa != father.get(fa)){
                temp = father.get(fa);
                father.put(fa, f);
                fa = temp;
            }

            return f;
        }

        void union(int x, int y){
            int fa_x = father_compress(x);
            int fa_y = father_compress(y);
            if (fa_x != fa_y)
                father.put(fa_x, fa_y);    
        } 
    }

    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if(n-1 != edges.length) return false;

        Union u = new Union(n);

        for (int i=0; i<edges.length; i++){
            if(u.father_compress(edges[i][0]) == u.father_compress(edges[i][1])){
                return false;
            }
            u.union(edges[i][0], edges[i][1]);
        }

        return true;
    }
}