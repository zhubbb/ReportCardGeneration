package Handler.Input;

import Config.Environment;
import Utilities.XmlReader;

import java.nio.file.Paths;

public class ConfigHandler implements GeneralInputHandler{
    @Override
    public void handle() throws Exception {
        XmlReader xmlReader = new XmlReader( Paths.get(Environment.configDataPath).toAbsolutePath().toString(),false);
        String[] line = null;

        while( (line=xmlReader.readLine())!=null){
            if(line.length<2){
                continue;
            }

            String name = line[0].trim().toUpperCase();
            String path = line[1].trim();
            Environment.configParameters.put(Environment.ParameterType.get(name), path);

        }
        xmlReader.close();
    }

}
