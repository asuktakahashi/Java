import java.io.*;

public class EditTextFilesRecursively{
  public void readDirectory(File dir){
    File files[] = dir.listFiles();
    
    for(File file: files){
      if(file.isDirectory()){
        readDirectory(file)         // call itself when directory
      } else if(file.isFile()){
        execute(file);              // execute the process when file
      }
    }

  }
  
  
  public void execute(File file){ 
    try{
      
      BufferedReader br = new BufferedReader(new FileReader(file));
      BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"));
      
      String line;
      while((line = br.readLine()) != null){
        bw.write(line);
        bw.newLine();
      }
      
      bw.close();
      br.close();
    
    } catch(Exception e) {
      System.err.println(e);
    }
  }


  public static void main(String args[]){
    new EditTextFilesRecursively().readDirectory(new File("C:¥workspace¥"));
  }
}
