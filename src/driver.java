
public class driver {

	public static void main(String[] args) {
		ElasticERL test = new ElasticERL(5000000);
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
		System.out.println(test.getValues("58673279"));
		//for(int i = 0; i < 5000; i++) {
		//	test.generate();
		//}
		
	}

}
