package lintcode;

public class Lint473_Prefix_Trie {

}
class TrieNode {
    public TrieNode[] children;
    public boolean hasWord;

    public TrieNode() {
        children = new TrieNode[26];
        for (int i=0; i<26; i++){
            children[i] = null;
        }
        hasWord = false;
    }
}

public class WordDictionary {
    private TrieNode root;

    public WordDictionary(){
        root = new TrieNode();
    }
    /*
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */
    public void addWord(String word) {
        // write your code here
        TrieNode now = root;
        for (int i=0; i<word.length(); i++){
            Character c = word.charAt(i);
            if (now.children[c - 'a'] == null){
                now.children[c - 'a'] = new TrieNode();
            }
            now = now.children[c -'a'];
        }
        now.hasWord = true;
    }

    boolean find (String word, int index, TrieNode now){
        if (index == word.length()) {
            return now.hasWord;
        }

        Character c = word.charAt(index);
        if (c == '.'){
            for (int i=0; i<26; i++){
                if (now.children[i] != null){
                    if (find(word, index+1, now.children[i]))
                        return true;
                }
            }
            return false;
        }else if (now.children[c - 'a'] != null){
            return find(word, index+1, now.children[c - 'a']);
        }else {
            return false;
        }
    } 
    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        // write your code here
        return find(word, 0, root);
    }
}