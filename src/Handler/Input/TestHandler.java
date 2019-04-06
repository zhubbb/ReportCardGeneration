package Handler.Input;

import Config.Environment;
import DB.Storage;
import Utilities.XmlReader;

public class TestHandler implements GeneralInputHandler {
    @Override
    public void handle() throws Exception {
        Storage db = Environment.database;
        XmlReader xmlReader = new XmlReader(Environment.configParameters.get(Environment.ParameterType.TEST),true);
        String[] line = null;
        while( (line=xmlReader.readLine())!=null){
            if(line.length<3){
                continue;
            }
            try {
                int id = Integer.parseInt(line[0]);
                int course_id = Integer.parseInt(line[1]);
                int weight = Integer.parseInt(line[2]);
                db.addTest(id,course_id,weight);
            }catch (Exception e){
                e.printStackTrace();
                continue;
            }



        }
        xmlReader.close();
    }
}
