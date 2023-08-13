package leetcode;

public class leet225 {

}
class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        while(q1.size() > 1){
            q2.offer(q1.poll());
        }
        int ans = q1.poll();
        Queue<Integer> tmp = new LinkedList<>();
        q1 = q2;
        q2 = tmp;

        return ans;
    }
    
    public int top() {
        int tmp = pop();
        q1.offer(tmp);
        return tmp;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */