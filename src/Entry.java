
public class Entry {
	int key;
	String value;
	public Entry() {
		key = -1;
		value = "";
	}
	public Entry(int key) {
		this.key = key;
		value = "value of " + this.key;
	}
	public Entry(int key, String value) {
		this.key = key;
		this.value = value;
	}
	public boolean isEqual(Entry otherEntry) {
		if(this.key == otherEntry.key) {
			return true;
		}
		else return false;
	}
}