
public class driver {

	public static void main(String[] args) {
		ElasticERL test = new ElasticERL(2000000);
		long time = 0;
		/*test.allKeys();
		System.out.println(test.nextKey("33274249")); //86148178
		System.out.println(test.prevKey("86148178"));
		System.out.println(test.getValues("33266743"));
		System.out.println(test.rangeKey("33274249", "33266743"));
		test.remove("15485764");
		test.allKeys();
		System.out.println(test.prevKey("33219288"));
		for(int i = 0; i< 30; i++) {
			test.generate();*/
		//}
	//test.allKeys();
	//System.out.println(test.getValues("33218161"));
	//test.remove("33218161");
	//System.out.println(test.getValues("33218161"));
	//System.out.println();
	//test.allKeys();
		
	//	System.out.println("timing stuff: \n\n");
	
		
	/*	for(int i = 0; i < 9999999; i++) {
			test.generate();
		}
		*/
		time = System.nanoTime();
		System.out.println("Time to get 50000 value from key in Hashmap of Size " + test.hashmap.mappingCount);
		Node n = test.list.head;
		int count = 0;
		time = System.nanoTime();
		while(n != null && count <=50000) {
			test.getValues(n.entry.key);
			count++;
			n = n.tail;
		}
		System.out.println(System.nanoTime() - time);
		System.out.println();
		System.out.println("1 value from hashmap");
		time = System.nanoTime();
		System.out.println(test.getValues(58673279));
		System.out.println(System.nanoTime() - time);
		System.out.println();
		
		
		System.out.println("Time to get value from key in List of Size " + test.list.size);
		time = System.nanoTime();
		System.out.println(test.list.find(58673279).entry.value);
		System.out.println(System.nanoTime() - time);
		
		
	}

}
