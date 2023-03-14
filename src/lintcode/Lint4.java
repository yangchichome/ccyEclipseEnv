package lintcode;

public class Lint4 {

    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here
        Queue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        Long[] factors = new Long[3];
        factors[0] = 2L;
        factors[1] = 3L;
        factors[2] = 5L;
        for (int i=0;i<factors.length;i++){
            queue.add(factors[i]);
            set.add(factors[i]);
        }

        Long value = 1L;
        for(int i=1;i<n;i++){
            value = queue.poll();

            for (int j=0;j<3;j++){
                if (!set.contains(value*factors[j])){
                    queue.add(factors[j]*value);
                    set.add(factors[j]*value);
                }
            }
        }

        return value.intValue();
    }   
}