//Code segments retrieved from stack overflow

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class ReadData {
	public static Scanner user;
	static //public static Crypto[] coins = new Crypto[2000];
	DoublyLinkedList<Crypto> LinkedCoins = new DoublyLinkedList<Crypto>(); //?
	public static void main(String[] args) {


		
		int count = 0;

		String file = "[";

		//ConvertDate con = new ConvertDate();
		Scanner in;
		
	
		
		try {
			System.out.println("Please enter the file name you wish to scan: ");
			user= new Scanner(System.in);
			String readIn = user.nextLine();
			in = new Scanner(new File(readIn));
			System.out.println("Please enter the name of the value you wish to sort the linked list by: ");
			String choice = in.nextLine().toLowerCase();
			
			String line = in.nextLine();
			//System.out.println(line);
			if (!line.contains("[")) {
				throw new FileNotFoundException();
			}
			else{
				line = in.nextLine();
				
			}

			while(!line.contains("]")) {
				if(line.contains("{")) {
					line = in.nextLine();
					LinkedCoins.size =  new Crypto(); //NEED HELP
					count++;
					while(!line.contains("}")) {
						String [] parts = line.split(":");
						if (parts.length != 2) {
							throw new NoSuchFieldException();
						}
						if (parts[1].contains("null")) {
							line = in.nextLine();
							continue;
						}
						if(parts[0].equals("        \"last_updated\"")) {
							parts[1] = new ConvertDate().convert(parts[1].replaceAll("\"", "").replaceAll(",", "").replaceAll(" ", ""));
							parts[1] = "\"" + parts[1] + "\",";
						}
						
						Pair p = new Pair(parts[0],parts[1]);
						LinkedCoins.add((Crypto) p); //NEED HELP
						line = in.nextLine();
						
					}
					
					Pair p = new Pair("\t\t\"counts\"",new CreateCounts().create(LinkedCoins.get(count-1)));
					LinkedCoins.add((Crypto) p);
					
					
					file = file + LinkedCoins.toString();
					line = in.nextLine();
				}

			}
			System.out.println("Please enter 'name', 'symbol', or 'max_supply' to sort the linked list: ");
			switch(choice) { 
			case "name":
				for (int i = 0; i < count; i++) {
					//DoublyLinkedList<Crypto> LinkedCoins = new DoublyLinkedList<Crypto>();
				}
				break;
			case "symbol":
				for (int i = 0; i < count; i++) {
					//DoublyLinkedList<Crypto> LinkedCoins = new DoublyLinkedList<Crypto>();
				}
				break;

			case "max_supply":
				for (int i = 0; i < count; i++) {
					//DoublyLinkedList<Crypto> LinkedCoins = new DoublyLinkedList<Crypto>();
				}
				break;
		
			default:
	             System.out.println("User entered incorrect key.");
	             break;
	
			}
			file = file + "]";
			sort(count);
			System.out.println("Please input S for search, D for remove, W for print, and E for exit");
			String input=user.nextLine().toLowerCase();
			
			
			switch(input) {
            case "s":
                search(count);
                break;
            case "d":
                remove(count);
                break;
            case "w":
            		System.out.println("Please enter the name of the file you wish to write to or return to print to console. ");
            		String FileName=user.nextLine();
            			PrintWriter myWriter = new PrintWriter(FileName);
            			myWriter.println("[");
            			for(int i = 0; i < count; i++) {
         
            				myWriter.println(LinkedCoins.get(i));
         
            				if(i==count-1) {
            					myWriter.println(",");
            					myWriter.println(System.getProperty("line.separator") +"]");
            					myWriter.close();
            				}
            			 }
						
                break;
            case "e":
                System.exit(0);
                break;
            default:
                System.out.println("User entered incorrect key.");
                break;
              
            }
					
				
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	private static void remove(int count) {
System.out.println("Please enter sym for Symbol search or nam for Name search: ");
		
		String select = user.nextLine().toLowerCase();
		if (select.equals("sym")) {
			System.out.println("Enter the value for the Symbol: ");
			String Symbol = user.nextLine().toLowerCase();
			for (int i = 0; i < count; i++) {
				//System.out.println(coins[i].fields[2].value.toLowerCase().replace("\"", "").replaceAll(",", "").replaceAll(" ", ""));
				if (Symbol.equals(LinkedCoins.get(i).fields[2].value.toLowerCase().replace("\"", "").replaceAll(",", "").replaceAll(" ", ""))) {
					System.out.println(LinkedCoins.get(i).toString());
				  	System.out.println("Would you like to remove this coin? type y for yes or n for no");
				  	String YN = user.nextLine().toLowerCase();
				  	if(YN.equals("y")) {
				  		LinkedCoins.delete(LinkedCoins.get(i));
				  		System.out.println("Coin Removed");
				  	}else 
				  		System.out.println("Coin Remains");
				  		break;
				}
			}
		}
		else if (select.equals("nam")) {      // retrieved from https://stackoverflow.com/questions/32260445/implementing-binary-search-on-an-array-of-strings
			System.out.println("Enter the value for the Name: ");
			String Name= user.nextLine().toLowerCase();
			int low = 0;
	        int high = count - 1;
	        int mid;

	        while (low <= high) {
	            mid = (low + high) / 2;

	            if (LinkedCoins.get(mid).fields[1].value.replaceAll("\"", "").replaceAll(" ", "").replaceAll(",", "").toLowerCase().compareTo(Name) < 0) {
	                low = mid + 1;
	            } else if (LinkedCoins.get(mid).fields[1].value.replaceAll("\"", "").replaceAll(" ", "").replaceAll(",", "").toLowerCase().compareTo(Name) > 0) {
	                high = mid - 1;
	            } else {
	            	System.out.println(LinkedCoins.get(mid).toString());
	            	System.out.println("Would you like to remove this coin? type y for yes or n for no");
	            	String YN = user.nextLine().toLowerCase();
	            	if(YN.equals("y")) {
	            		LinkedCoins.delete(LinkedCoins.get(mid));
	            		System.out.println("Coin Removed");
	            	}else 
	            		System.out.println("Coin Remains");
	            	break;
	            }
	        }
		
		}else if (!select.equals("sym") && !select.equals("nam")){
			System.out.println("You have entered the wrong value");
			return;
		}		
	}
	private static void search(int count) {
		System.out.println("Please enter sym for Symbol search or nam for Name search: ");
		
		String select = user.nextLine().toLowerCase();
		if (select.equals("sym")) {
			System.out.println("Enter the value for the Symbol: ");
			String Symbol = user.nextLine().toLowerCase();
			for (int i = 0; i < count; i++) {
				//System.out.println(coins[i].fields[2].value.toLowerCase().replace("\"", "").replaceAll(",", "").replaceAll(" ", ""));
				if (Symbol.equals(LinkedCoins.get(i).fields[2].value.toLowerCase().replace("\"", "").replaceAll(",", "").replaceAll(" ", ""))) {
					System.out.println(LinkedCoins.get(i).toString());
				}
			}
		}
		else if (select.equals("nam")) {      // retrieved from https://stackoverflow.com/questions/32260445/implementing-binary-search-on-an-array-of-strings
			System.out.println("Enter the value for the Name: ");
			String Name= user.nextLine().toLowerCase();
			int low = 0;
	        int high = count - 1;
	        int mid;

	        while (low <= high) {
	            mid = (low + high) / 2;

	            if (LinkedCoins.get(mid).fields[1].value.replaceAll("\"", "").replaceAll(" ", "").replaceAll(",", "").toLowerCase().compareTo(Name) < 0) {
	                low = mid + 1;
	            } else if (LinkedCoins.get(mid).fields[1].value.replaceAll("\"", "").replaceAll(" ", "").replaceAll(",", "").toLowerCase().compareTo(Name) > 0) {
	                high = mid - 1;
	            } else {
	            	System.out.println(LinkedCoins.get(mid).toString());
	            	break;
	            }
	        }
		
		}else if (!select.equals("sym") && !select.equals("nam")){
			System.out.println("You have entered the wrong value");
			return;
		}
		
	}
	
	public static void sort(int count) {
        Crypto temp; 
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++){
                if (LinkedCoins.get(i).fields[0].value.compareTo(LinkedCoins.get(j).fields[0].value)>0) {
                    temp = LinkedCoins.get(i);
                    LinkedCoins.get(i).;   //HLEP
                    LinkedCoins.get(j) = temp; //Help
                }
            }
        }
    }
	
}
	
