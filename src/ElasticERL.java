import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ElasticERL {
	int size;
	Scanner inputStream = null;
	LinkedList list;
	ElasticERL(){
		this.size = 10;
		try {
			inputStream = new Scanner(new FileInputStream("EHITS_test_file1.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Error opening File");
		}
		SetEinThreshold(size);
	}
	
	public void SetEinThreshold(int size){
		if(size <= 1000) {
			listBuilder();
		}
		if(size <=10000) {
			hashMapBuilder();
		}
		if(size > 10000) {
			AVLTreeBuilder();
		}
	}
	
	public LinkedList listBuilder() { 
		list = new LinkedList(inputStream);
		return list;
	}
	public void hashMapBuilder() {
		
	}
	public void AVLTreeBuilder() {
		
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
		n1 = list.find(Integer.parseInt(key));
		if(n1 == null)
			return "-1";
		else return n1.entry.value;
		
	}
	public int rangeKey(String key1, String key2) {
		int count = 0;
		Node startNode = list.find(Integer.parseInt(key1));
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
	public boolean remove(String key) {
		Node n = list.find(Integer.parseInt(key));
		if(n == null) {
			return false;
		}
		Node firstNode;
		Node secondNode;
		firstNode = n.head;
		secondNode = n.tail;
		firstNode.tail = secondNode;
		secondNode.head = firstNode;
		return true;
	}
	public void generate() {
		Random rnd = new Random();
		int key = (rnd.nextInt(100000000));
		if(list.find(key)== null) {
			list.add(Integer.toString(key));
		}
		else {System.out.println("Duplicate key generated. trying again");
			generate();
		}
		
		
	}
}
