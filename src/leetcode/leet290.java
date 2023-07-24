package leetcode;

public class leet290 {

}
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        int patIdx = 0;
        String subStr = "";
        for(int i=0; i<s.length(); i++){
            if (s.charAt(i) != ' '){
                subStr += s.charAt(i);
            }
            
            if (s.charAt(i) == ' ' || i == s.length()-1) {
                if (patIdx >= pattern.length()){
                    return false;
                }
                Character c = pattern.charAt(patIdx++);

                if (map.containsKey(c)){
                    if (!map.get(c).equals(subStr)){
                        return false;
                    }
                }else{
                    if (set.contains(subStr)){
                        return false;
                    }
                    map.put(c, subStr);
                    set.add(subStr);
                }
                subStr = "";
            }
        }

        if (patIdx != pattern.length()) return false;

        return true;
    }
}