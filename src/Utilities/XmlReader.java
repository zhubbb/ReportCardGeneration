package Utilities;

import Config.Environment;

import java.io.*;

public class XmlReader{
    BufferedReader reader;
    public XmlReader(String fileName,boolean skipTitle) throws IOException {

        reader = new BufferedReader(new FileReader(fileName));

        if(skipTitle){
            readLine();
        }
    }


    public String[] readLine() throws IOException {
        String line = reader.readLine();
        if(line!=null){
//            String[] res = line.split(Environment.splitter);
            return line.split(Environment.splitter);
        }else{
            return null;
        }

    }
    public void close() throws IOException{
        reader.close();
    }
}
