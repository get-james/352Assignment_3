import java.util.Scanner;

public class HashMap {
	private LinkedList[] buckets;
	
	private int mappingCount = 0;
	private int capacity; 
	private float loadFactor = 0.75f;
	public HashMap() {
		
	}
    public HashMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.buckets = new LinkedList[capacity];
        for (int i = 0; i < this.buckets.length; i++) {
            this.buckets[i] = new LinkedList();
        }
    }
    //public void add()


	 public void build(LinkedList list) {
		 Node node = list.head;
		 while(node!=null) {
			 put(node);
			 node = node.tail;
		 }
		 
	 }
		
	
		
	   
	   private int getHash(int key) {
		   return key % capacity;
	   }
	   public boolean remove(Node n) {
		   Node firstNode = null;
			Node secondNode = null;
	   
		   if(n.secondaryHead != null && n.secondaryTail != null) {
				firstNode = n.secondaryHead;
				secondNode = n.secondaryTail;
				firstNode.secondaryTail = secondNode;
				secondNode.secondaryHead = firstNode;
				return true;
				}
				if(n.secondaryHead == null && n.secondaryTail != null) {
					this.buckets[getHash(n.entry.key)].head = n.secondaryTail;
					return true;
				}
				if(n.secondaryHead == null && n.secondaryTail == null) {
					this.buckets[getHash(n.entry.key)] = null;
					return true;
				}
				if(n.secondaryHead!=null && n.secondaryTail==null) {
					n.secondaryHead.secondaryTail = null;
				}
				return false;
					
	   }
	   public void put(Node node) {
		  buckets[getHash(node.entry.key)].add(node);
		  mappingCount++;
		  checkForRehash();
	   }
	   public Node find(int key) {
		  Node n = buckets[getHash(key)].head;
		  if(n!=null) {
		  do {
				if(n.entry.key == key)
					return n;
				n = n.secondaryTail;
				
			}while(n != null);
			return null;
		  
		  }
		  return null;
	   }
	   private void checkForRehash() {
	        if (this.mappingCount > capacity * loadFactor) {
	            System.out.println("Rehashing from "+capacity+ " to "+capacity * 2);
	            mappingCount = 0;
	            // keep a reference to the old buckets, cause we need to re-insert those entries into the new map
	            // after doubling the capacity
	            LinkedList[] oldBuckets = this.buckets;
	            int oldCapacity = this.capacity;

	            // Increase our capacity, double it
	            capacity *= 2;
	            this.buckets = new LinkedList[capacity];

	            // Initialize our new bucket lists.
	            for (int i = 0; i < this.buckets.length; i++) {
	                this.buckets[i] = new LinkedList();
	            }
	            //copy over
	            for(int i = 0; i < oldBuckets.length;i++) {
	            	LinkedList oldList = oldBuckets[i];
	            	Node node = oldList.head;
	            	Node n2 = null;
	            	
	            		
	            	while(node!=null) {
	            		n2 = node.secondaryTail;
	            		this.put(node);
	            		node = n2;
	            	}
	            }
	        }
	   }
}