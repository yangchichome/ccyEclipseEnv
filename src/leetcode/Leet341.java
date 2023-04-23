package leetcode;

public class Leet341 {

}
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack;

    public void nestedListToStack(List<NestedInteger> nestedList){
        Stack<NestedInteger> temp = new Stack<>();
        for (NestedInteger nested : nestedList){
            temp.push(nested);
        }

        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        nestedListToStack(nestedList);
    }

    @Override
    public Integer next() {
        if(!hasNext()){
            return null;
        }
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty() && !stack.peek().isInteger()){
            nestedListToStack(stack.pop().getList());
        }

        return !stack.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */