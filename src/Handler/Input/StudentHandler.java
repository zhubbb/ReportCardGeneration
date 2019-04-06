package Handler.Input;

import Config.Environment;
import DB.Storage;
import Utilities.XmlReader;



public class StudentHandler implements GeneralInputHandler{

    @Override
    public void handle() throws Exception {
        Storage db = Environment.database;
        XmlReader xmlReader = new XmlReader(Environment.configParameters.get(Environment.ParameterType.STUDENT),true);
        String[] line = null;
        while( (line=xmlReader.readLine())!=null){
            if(line.length<2){
                continue;
            }
            try {
                int id = Integer.parseInt(line[0]);
                String name = line[1];

                db.addStudent(id, name);
            }catch (Exception e){
                e.printStackTrace();
                continue;
            }
        }
        xmlReader.close();
    }
}
