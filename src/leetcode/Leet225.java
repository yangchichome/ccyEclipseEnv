package leetcode;

class Leet225 {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue1.offer(x);
    }
    
    public int pop() { 
        while(queue1.size() > 1){
            queue2.offer(queue1.poll());
        }
        int result = queue1.poll();
        Queue<Integer> queuetmp = queue1;
        queue1 = queue2;
        queue2 = queuetmp;

        return result;
        
    }
    
    public int top() {
        int result = pop();
        queue1.offer(result);
        return result;
    }
    
    public boolean empty() {
        return queue1.isEmpty();
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