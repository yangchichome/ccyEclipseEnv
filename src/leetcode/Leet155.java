package leetcode;

public class Leet155 {

}
class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minstack;

    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minstack.empty() == true){
            minstack.push(val);
        } else if (minstack.peek() >= val){
            minstack.push(val);
        }
    }
    
    public void pop() {
        if (stack.peek().equals(minstack.peek()))
            minstack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
