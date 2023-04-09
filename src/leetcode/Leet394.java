package leetcode;

public class Leet394 {

}
class Solution {
    public String decodeString(String s) {
        if (s.length() == 0) {
            return "";
        }

        Stack<Integer> repeats = new Stack<>();
        Stack<String> str = new Stack<>();
        String str0 = "";

        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))){
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = count * 10 + s.charAt(i) - '0';
                    i++;
                }
                repeats.push(count);
            }
            else if (s.charAt(i) == '[') {
                str.push(str0);
                str0 = "";
                i++;
            }
            else if (s.charAt(i) == ']'){
                StringBuilder sb = new StringBuilder(str.pop());
                int repeat = repeats.pop();
                for(int j=0; j<repeat; j++){
                    sb.append(str0);
                }
                str0 = sb.toString();
                i++;
            }

            else{
                str0 += s.charAt(i); 
                i++;
            }
        }

        return str0;
    }
}
