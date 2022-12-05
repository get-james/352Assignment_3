
public class driver {

	public static void main(String[] args) {
		ElasticERL test = new ElasticERL();
		test.allKeys();
		System.out.println(test.nextKey("33274249")); //86148178
		System.out.println(test.prevKey("86148178"));
		System.out.println(test.getValues("33266743"));
		System.out.println(test.rangeKey("33274249", "33266743"));
		test.remove("15485764");
		test.allKeys();
		System.out.println(test.prevKey("33219288"));
		for(int i = 0; i< 30; i++) {
			test.generate();
		}
		test.allKeys();
	}

}
