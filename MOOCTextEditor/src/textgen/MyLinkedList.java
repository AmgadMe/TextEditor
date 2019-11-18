package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>(null);

		tail = new LLNode<E>(null);

		size = 0;

		head.next = tail;

		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element==null)

		{

			throw new NullPointerException("Element cannot be null.");

		}

		

		try {
		LLNode<E> newNode = new LLNode<E>(element);

		LLNode<E> prev = tail.prev;

		prev.next = newNode;

		newNode.prev = prev;

		newNode.next = tail;

		tail.prev = newNode;

		size++;
		return true;
		}
		catch (Exception e) {

			return false;
		}
		
		
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index<0 || index>= size)

		{

			throw new IndexOutOfBoundsException("The index is out of bounds");

		}
		
		else

		{
		LLNode<E> current = head.next;

		for(int i = 0; i < index; i++){
			current = current.next;
			
		}
		
	return current.data;
		}
		
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (element == null){

			throw new NullPointerException("Parameter Type cannot be null");

		}

		if (index < 0){

			throw new IndexOutOfBoundsException("Out of Bounds");

		}

		if (index > size){

			throw new IndexOutOfBoundsException("Out of Bounds");

		}

		LLNode<E> newNode = new LLNode<E>(element);

		LLNode<E> current = head;

		for(int i = 0; i <= index; i++){

			current = current.next;

		}

		LLNode<E> prev = current.prev;

		prev.next = newNode;

		newNode.prev = prev;

		newNode.next = current;

		current.prev = newNode;

		size += 1;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index<0 || index>= size)

		{

			throw new IndexOutOfBoundsException("The index is out of bounds");

		}

		

		else

		{
		LLNode<E> current = head.next;

		for(int i = 0; i < index; i++){
			current = current.next;
			
		}
		E data = current.data;

		current.prev.next = current.next;

		current.next.prev = current.prev;

		size--;

		return data;
		}
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (element == null){

			throw new NullPointerException("Parameter Type cannot be null");

		}

		if (index < 0){

			throw new IndexOutOfBoundsException("Out of Bounds");

		}

		if (index > size){

			throw new IndexOutOfBoundsException("Out of Bounds");

		}

		LLNode<E> current = head;

		for(int i = 0; i < index; i++){

			if(current.next == null){

				return null;

			}

			current = current.next;

		}

		E toReturn = current.next.data;

		current.next.data = element;

		return toReturn;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
