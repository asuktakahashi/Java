import java.io.UnsupportedEncodingException;

//---------テスト用　ここから---------------
class TestcheckCharacters{
	public static void main(String args[]){
		boolean result = checkCharacters("あいうえお順");	//テスト対象文字列を入れる箇所
		System.out.println(result);
	}
//---------テスト用　ここまで---------------
	
	
	


public static boolean checkCharacters(String target){
	char[] charArray = target.toCharArray();
	int targetChar;
	
	for(char ch : charArray){
		try{
			byte[] bArray = String.valueOf(ch).getBytes("Windows-31J");
 
			if (bArray.length == 1) {
				//1バイト文字
				targetChar = bArray[0] & 0xFF;
	 		} else {
				//2バイト文字
				targetChar = ((bArray[0] & 0xFF) << 8) | (bArray[1] & 0xFF);
			}
			
		} catch (UnsupportedEncodingException e){
			return false;
		}
		
		
		if((0x8140 <= targetChar) && (targetChar <= 0x9872)){ // 第一水準かチェック
				if(( 0x8148 == targetChar) || ( 0x81AC == targetChar)){ return false; } // 第一水準のなかで"？","〓"の場合は、falseを返す
			/* 処理なし	*/
		} else if ((0x989F <= targetChar) && (targetChar <= 0xFC4B)){ // 第二水準かチェック
			/* 処理なし	*/
		} else if ((0xFA40 <= targetChar) && (targetChar <= 0xFC40B)){ // IBM拡張文字かチェック
			/* 処理なし	*/
		}
		else {
			return false;
		}

	}
	return true;
}








}// <-- テスト用
