package leetcode;

public class leet93 {

}
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> partial = new ArrayList<>();
        dfs(s, 0, partial, result);

        return result;
    }
    private void dfs(String s, int startIdx, List<String> partial, List<String> result){      
        if (startIdx == s.length() && partial.size() == 4){
            StringBuilder sb = new StringBuilder();
            for(String tmp: partial){
                sb.append(tmp);
                sb.append('.');
            }
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return;
        }

        for(int i=startIdx; i<s.length() && i<startIdx+3; i++){
            String subStr = s.substring(startIdx, i+1);
            if (!isValid(subStr)){
                continue;
            }
            
            partial.add(subStr);
            dfs(s, i+1, partial, result);
            partial.remove(partial.size()-1);
        }
    }

    private boolean isValid(String s){
        if (s.length() > 1 && s.charAt(0) == '0'){
            return false;
        }
        int value = Integer.valueOf(s);
        if (value >= 0 && value <= 255){
            return true;
        }

        return false;
    }
}