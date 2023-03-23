package lintcode;

public class Lint528 {

}
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.Iterator;

public class NestedIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack;

    private void pushListToStack(List<NestedInteger> nestedList){
        for (int i = nestedList.size()-1; i >= 0;i--){
            stack.push(nestedList.get(i));
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        stack = new Stack<>();
        pushListToStack(nestedList);
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        if (!hasNext()){
            return null;
        }
        return stack.pop().getInteger();
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        while(!stack.isEmpty() && !stack.peek().isInteger()){
            pushListToStack(stack.pop().getList());
        }
        return !stack.isEmpty();
    }

    @Override
    public void remove() {}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */