package lintcode;

public class lint642 {

}
public class MovingAverage {
    private Queue<Integer> queue;
    private double sum;
    private int size;
    /*
    * @param size: An integer
    */public MovingAverage(int size) {
        // do intialization if necessary
        queue = new LinkedList<>();
        this.size = size;
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        // write your code here
        sum += val;

        if (queue.size() == size){
            sum -= queue.poll();
        }

        queue.offer(val);

        return sum / queue.size();

    }
}