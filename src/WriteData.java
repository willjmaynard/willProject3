
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
//
//public class WriteData {
//	private String filename;
//	private ArrayCoinOrder<Crypto> coins;
//	
//	public WriteData(String filename, ArrayCoinOrder<Crypto> coins) {
//		// TODO Auto-generated constructor stub
//		this.filename = filename;
//		this.coins = coins;
//	}
//	
//	public void write() throws FileNotFoundException {
//		PrintWriter myWriter = new PrintWriter(filename);
//		myWriter.println("[");
//		for(int i = 0; i < coins.size(); i++) {
//			myWriter.println("\t{");
//			myWriter.println(coins.get(i));
//			myWriter.print("\t}");
//			if(i!=coins.size()-1)
//				myWriter.println(",");
//		}
//		myWriter.println(System.getProperty("line.separator") +"]");
//		myWriter.close();
//	}
//}