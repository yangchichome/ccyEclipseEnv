package lintcode;

public class lint540 {

}
public class ZigzagIterator {
    private Iterator<Integer> l1;
    private Iterator<Integer> l2;
    private int count;
    /*
    * @param v1: A 1d vector
    * @param v2: A 1d vector
    */public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // do intialization if necessary
        l1 = v1.iterator();
        l2 = v2.iterator();
        count = 0;
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        count++;
        if ((count%2 == 1 && l1.hasNext()) || !l2.hasNext()){
            return l1.next();
        }else if ((count%2 == 0 && l2.hasNext()) || !l1.hasNext()){
            return l2.next();
        }

        return -1;
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here

        return l1.hasNext() || l2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator solution = new ZigzagIterator(v1, v2);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */