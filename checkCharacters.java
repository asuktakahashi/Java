import java.io.*;

//---------テスト用コード　ここから---------------
class TestcheckCharacters{
	//arg[0]で指定したテキストファイルを読み込み、checkCharactersメソッドへ渡し、結果を出力する
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
			// 処理なし 		NEC選定IBM拡張文字は((0xFA40 <= targetChar) && (targetChar <= 0xFC40F))の範囲のため、チェック必要なし
		}
		else {
			return false;
		}

	}
	return true;
}
//--------------メソッド本体ここまで----------------







}// <-- テスト用コード











//-------------------------------------------------------------------------------------------------------------

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
	
		if((0x8140 <= targetChar) && (targetChar <= 0x9872)){	// 第一水準かチェック
				if(( 0x8148 == targetChar) || ( 0x819C == targetChar)){ return false; } // 第一水準のうち"？"と"〓"はfalse
			//処理なし
		} else if ((0x989F <= targetChar) && (targetChar <= 0xFC4B)){	// 第二水準かチェック
			//処理なし
		} else if ((0xFA40 <= targetChar) && (targetChar <= 0xFC40B)){	// IBM拡張文字かチェック
			//処理なし	NEC選定IBM拡張文字は((0xFA40 <= targetChar) && (targetChar <= 0xFC40F))の範囲のため、チェック必要なし
		}
		else {
			return false;
		}
		

	}
	return true;
}
//--------------メソッド本体ここまで----------------


}// <-- テスト用コード

		/*　　いただいた文字コード指定によるコーディング
		if((0x8140 <= targetChar) && (targetChar <= 0x9872)){ //16区～46区（第1水準）
				if((0x8148 == targetChar) || (0x819C == targetChar)){ return false; } //"？","〓"の場合は、falseを返す
			// 処理なし
		}
		else if((0x989F <= targetChar) && (targetChar <= 0xFC4B)){  //47区（第1、第3水準が混在）
				// if(第三水準){ return false; }
				//　switch(caseXXXX:){ return false; }
			// 処理なし
		}
		else if((0x989F <= targetChar) && (targetChar <= 0xEA9E)){  //48区～83区（第2水準）
			// 処理なし
		}
		else if((0xEA9F <= targetChar) && (targetChar <= 0xEA9E)){  //84区（第2、第3水準が混在）
				//if(第三水準){　return false;　}
				//　switch(caseXXXX:){ return false; }
			//　処理なし
		}
		else if((0xFA40 <= targetChar) && (targetChar <= 0xFC40B)){  // IBM拡張文字かチェック
			// 処理なし 		NEC選定IBM拡張文字は((0xFA40 <= targetChar) && (targetChar <= 0xFC40F))の範囲のため、チェック必要なし
		}
		else {
			return false;
		}
		*/

