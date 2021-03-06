/*
 * @lc app=leetcode id=341 lang=java
 *
 * [341] Flatten Nested List Iterator
 */
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
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            if(curr.isInteger()) {
                return true;
            }
            stack.pop();
            for(int i = curr.getList().size() - 1; i >= 0; i--) {
                stack.push(curr.getList().get(i));
            }
        }
        return false;
    }
    // private Queue<Integer> flattenedList;

    // public NestedIterator(List<NestedInteger> nestedList) {
    //     flattenedList = new LinkedList<>();
    //     constructList(nestedList);
    // }

    // private void constructList(List<NestedInteger> nestedList) {
    //     for (NestedInteger nestedInteger : nestedList) {
    //         if (nestedInteger.isInteger()) {
    //             flattenedList.add(nestedInteger.getInteger());
    //         } else {
    //             constructList(nestedInteger.getList());
    //         }
    //     }
    // }

    // @Override
    // public Integer next() {
    //     return flattenedList.poll();
    // }

    // @Override
    // public boolean hasNext() {
    //     return !flattenedList.isEmpty();
    // }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

