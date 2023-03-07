package lintcode;

public class Lint426 {

    /**
     * @param s: the IP string
     * @return: All possible valid IP addresses
     *          we will sort your return value in output
     */
    public List<String> restoreIpAddresses(String s) {
        // write your code here
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> subSet = new ArrayList<>();
        if (s.length() < 4 || s.length() >12) {
            return result;
        }

        helper(s,subSet,0,result);
        return result;
    }

    public void helper(String s,ArrayList<String> subSet,int start,ArrayList<String> result){
        if(subSet.size() == 4){
            if(start != s.length()) return;

            StringBuffer sb = new StringBuffer();
            for (String tmp:subSet){
                sb.append(tmp);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return;
        }
        for (int i=start;i <s.length() && i < start+3;i++){
            String tmp = s.substring(start,i+1);
            if(isValid(tmp)){
                subSet.add(tmp);
                helper(s,subSet,i+1,result);
                subSet.remove(subSet.size()-1);
            }
        }
    }

    private boolean isValid(String s){
        if (s.charAt(0) == '0') return s.equals("0");
        int digit = Integer.valueOf(s);
        return digit >= 0 && digit <= 255;
    }
}