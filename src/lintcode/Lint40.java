package lintcode;

public class Lint40 {

}
public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        // do intialization if necessary
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        stack2.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if (stack1.empty()){
            stack2tostack1();
        }
        return stack1.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if (stack1.empty()){
            stack2tostack1();
        }
        return stack1.peek();
    }
    private void stack2tostack1(){
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
    }
}