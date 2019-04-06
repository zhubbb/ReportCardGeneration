package Model;

import java.util.*;

public class Student {
    int id;
    String name;
    Map<Integer,Map<Integer,Mark>> course_marks;//course id -> map<test id,test score>
    public Map<Integer, Double> course_weightedSum;//store course_id->total weighted course score

    public Double totalWeightedScore;
    Map<Integer,Boolean> course_completion;

    public Student(int id,String name){
        this.id=id;
        this.name=name;
        course_marks=new HashMap<>();
        course_weightedSum =new HashMap<>();
        course_completion= new HashMap<>();
        totalWeightedScore =0d;

    }

    public void addMark(Course course ,int weight,Mark mark){
        int course_id = course.getId();
        course_marks.computeIfAbsent(course_id, (k)->new HashMap<>()).put(mark.getTest_id(),mark);
        course_weightedSum.put(course_id, course_weightedSum.getOrDefault(course_id,0d)+(mark.getScore()*weight/(double)course.getTotal_weight())  );


        totalWeightedScore +=(mark.getScore()*weight/course.total_weight);

        if(getTestAttended(course_id).size()==course.getTests().size()){
            course_completion.put(course_id,true);
        }else{
            course_completion.put(course_id,false);
        }

    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }


    public double getCoursePerformance(int course_id){
        if(!course_weightedSum.containsKey(course_id)){
            return 0d;
        }
        return course_weightedSum.get(course_id);
    }

    public Collection<Mark> getTestAttended(int course_id){
        if(!course_marks.containsKey(course_id)){
            return new ArrayList<>();
        }
        return course_marks.get(course_id).values();
    }
    public double getAvgPerformance(){
        int count = 0;
        double sum=0;
        for(Map.Entry<Integer,Double> course: course_weightedSum.entrySet()){
            int course_id = course.getKey();
            Double score = course.getValue();
            if(course_completion.get(course_id)){
                sum+=score;
                count++;
            }
        }
        if(count==0){
            return 0;
        }
        return sum/count;

    }

    public boolean getCourseCompletion(int course_id){
        return course_completion.getOrDefault(course_id,false);
    }
    public List<Integer> getSortedCourseIds(){
        List<Integer> res= new ArrayList<>();
        for(Integer id : course_weightedSum.keySet()){
            res.add(id);
        }
        Collections.sort(res);
        return res;
    }






}
