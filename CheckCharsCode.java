import java.io.*;

//---------for test　from here---------------
class TestCheckCharacters{
	//read test data in .txt and print results
	public static void main(String args[]){
		String thisLine;

		try{
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			while((thisLine = br.readLine())!= null){
				boolean result = checkCharacters(thisLine);
				System.out.println(thisLine + " => " + result);
			}
		} catch(IOException e) {
			System.err.println(e);
		}
	}
//---------for test to here---------------
	
	

//--------------method-------------------
public static boolean CheckCharacters(String target){
	char[] charArray = target.toCharArray();
	int targetChar;
	
	for(char ch : charArray){
		try{
			byte[] bArray = String.valueOf(ch).getBytes("SJIS");	//get SJIS byte code
 
			if (bArray.length == 1) {
				//1 byte
				targetChar = bArray[0] & 0xFF;
	 		} else {
				//2 bytes
				targetChar = ((bArray[0] & 0xFF) << 8) | (bArray[1] & 0xFF);
			}
			
		} catch (UnsupportedEncodingException e){
			return false;
		}
		
		
		if((0x8140 <= targetChar) && (targetChar <= 0x9872)){ // check if the first level
				if((0x8148 == targetChar) || (0x81AC == targetChar)){ return false; } // exclude individual chars
			// no process
		} 
		else if ((0x989F <= targetChar) && (targetChar <= 0xEAA4)){  // check if the second level
			//no process
		}	
		else if ((0xED40 <= targetChar) && (targetChar <= 0xEEFD)){  // check if the IBM extended chars
			// no process
		}
		else {
			return false;
		}

	}
	return true;
}
//--------------method----------------


}// <-- for test
