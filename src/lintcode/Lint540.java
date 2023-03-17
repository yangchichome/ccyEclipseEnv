package lintcode;

public class Lint540 {

}
public class ZigzagIterator {

    public Iterator<Integer> iv1;
    public Iterator<Integer> iv2;
    public int count ;
    /*
    * @param v1: A 1d vector
    * @param v2: A 1d vector
    */public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // do intialization if necessary
        this.iv1 = v1.iterator();
        this.iv2 = v2.iterator();
        count=0;
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        count++;
        if ((count%2 == 1 && iv1.hasNext()) || !iv2.hasNext()){
            return iv1.next();
        }else if ((count%2 == 0 && iv2.hasNext()) || !iv1.hasNext()){
            return iv2.next();
        }
        return -1;
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        return iv1.hasNext() || iv2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator solution = new ZigzagIterator(v1, v2);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */