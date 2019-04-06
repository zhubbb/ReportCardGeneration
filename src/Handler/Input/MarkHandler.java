package Handler.Input;

import Config.Environment;
import DB.Storage;
import Utilities.XmlReader;

public class MarkHandler implements GeneralInputHandler{


    @Override
    public void handle() throws Exception {
        Storage db = Environment.database;
        XmlReader xmlReader = new XmlReader(Environment.configParameters.get(Environment.ParameterType.MARK),true);
        String[] line = null;
        while( (line=xmlReader.readLine())!=null){
            if(line.length<3){
                continue;
            }
            try {
                int test_id = Integer.parseInt(line[0]);
                int student_id = Integer.parseInt(line[1]);
                double mark = Double.parseDouble(line[2]);
                db.addMark(test_id,student_id,mark);
            }catch (Exception e){
                e.printStackTrace();
                continue;
            }



        }
        xmlReader.close();
    }
}
