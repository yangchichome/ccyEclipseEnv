package lintcode;

public class Lint209 {

    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        // Write your code here
        int[] count = new int[256];
        for (int i =0;i< str.length();i++ ){
            count[str.charAt(i)]++;
        }
        for (int i =0;i< str.length();i++ ){
            if (count[str.charAt(i)] == 1) return str.charAt(i);
        }
        return '0';
    }
}