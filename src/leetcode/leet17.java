package leetcode;

public class leet17 {

}
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.length() == 0) return result;

        Map<Character, char[]> map = new HashMap<>();
        map.put('2',new char[] {'a', 'b', 'c'});
        map.put('3',new char[] {'d', 'e', 'f'});
        map.put('4',new char[] {'g', 'h', 'i'});
        map.put('5',new char[] {'j', 'k', 'l'});
        map.put('6',new char[] {'m', 'n', 'o'});
        map.put('7',new char[] {'p', 'q', 'r', 's'});
        map.put('8',new char[] {'t', 'u', 'v'});
        map.put('9',new char[] {'w', 'x', 'y', 'z'});

        StringBuilder sb = new StringBuilder();
        dfs(digits, map, sb, result);

        return result;
    }

    private void dfs(String s, Map<Character,char[]> map, StringBuilder sb, List<String> result){
        
        if (sb.length() == s.length()){
            result.add(sb.toString());
            return;
        }

        for (char c : map.get(s.charAt(sb.length()))){
            sb.append(c);
            dfs(s, map, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}