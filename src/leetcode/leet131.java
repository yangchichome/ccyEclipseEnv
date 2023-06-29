package leetcode;

public class leet131 {

}
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.length() == 0) return result;

        List<String> partial = new ArrayList<>();
        dfs(s, 0, partial, result);

        return result;
    }

    private void dfs(String s, int startIndex, List<String> partial, List<List<String>> result){

        if (startIndex == s.length()) {
            result.add(new ArrayList<String>(partial));
            return;
        }

        for (int i=startIndex; i< s.length(); i++){
            String subStr = s.substring(startIndex, i+1);

            if (!isPalindrome(subStr)){
                continue;
            }

            partial.add(subStr);
            dfs(s, i+1, partial, result);
            partial.remove(partial.size()-1);

        }
    }

    private boolean isPalindrome(String s){
        for (int i=0,j=s.length()-1; i<j; i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }

        return true;
    }
}