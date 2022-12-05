
public class Node {
	Entry entry;
	Node head;
	Node tail;
	Node secondaryHead;
	Node secondaryTail;
	
	public Node() {
		entry = null;
		head = null;
		tail = null;
		secondaryHead = null;
		secondaryTail = null;
	}
	public Node(Entry entry) {
		this.entry = entry;
		
	}
	public Node(Entry entry, Node head) {
		this.entry = entry;
		this.tail = head;
		
	}
	public void setHead(Node newHead) {
		this.head = newHead;
	}
	public void setSecondaryHead(Node secondaryHead) {
		this.secondaryHead = secondaryHead;
	}
	

}
