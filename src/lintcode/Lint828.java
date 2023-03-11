package lintcode;

public class Lint828 {

    /**
     * @param pattern: a string, denote pattern string
     * @param teststr: a string, denote matching string
     * @return: an boolean, denote whether the pattern string and the matching string match or not
     */
    public boolean wordPattern(String pattern, String teststr) {
        // write your code here
        Map<Character,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        int index=0, now = 0;
        String tmpStr ="";
        teststr += ' ';

        for (int i=0;i< teststr.length();++i){
            if (teststr.charAt(i) == ' '){
                char key = pattern.charAt(index);
                if (map1.get(key) == null && map2.get(tmpStr) == null){
                    map1.put(pattern.charAt(index),now);
                    map2.put(tmpStr,now);
                    now++;
                }
                else if (map1.get(key) != null  && map2.get(tmpStr) != null){
                    if (map1.get(key) != map2.get(tmpStr)) return false;
                }
                else return false;

                tmpStr = "";
                index++;
            }else {
                tmpStr += teststr.charAt(i);
            }
            
        }
        return true;
    }
}