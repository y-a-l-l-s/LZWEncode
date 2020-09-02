import java.util.*;
import java.io.*;

public class Encoder {
	private HashMap<String, Integer> encodingTable; //Stores all encodings in a HashMap
	private String output; //Final code
	
	/**
	 * Fills the Hashmap with all 255 single chars.
	 */
	public Encoder() {
		encodingTable = new HashMap<String, Integer>();
		for (int i = 0; i < 255; i++) {
			encodingTable.put((char)i + "", i);
		}
	}
	
	public void Encode(String FileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(FileName));
		private int c = 256;
		
		while (!br.ready()) {
			String next = br.read();
			while (encodingTable.containsKey(next)) {
				next+=br.read();
			}
			ecodingTable.put (next, c);
			c++;
			
			output+= ""+ (String) encodingTable.get(next.substring(0, length()-1));
			
			next = next.substring(next.length()-1);
		}
	}
}