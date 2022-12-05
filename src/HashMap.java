import java.util.Scanner;

public class HashMap {
	private LinkedList[] buckets;
	public LinkedList chronolist;
	private int mappingcount;
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


	   public void build(Scanner inputStream) {
		
	
		if(inputStream.next() != null);
			chronolist = new LinkedList(new Node(new Entry(Integer.parseInt(inputStream.next()))));
		while(inputStream.hasNext()) {
			chronolist.add(inputStream.next());
			chronolist.size++;	
		}
	   }
}