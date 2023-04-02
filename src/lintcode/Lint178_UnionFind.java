package lintcode;

public class Lint178_UnionFind {

}
public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */

    class UnionFind{
        HashMap<Integer,Integer> father = new HashMap<>();
        UnionFind(int n){
            for (int i=0; i<n; i++){
                father.put(i,i);
            }
        }
        int compressed_find(int x){
            int parent = father.get(x);
            while (parent != father.get(parent)){
                parent = father.get(parent);
            }

            int temp = -1;
            int fa = father.get(x);
            while(fa != father.get(fa)){
                temp = father.get(fa);
                father.put(fa, parent);
                fa = temp;
            }
            return parent;
        }

        void union(int x, int y){
            int fa_x = compressed_find(x);
            int fa_y = compressed_find(y);
            if(fa_x != fa_y)
                father.put(fa_x,fa_y);
        }
    }
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if ( n-1 != edges.length){
            return false;
        }

        UnionFind uf = new UnionFind(n);
        for (int i=0; i<edges.length; i++){
            if (uf.compressed_find(edges[i][0]) == uf.compressed_find(edges[i][1])) {
                return false;
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        return true;
    }
}