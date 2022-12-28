import java.io.BufferedReader;
import java.io.FileReader;

public class HashTable{
	Node[] hashTable;
	int max;
	public Integer[] keys;

	public class Node{
		Integer code;
		Integer pop;
		String name;
		Node next;

		public Node(Integer code, String name, Integer pop){
			this.code = code;
			this.pop = pop;
			this.name = name;
			this.next = null;
		}

		public String print(){
			if(code == null)
				return "null";
			return code + " " + name + pop.toString();
		}
	}

	public Integer getHashCode(Integer zipCode, Integer mod){
		return zipCode % mod;
	}

	public void insertLinked(Node node, Integer mod){
		Integer index = getHashCode(node.code, mod);
		if(hashTable[index] == null)
			hashTable[index] = node;
		else{
			Node current = hashTable[index];

			while(current.next != null)
				current = current.next;

			current.next = node;
		}
	}

	public void insert(Node node, Integer mod){
		Integer index = getHashCode(node.code, mod);

		if(hashTable[index] == null)
			hashTable[index] = node;
		else{
			for(int i = 1; i < hashTable.length; i++){
				if(hashTable[index + i] == null){
					//System.out.println("Collision, code: "+node.code+" mod: "+index+" dist: "+i+" new index: "+(index+i));
					hashTable[index + i] = node;
					return;
				}
			}
			System.out.println("Not able to add element.");
		}
 	}

	public HashTable (String file, Integer mod){
		hashTable = new Node[mod]; 
		keys = new Integer[9674];

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			int i = 0;
			int j = 0;

			while ((line = br.readLine()) != null) {
				String[] row = line.split(",");
				Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
				keys[j++] = code; // Adding to test lookup average for hash. 

				Node newNode = new Node(code, row[1], Integer.valueOf(row[2]));
				//insertLinked(newNode, mod);
				//System.out.println(newNode.print()+" mod: "+(newNode.code%24_877)+", ");
				insert(newNode, mod);
			}
			max = i-1;
		} 	
		catch (Exception e) {
			//System.out.println(" file " + file + " not found");
		}
	}

	public Integer emptyCount(){
		Integer count = 0;
		for(int i = 0; i < hashTable.length; i++){
			if(hashTable[i] == null)
				count++;
		}
		return count;
	}

	public void collisions(int mod) {
		int[] data = new int[mod];
		int[] cols = new int[10];

		for (int i = 0; i < max; i++) {
			Integer index = keys[i] % mod;
			cols[data[index]]++;
			data[index]++;
		}
		System.out.print("mod: "+mod+",");
		
		System.out.print("\nunique: ");
		for (int i = 0; i < 10; i++) {
			System.out.print(cols[i]+"\n");
			if(i<9)
				System.out.print(" "+(i+1)+" col: ");
		}
		System.out.println();
	}

	public void printLinkedLists(Integer mod){
		for(int i = 0; i < hashTable.length; i++){
			if(hashTable[i] != null && hashTable[i].next != null){

				Node print = hashTable[i];
				while(print != null){
					System.out.print(print.print()+" mod: "+(print.code % mod)+", ");
					print = print.next;
				}
				System.out.println("\nNew linked: ");
			}
		}
	}

	public void printList(Integer mod){
		for(int i = 0; i < hashTable.length; i++){
			if(hashTable[i] == null){
				System.out.println("null, ");
				i++;
			}
			else
				System.out.println(hashTable[i].print()+" mod: "+(hashTable[i].code % mod)+", ");
		}
	}

	public Integer lookup(Integer code, Integer mod){
		Integer index = getHashCode(code, mod);
		Integer count = 1;
		if(hashTable[index].code.equals(code)){
			return count; //Found
		}
		for(int i = index + 1; i < hashTable.length; i++){
			count++;
			if(hashTable[i].code.equals(code)){
				return count; //Found after several comparisons
			}
		}
		return null;
	}

	public Integer lookupLinked(Integer code, Integer mod){ // Only works for valid codes
		Integer index = getHashCode(code, mod);
		Integer count = 1;
		if(hashTable[index].code.equals(code))
			return count;

		else if(hashTable[index].next != null){
			Node current = hashTable[index].next;

			while(current != null){
				count++;
				if(current.code.equals(code))
					return count;
				current = current.next;
			}
		}
		return null;
	}

	public static void linkedBench(){
		int[] mods =  {10_000, 15_000, 20_000, 25_000, 30_000, 35_000, 40_000, 45_000, 50_000, 55_000, 60_000, 87_380, 87_381};

		for(int n : mods){
			HashTable benchHash = new HashTable("postnummer.csv", n);

			System.out.printf("%8d", n);

			double average = 0.0;

			for(int i = 0; i < benchHash.keys.length; i++){
				average += (double) benchHash.lookupLinked(benchHash.keys[i], n);
			}

			System.out.printf(" %.9f\n", (double)(average/9674));
		}

	}

	public static void bench(){
		int[] mods =  {15_000, 20_000, 25_000, 30_000, 35_000, 40_000, 45_000, 50_000, 55_000, 60_000, 87_380, 87_381};

		for(int n : mods){
			HashTable benchHash = new HashTable("postnummer.csv", n);

			System.out.printf("%8d", n);

			double average = 0.0;

			for(int i = 0; i < benchHash.keys.length; i++){
				average += (double) benchHash.lookup(benchHash.keys[i], n);
			}

			System.out.printf(" %.9f\n", (double)(average/9674));
		}

	}

	public static void main(String[] args){
		Integer mod = 24_877;

		HashTable hash = new HashTable("postnummer.csv", mod);

		//System.out.println("Empty count: "+hash.emptyCount());
		//System.out.println("Count: "+hash.lookup(98_065, mod));

		// CHANGE INSERT PLEASE
		//for(int i = 0; i < hash.keys.length; i++)
		//	average += hash.lookup(hash.keys[i], mod);

		//System.out.println("Average distance linear: "+(double)(average/9674));

		// CHANGE TO INSERTLINKED PLEASE
		//for(int i = 0; i < hash.keys.length; i++){
		//	average += hash.lookupLinked(hash.keys[i], mod);
		//}

		//System.out.println("Average distance linked: "+(double)(average/9674));

		
		//linkedBench();
		bench();
	}


}


/*




*/
