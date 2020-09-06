
public class RecursiveLinkedCollection<T> implements CollectionInterface<T> {
	
	LLNode<T> front;
	int size = 0;
	
	RecursiveLinkedCollection() {
		front = null;
		size = 0;
	}
	
	private LLNode<T> recAdd(LLNode<T> node, T data) {
		
		if(node.getLink() == null) {
			LLNode<T> newNode = new LLNode<T>(data);
			node.setLink(newNode);
			return newNode;
			}
		return recAdd(node.getLink(), data);
	}

	@Override
	public boolean add(T data) {
		if(data == null) {
			return false;
		}
		recAdd(front, data);
		return true;
		
	
	}
	
	private T recGet(LLNode<T> node, T data) {
		if(node.getInfo().equals(data)) {
			return data;
		}
		return recGet(front.getLink(), data);
	}

	@Override
	public T get(T data) {
		return recGet(front, data);
	}
	
	private LLNode<T> recRemove(LLNode<T> node, T data) {
		if(node == null) {
			return null;
		}
		if(node.equals(data)) {
			LLNode<T> temp = new LLNode<T>(data);
			temp = front;
			temp.setLink(node.getLink());
		}
		return recRemove(node.getLink(), data);
	}
	

	@Override
	public boolean remove(T data) {
		if(recRemove(front, data) == data) {
			return true;
		}
		return false;
	}
	
	private boolean recContains(LLNode<T> node, T data) {
		if(node != data) {
			return false;
		}
		if(node.getInfo().equals(data)) {
			return true;
		}
		return recContains(node.getLink(), data);
	}

	@Override
	public boolean contains(T data) {
		return recContains(front, data);
	}

	@Override
	public boolean isFull() {
		if(front == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int recSize(LLNode<T> node) {
		if(node == null) {
			return 0;
		}
		return 1 + recSize(node.getLink());
	}

	@Override
	public int size() {
		return recSize(front);
	}
	
	public String toString() {
		return front.toString();
	}

}


