/**
 * This is a class for implementing simply linked list with a generic type. 
 * The class node is nested in it.
 * @author Báez
 *
 * 
 */
public class SinglyLinkedList<E>{
	/**
	 * This is a class representing a Node in a simply linked list. It only has its element 
	 * and a reference to the next node. It uses a generic type for the element.
	 * @author Baez
	 *
	 */
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
	
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	/**
	 * Default constructor
	 */
	public SinglyLinkedList() {}
	
	/**
	 * @return the number of elements that the list has
	 */
	public int size() {
		return size;
	}
	
	/**
	 * @return True if the list has zero elements
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * This method returns the first element of the list
	 * @return The element of type E that is stored in the head of the list
	 */
	public E first() {
		if(isEmpty()) 
			return null;
		
		return head.getElement();
	}
	
	/**
	 * This method returns the last element of the list
	 * @return The element of type E that is stored in the tail of the list
	 */
	public E last() {
		if(isEmpty())
			return null;
		
		return tail.getElement();
	}
	
	/**
	 * It allows you to add a new element at the top of the list, so now it will be the head.
	 * @param e the element of type E that you want to store in the new node you are going to add
	 */
	public void addFirst(E e) {
		head = new Node<> (e, head);
		
		if (size == 0)
			tail = head;
		
		size ++;
	}
	
	/**
	 * It allows you to add a new element at the button of the list, so now it will be the tail.
	 * @param e the element of type E that you want to store in the new node you are going to add
	 */
	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		
		if(isEmpty())
			head = newest;
		else
			tail.setNext(newest);
		
		tail = newest;
		size++;
	}
	
	/**
	 * It removes the head of the list and returns his element
	 * @return the element that is at the head of the list
	 */
	public E removeFirst() {
		if (isEmpty())
			return null;
		
		E answer = head.getElement();
		head = head.getNext();
		size--;
		
		if (size == 0)
			tail = null;
		
		return answer;
	}
}
