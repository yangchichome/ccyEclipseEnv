package leetcode;

public class leet93 {

}
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> partial = new ArrayList<>();

        if (s.length() > 12 || s.length() < 4){
            return result;
        }

        dfs(s, 0, partial, result);

        return result;
    }

    private void dfs(String s, int startIndex, List<String> partial, List<String> result){
        if (partial.size() == 4){
            if (s.length() != startIndex){
                return;
            }

            StringBuffer sb = new StringBuffer();
            for (String tmp : partial){
                sb.append(tmp);
                sb.append('.');
            }
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return;
        }

        for (int i=startIndex; i<startIndex+3 && i<s.length(); i++){
            String subStr = s.substring(startIndex, i+1);
            if (isValid(subStr)){

                partial.add(subStr);
                dfs(s, i+1, partial, result);
                partial.remove(partial.size()-1);
            }
            
        }
    }

    private boolean isValid(String s){
        if (s.charAt(0) == '0'){
            return s.equals("0");
        }
        int digit = Integer.valueOf(s);
        return digit >= 0 && digit <= 255;
    }
}