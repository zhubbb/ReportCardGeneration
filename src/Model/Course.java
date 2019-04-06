package Model;

import java.util.HashMap;
import java.util.Map;

public class Course {
    int id;
    String name;
    String teacher;
    int total_weight;
    Map<Integer,Test> tests;
    public Course(int id,String name,String teacher){
        this.id=id;
        this.name=name;
        this.teacher=teacher;
        total_weight=0;
        tests = new HashMap<>();
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getTeacher(){
        return teacher;
    }
    public int getTotal_weight(){
        return total_weight;
    }
    public Map<Integer,Test> getTests(){
        return tests;
    }


    public void addTest(Test test){
        this.tests.put(test.getId(),test);
        total_weight+=test.getWeight();
    }

}
