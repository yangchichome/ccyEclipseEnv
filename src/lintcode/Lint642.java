package lintcode;

public class Lint642 {

    private Queue<Integer> queue;
    private double sum = 0;
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
            sum = sum -queue.poll();
        }
        queue.offer(val);
        return sum /queue.size();
    }
}