package leetcode;

public class leet208_prefixTree {

}
class TrieNode {
    private TrieNode[] children;
    public boolean hasWord;

    public TrieNode() {
        children = new TrieNode[26];
        hasWord = false;
    }

    public void insert(String word, int index){
        if (word.length() == index){
            hasWord = true;
            return;
        }
        int pos = word.charAt(index) - 'a';
        if (children[pos] == null){
            children[pos] = new TrieNode();
        }
        children[pos].insert(word, index+1);
    }

    public TrieNode find(String word, int index){
        if (index == word.length()){
            return this;
        }

        int pos = word.charAt(index) - 'a';
        if (children[pos] == null){
            return null;
        }

        return children[pos].find(word, index+1);
    }


}

class Trie {
    private TrieNode pt;

    public Trie() {
        pt = new TrieNode();    
    }
    
    public void insert(String word) {
        pt.insert(word, 0);
    }
    
    public boolean search(String word) {
       TrieNode node = pt.find(word, 0);
       return node != null && node.hasWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = pt.find(prefix, 0);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
