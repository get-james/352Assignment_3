import java.util.Scanner;

public class LinkedList {
	Node head;
	Node tail;
	int size = 0;
	public LinkedList() {
		
	}
	public LinkedList(Scanner inputStream) {
		if(inputStream.next() != null);
			head = new Node(new Entry(Integer.parseInt(inputStream.next())));
		while(inputStream.hasNext() && size <=10) {
			add(inputStream.next());
			size++;	
		}
	
		
	}
	/**
	 * creates an Entry object and pass it into Node constructor.
	 * sets the headlink of the old head to the new node
	 * sets the new Node as the head of the LL\
	 * old head is passed into new node constructor and is set as its tail
	 * @param key
	 */
	public void add(String key) {//
		Entry newEntry = new Entry(Integer.parseInt(key));
		Node newNode = new Node(newEntry, head);
		head.setHead(newNode);
		head = newNode;
		
	}
	/**
	 * iterates through list until it either finds and returns Node with key or gets to the end and returns null
	 * @param key
	 * @return
	 */
	public Node find(int key) {
		Node currentNode = head;
		
		do {
			if(currentNode.entry.key == key)
				return currentNode;
			currentNode = currentNode.tail;
			
		}while(currentNode != null);
		return null;
	}
}
