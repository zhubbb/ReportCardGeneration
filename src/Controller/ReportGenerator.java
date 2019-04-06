package Controller;

import Config.Environment;
import Manager.InputDataManager;
import Manager.OutputManager;

public class ReportGenerator {
    InputDataManager inputDataManager;
    OutputManager outputManager;
    public ReportGenerator(){

        inputDataManager= new InputDataManager();
        inputDataManager.readConfig();
        outputManager= new OutputManager(Environment.database, Environment.configParameters.get(Environment.ParameterType.OUTPUT));


    }


    public void generate(){
        inputDataManager.readData();
        outputManager.writeReport();
        outputManager.close();
        inputDataManager.close();
    }

    public static void main(String[] args){

        ReportGenerator generator = new ReportGenerator();
        generator.generate();


    }
}
