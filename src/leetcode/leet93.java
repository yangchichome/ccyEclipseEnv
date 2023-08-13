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

    private void dfs(String s, int index, List<String> partial, List<String> result){
        if(index == s.length()){
            if(partial.size() == 4){
                StringBuilder sb = new StringBuilder();
                for(String str: partial){
                    sb.append(str);
                    sb.append(".");
                }
                sb.deleteCharAt(sb.length()-1);
                result.add(sb.toString());
            }
        }

        for(int i=index+1; i<=s.length() && i<=index+3; i++){
            String tmp = s.substring(index, i);
            if(isValid(tmp)){
                partial.add(tmp);
                dfs(s, i, partial, result);
                partial.remove(partial.size()-1);
            }
        }
    }

    private boolean isValid(String tmp){
        if (tmp.charAt(0) == '0' && tmp.length() > 1){
            return false;
        }
        int num = Integer.valueOf(tmp);
        if(num >= 0 && num <= 255){
            return true;
        }

        return false;
    }
}