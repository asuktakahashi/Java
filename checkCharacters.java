import java.io.*;

//---------テスト用コード　ここから---------------
class TestcheckCharacters{
	//args[0]で指定したテキストファイルを読み込み、checkCharactersメソッドへ渡し、結果を出力する
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
//---------テスト用コード　ここまで---------------
	
	

//--------------メソッド本体-------------------
public static boolean checkCharacters(String target){
	char[] charArray = target.toCharArray();
	int targetChar;
	
	for(char ch : charArray){
		try{
			byte[] bArray = String.valueOf(ch).getBytes("SJIS");	//SJISのバイトコード取得
 
			if (bArray.length == 1) {
				//1バイト文字を16進数へ
				targetChar = bArray[0] & 0xFF;
	 		} else {
				//2バイト文字を16進数へ
				targetChar = ((bArray[0] & 0xFF) << 8) | (bArray[1] & 0xFF);
			}
			
		} catch (UnsupportedEncodingException e){
			return false;
		}
		
		
		if((0x8140 <= targetChar) && (targetChar <= 0x9872)){ // 第一水準かチェック
				if((0x8148 == targetChar) || (0x81AC == targetChar)){ return false; } // 第一水準のなかで"？","〓"の場合は、falseを返す
			// 処理なし
		} 
		else if ((0x989F <= targetChar) && (targetChar <= 0xEAA4)){  // 第二水準かチェック
			//処理なし
		}	
		else if ((0xED40 <= targetChar) && (targetChar <= 0xEEFD)){  // IBM拡張文字かチェック
			// 処理なし
		}
		else {
			return false;
		}

	}
	return true;
}
//--------------メソッド本体ここまで----------------


}// <-- テスト用コード
