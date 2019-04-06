package Handler.Input;

import Config.Environment;
import DB.Storage;
import Utilities.XmlReader;

public class CourseHandler implements GeneralInputHandler{

    @Override
    public void handle() throws Exception{
        Storage db = Environment.database;
        XmlReader xmlReader = new XmlReader(Environment.configParameters.get(Environment.ParameterType.COURSE),true);
        String[] line = null;
        while( (line=xmlReader.readLine())!=null){
            if(line.length<3){
                continue;
            }

            try {
                int id = Integer.parseInt(line[0]);
                String name = line[1].trim();
                String teacher = line[2].trim();
                db.addCourse(id,name,teacher);
            }catch (Exception e){
                e.printStackTrace();
                continue;
            }


        }
        xmlReader.close();

    }
}
