import java.io.*;

public class EditTextFilesRecursively{
  public void readDirectory(File dir){
    File files[] = dir.listFiles();
    if( files = null){ return; }
    
    for(File file: fles){
      if(!file.exists())
        continue;
      else if(file.isDirectory())
        readDirectory(file)
      else if(file.isFile())
        excute(file);
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
