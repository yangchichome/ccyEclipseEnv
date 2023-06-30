package lintcode;

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
        Map<Character,String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        return dfs(pattern, str, set, map);
    }

    private boolean dfs(String pattern, String str, Set<String> set, Map<Character,String> map){
        if (pattern.length() == 0){
            return str.length() == 0;
        }

        Character c = pattern.charAt(0);
        if (map.containsKey(c)){
            if (!str.startsWith(map.get(c))){
                return false;
            }

            return dfs(pattern.substring(1), str.substring(map.get(c).length()), set, map);
        }

        for (int i=0; i<str.length(); i++){
            String subStr = str.substring(0, i+1);

            map.put(c, subStr);
            set.add(subStr);
            if (dfs(pattern.substring(1), str.substring(i+1), set, map)){
                return true;
            }
            map.remove(c);
            set.remove(subStr);
        }

        return false;
    }
}