
//import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ElasticERL {
	int size;
	Scanner inputStream = null;
	LinkedList list;
	HashMap hashmap;
	ElasticERL(int size){
		this.size = size;
		try {
			inputStream = new Scanner(new FileInputStream("EHITS_test_file1.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Error opening File");
		}
		SetEinThreshold(size);
	}
	/*
	 * size will determine data structures constructed as well as the methods used.
	 * 
	 * */	
	public void SetEinThreshold(int size){
		if(size <= 1000) {
			list = new LinkedList(inputStream, size);
		}
		if(size > 1000) {
			list = new LinkedList(inputStream, size);
			hashmap = new HashMap(512, .75f);
			hashmap.build(list);
			
		}
		
	}
	
	
	
	
	public void allKeys() {
		Node currentNode = list.head;
		while(currentNode.tail != null)//will skip last Node
		{
			System.out.println(currentNode.entry.key);
			currentNode = currentNode.tail;
		}
	}
	/**
	 * finds next key
	 * if the key entered does not exist in list returns -1
	 * if the key entered is the last node method returns -1
	 * @param key
	 * @return
	 */
	public int nextKey(String key) {
		if(list.find(Integer.parseInt(key)) == null) {
			return -1;
		}
		if(list.find(Integer.parseInt(key)).tail == null) {
			return -1;
		}
		else return list.find(Integer.parseInt(key)).tail.entry.key;
		
	}
	public int prevKey(String key) {
		if(list.find(Integer.parseInt(key)) == null) {
			return -1;
		}
		if(list.find(Integer.parseInt(key)).head == null) {
			return -1;
		}
		else return list.find(Integer.parseInt(key)).head.entry.key;
	}
	public String getValues(String key) {
		Node n1;
		long time = 0;
		if(size <= 1000) {
			//time = System.nanoTime();
			n1 = list.find(Integer.parseInt(key));
			//time = System.nanoTime() - time;
			//System.out.println(time);
			if(n1 == null)
				return "-1";
			else return n1.entry.value;
		}
		if(size >1000) {
	//		time = System.nanoTime();
			n1 = hashmap.find(Integer.parseInt(key));
	//		time = System.nanoTime() - time;
	//		System.out.println(time);
			if(n1!=null)
				return n1.entry.value;
			else return null;
		}
		else return null;
		
	}
	public int rangeKey(String key1, String key2) {
		int count = 0;
		Node startNode = null;
		if(size<=1000) {
			startNode = list.find(Integer.parseInt(key1));
		}
		else if(size > 1000) {
			startNode = hashmap.find(Integer.parseInt(key1));
		}
			
			if(startNode == null)
				return -1;
			do {
				if(startNode.entry.key == Integer.parseInt(key2))
					return count-1;
				startNode = startNode.tail;
				count++;
				
			}while(startNode != null);
			return -1;
		}
		
			
		
	/**
	 * will remove Node from linked List
	 * and will also remove Node from hashmap if size is >1000
	 * @param key
	 * @return
	 */
	public boolean remove(String key) {
		Node n = null;
		if(size <= 1000)
			n = list.find(Integer.parseInt(key));
		if(size > 1000)
			n = hashmap.find(Integer.parseInt(key));
		if(n == null) {
			return false;
		}
		Node firstNode = null;
		Node secondNode = null;
		if(n.head != null && n.tail!= null) {
			firstNode = n.head;
			secondNode = n.tail;
			firstNode.tail = secondNode;
			secondNode.head = firstNode;
		}
		if(n.head == null && n.tail !=null) {
			list.head = n.tail;
		}
		if(n.head == null && n.tail == null) {
			list.head = null;
		}
		if(n.head!= null&& n.tail == null) {
			n.head.tail = null;
		}
		if(size>1000) {
			hashmap.remove(n);
			
		}
		return true;
	}
	/**
	 * will generate a new key and check if it already exists.
	 * adds it to chronological list. adds it to hashmap as well if size > 1000
	 */
	public void generate() {
		Random rnd = new Random();
		int key = (rnd.nextInt(100000000));
		if(size <= 1000) {
		if(list.find(key)== null) {
			list.add(Integer.toString(key));
		}
		else {System.out.println("Duplicate key generated. trying again");
			generate();
		}
		}
		if(size > 1000) {
			if(hashmap.find(key) == null) {
				list.add(Integer.toString(key));
				hashmap.put(list.head);
			}
		}
		
		
	}
}
