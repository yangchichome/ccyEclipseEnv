package leetcode;

public class leet17 {

}
class Solution {
    private Map<Character, char[]> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(digits.length() == 0) return result;

        dfs(digits, 0, sb, result);

        return result;
    }

    private void dfs(String digits, int index, StringBuilder sb, List<String> result){
        if (sb.length() == digits.length()){
            result.add(sb.toString());
            return;
        }

        char c = digits.charAt(index);
        for(char tmp: map.get(c)){
            sb.append(tmp);
            dfs(digits, index+1, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}