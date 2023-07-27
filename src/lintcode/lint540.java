package lintcode;

public class lint540 {

}
public class ZigzagIterator {
    private Iterator<Integer> L1;
    private Iterator<Integer> L2;
    private int count;
    /*
    * @param v1: A 1d vector
    * @param v2: A 1d vector
    */public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // do intialization if necessary
        L1 = v1.iterator();
        L2 = v2.iterator();
        count = 0;
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        // if (!hasNext()) return -1;

        int ans = 0;
        if ((count%2 == 0 && L1.hasNext() )|| !L2.hasNext()){
            ans = L1.next();
        }else if ((count%2 == 1 && L2.hasNext())|| !L1.hasNext()){
            ans = L2.next(); 
        }
        count++;
        return ans;
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        return L1.hasNext() || L2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator solution = new ZigzagIterator(v1, v2);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */