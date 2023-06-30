package leetcode;

public class leet290 {

}
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> cTos = new HashMap<>();
        Map<String,Character> sToc = new HashMap<>();

        String[] words = s.split(" ");

        if (pattern.length() != words.length){
            return false;
        }
        
        for (int i=0; i<words.length; i++){
            char c = pattern.charAt(i);
            String str = words[i];
            if (cTos.get(c) != null && !cTos.get(c).equals(str)){
                return false;
            }
            if (sToc.get(str) != null && !sToc.get(str).equals(c)){
                return false;
            }

            cTos.put(c, str);
            sToc.put(str, c);
        }

        return true;
    }
}