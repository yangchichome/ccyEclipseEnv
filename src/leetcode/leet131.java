package leetcode;

public class leet131 {

}
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> partial = new ArrayList<>();

        dfs(s, 0, partial, result);

        return result;
    }

    private void dfs(String s, int index, List<String> partial, List<List<String>> result){
        if(index == s.length()){
            result.add(new ArrayList<>(partial));
        }

        for(int j=index+1; j<=s.length(); j++){
            String tmp = s.substring(index,j);
            if(isPalindrome(tmp)){
                partial.add(tmp);
                dfs(s, j, partial, result);
                partial.remove(partial.size()-1);
            }
        }
    }

    private boolean isPalindrome(String tmp){
        int s = 0;
        int e = tmp.length()-1;
        while(s<e){
            if (tmp.charAt(s) != tmp.charAt(e)){
                return false;
            }
            s++;
            e--;
        } 
        return true;
    }
}