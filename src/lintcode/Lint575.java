package lintcode;

public class Lint575 {

}
public class Solution {
    /**
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */
    public String expressionExpand(String s) {
        // write your code here
        if (s.length() == 0) return "";

        Stack<Integer> repeat = new Stack<>();
        Stack<String> tmpstr = new Stack<>();
        String res = "";

        int i = 0;
        while(i < s.length()){
            if (Character.isDigit(s.charAt(i))){
                int count = 0;
                while(Character.isDigit(s.charAt(i))){
                    count = 10*count + s.charAt(i) - '0';
                    i++;
                }    
                repeat.push(count);
            }
            else if (s.charAt(i) == '['){
                tmpstr.push(res);
                res = "";
                i++;

            }else if (s.charAt(i) == ']'){
                StringBuilder sb = new StringBuilder(tmpstr.pop());
                int repeatTime = repeat.pop();
                for (int j=0;j<repeatTime;j++){
                    sb.append(res);
                }
                res = sb.toString();
                i++;
            }else{
                res += s.charAt(i);
                i++;
            }
        }

        return res;
    }
}