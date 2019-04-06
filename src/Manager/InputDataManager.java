package Manager;

import Handler.Input.*;

public class InputDataManager {
    CourseHandler courseHandler = new CourseHandler();
    StudentHandler studentHandler = new StudentHandler();
    TestHandler testHandler = new TestHandler();
    MarkHandler markHandler = new MarkHandler();
    ConfigHandler configHandler = new ConfigHandler();

    public void readConfig(){
        //read config
        try {
            configHandler.handle();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void readData(){


        //read all student first
        try {
            studentHandler.handle();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        //then read all course data
        try {
            courseHandler.handle();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        //then read all test data
        try {
            testHandler.handle();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        //finally read all mark data
        try {
            markHandler.handle();
        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
    public void close(){
        ;

    }
}
