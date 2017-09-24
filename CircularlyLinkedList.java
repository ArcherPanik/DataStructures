public class CircularlyLinkedList<E> {
	
	private static class Node<E> {
		private E element;
		private Node<E> next;
		/**
		 * The constructor of the node.
		 * @param e It is the element itself of the type E
		 * @param n It is a reference to the next node so it has to be an instance of the class Node or null
		 */
		public Node(E e, Node<E> n) {
			element = e;
			next =  n;
		}
		
		/**
		 * This method return the element of type E that is in the node.
		 * 
		 */
		public E getElement() {
			return element;
		}
		
		/**
		 * Returns a reference to the next node so it is of type Node. If you want to extract 
		 * the element you have to use the method getElement()
		 * @return a reference to the next node
		 */
		public Node<E> getNext() {
			return next;
		}
		
		/**
		 * This method allows you to set the element of type E that you want to store in the node
		 * @param n The element of type E that you want to store
		 */
		public void setNext(Node<E> n) {
			next = n;
		}
	}
	
	private Node<E> tail = null;
	private int size = 0;
	
	public CircularlyLinkedList() {}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public E first() {
		if(isEmpty())
			return null;
		return tail.getNext().getElement();
	}
	
	public E last() {
		if(isEmpty())
			return null;
		return tail.getElement();
	}
	
	public void rotate() {
		if(tail != null)
			tail = tail.getNext();
	}
	
	public void addFirst(E e) {
		
		if (size == 0) {
			tail = new Node<> (e, null);
			tail.setNext(tail);
		} else {
			Node<E> newest = new Node<>(e, tail.getNext());
			tail.setNext(newest);		
		}
		
		size++;
	}
	
	public void addLast(E e) {
		addFirst(e);
		tail = tail.getNext();
	}
	
	public E removeFirst() {
		if (isEmpty()) 
			return null;
		
		Node<E> head = tail.getNext();
		
		if (head == tail) {
			tail = null;
		} else { 
			tail.setNext(head.getNext());
		}
		
		size--;
		return head.getElement();
	}
	
}
