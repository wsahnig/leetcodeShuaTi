import java.util.Iterator;

/*
 * @lc app=leetcode id=284 lang=java
 *
 * [284] Peeking Iterator
 */
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> iterator;
	Integer x = null;
	
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if(x == null)
		x = iterator.next();
		return x;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(x != null){
			Integer tmp = x;
			x = null;
			return tmp;
		}
		return iterator.next();
	}

	@Override
	public boolean hasNext() {
	    return x != null || iterator.hasNext();
	}
}

