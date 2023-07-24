package lintcode;

import java.util.Set;

public class lint829 {

}
public class Solution {
    /**
     * @param pattern: a string,denote pattern string
     * @param str: a string, denote matching string
     * @return: a boolean
     */
    public boolean wordPatternMatch(String pattern, String str) {
        // write your code here
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        return dfs(pattern, str, set, map);
    }

    private boolean dfs(String pat, String str, Set<String> set, Map<Character, String> map){
        if (pat.length() == 0) {
            return str.length() == 0;
        }

        Character c = pat.charAt(0);
        if (map.containsKey(c)){
            if (!str.startsWith(map.get(c))){
                return false;
            }else{
                return dfs(pat.substring(1), str.substring(map.get(c).length()), set, map);
            }
        }

        for(int i=0; i<str.length(); i++){
            String subStr = str.substring(0, i+1);

            if(set.contains(subStr)){
                continue;
            }

            set.add(subStr);
            map.put(c, subStr);
            if (dfs(pat.substring(1), str.substring(i+1), set, map)){
                return true;
            }
            set.remove(subStr);
            map.remove(c);
        }

        return false;
    }
}