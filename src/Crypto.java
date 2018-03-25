

public class Crypto extends Pair {

	
	Pair [] fields = new Pair[16];
	int count = 0;
	
	public Crypto() {}
	
	
	public void add(Pair p) {
		if (p == null) {
			return;
		}
		fields[count] = p;
		count++;
	}
	
	public String toString() {
		String current = "\t{\n";
		for (int i = 0; i < count; i++) {
			current = current + ("\t" + fields[i].name + ": " + fields[i].value + "\n");
		}
		current = current + "\t},\n";
		return current;
	}


	
	
	
	
}
