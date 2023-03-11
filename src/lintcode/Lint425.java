package lintcode;

public class Lint425 {

    /**
     * @param digits: A digital string
     * @return: all possible letter combinations
     *          we will sort your return value in output
     */
    public List<String> letterCombinations(String digits) {
        // write your code here
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) return result;

        Map<Character, char[]> map = new HashMap<>();
        map.put('2',new char[] {'a','b','c'});
        map.put('3',new char[] {'d','e','f'});
        map.put('4',new char[] {'g','h','i'});
        map.put('5',new char[] {'j','k','l'});
        map.put('6',new char[] {'m','n','o'});
        map.put('7',new char[] {'p','q','r','s'});
        map.put('8',new char[] {'t','u','v'});
        map.put('9',new char[] {'w','x','y','z'});

        StringBuilder sb = new StringBuilder();
        helper(map,digits,sb,result);

        return result;
    }
    public void helper(Map<Character,char[]> map,String digits,StringBuilder sb,List<String> result){
        if (sb.length() == digits.length()){
            result.add(sb.toString());
            return;
        }
        for (char c:map.get(digits.charAt(sb.length()))){
            sb.append(c);
            helper(map,digits,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}