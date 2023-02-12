package leetcode;

public class FastPower {

    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        if (n==1){
            return a%b;
        }else if (n==0){
            return 1;
        }

        long powerSplit = fastPower(a,b,n/2);
        powerSplit = (powerSplit*powerSplit)%b;

        if (n%2==1){
            powerSplit = (powerSplit*a) % b;
        } 

        return (int) powerSplit;

    }
}