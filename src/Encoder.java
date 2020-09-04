import java.util.*;
import java.io.*;

public class Encoder {
	private HashMap<String, Integer> encodingTable; //Stores all encodings in a HashMap
	
	/**
	 * Fills the Hashmap with all 255 single chars.
	 */
	public Encoder() {
		encodingTable = new HashMap<String, Integer>();
		for (int i = 0; i <= 255; i++) {
			encodingTable.put((char)i + "", i);
		}
	}
	
	public void Encode(String fileName, String outputFileName){
		try { 
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			File file = new File(outputFileName); //Create New File (if it doesn't already exist)
			if (!file.exists()) {
				file.createNewFile();
			}
			//FileWriter fw = new FileWriter (file);
			//BufferedWriter writer = new BufferedWriter (fw);
			PrintWriter pw = new PrintWriter(new File(outputFileName));
			
			int nextEncoding = 256;
			String next = (char)br.read() + "";
			while (br.ready()) {
				while (encodingTable.containsKey(next)) { //Check if in table, if it is, add next letter
					next+=br.read();
				}
				encodingTable.put(next, nextEncoding); //Add new codes to Hashmap
				nextEncoding++;
				//writer.write("" + encodingTable.get(next.substring(0, next.length()-1))); //write
				pw.print("" + encodingTable.get(next.substring(0, next.length()-1)));
				next = next.substring(next.length()-1); //reset
			}
			br.close();
			pw.close();
			//fw.close();
		//} 
		/**catch (Exception exe) {
				writer.write("" + encodingTable.get(next.substring(0, next.length()-1))); //write next code to output file
				next = next.substring(next.length()-1); //reset next to 1 character
			}
			br.close();
			fw.close();
			writer.close();*/
		} catch (Exception exe) { //catches any exceptions
			exe.printStackTrace();
		}
	}
}