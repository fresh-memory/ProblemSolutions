import java.util.Iterator;
/**
 * Implement Iterator class with peek() functionality in Java.
 * @author feidong
 *
 * @param <T>
 */

public class newIterator<T> implements Iterator<T> {
    private Iterator<T> _iterator;
	private T _nextObj;
	
	
	public newIterator(Iterator<T> iterator){
		_iterator = iterator;
		getTop();
	}
	@Override
	public boolean hasNext() {
		return _nextObj != null;
	}

	@Override
	public T next() {
		if(!hasNext()) throw EndOfStreamException();
		T _newObj = _nextObj;
		_nextObj = _iterator.next();
		return _newObj;
	}

	@Override
	public void remove() {
		_iterator.remove();
	}

	
	public T peek(){
		return _nextObj;
	}
	
	T getTop(){
		_nextObj=null;
		_nextObj = _iterator.next();
		return _nextObj;
	}
}

