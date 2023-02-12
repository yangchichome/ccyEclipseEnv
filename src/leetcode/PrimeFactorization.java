package leetcode;

public class PrimeFactorization {

    /**
     * @param num: An integer
     * @return: an integer array
     */
    public List<Integer> primeFactorization(int num) {
        // write your code here
        List<Integer> ans = new ArrayList<>();

        for (int i=2;i*i <= num;i++){
            while (num % i == 0){
                num /= i;
                ans.add(i);
            }
        }
        if (num != 1){
            ans.add(num);
        }
        
        return ans;

    }
}