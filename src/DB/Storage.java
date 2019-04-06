package DB;

import Model.Course;
import Model.Mark;
import Model.Student;
import Model.Test;

import java.util.*;

public class Storage {
    Map<Integer, Course> courses;
    Map<Integer, Student> students;
//    Map<Integer, Mark> marks;
    Map<Integer, Test> tests;

    public Storage(){
        courses=new HashMap<>();
        students=new HashMap<>();
//        marks = new HashMap<>();
        tests =  new HashMap<>();
    }

    public Course getCourse(int id){
        return courses.getOrDefault(id,null);
    }
    public Course addCourse(int id,String name, String teacher){
        Course course = new Course(id,name,teacher);
        courses.put(id,course);
        return course;
    }

    public Student getStudent(int id){
        return students.getOrDefault(id,null);
    }
    public Student addStudent(int id, String name){
        Student student= new Student(id,name);
        students.put(id,new Student(id,name));
        return student;
    }

    public Test getTest(int id){
        return tests.getOrDefault(id,null);
    }
    public Test addTest(int id,int course_id,int weight) throws Exception {
        Course course = courses.get(course_id);
        if(course==null){
            throw new Exception("course id is not found");
        }
        Test test = new Test(id,course_id,weight);
        course.addTest(test);
        tests.put(id,test);
        return test;
    }


    public void addMark(int test_id, int student_id, double mark) throws Exception {
        Student student=getStudent(student_id);
        if(student==null){
            throw new Exception("student id is not found");
        }
        Test test = getTest(test_id);
        if(test==null){
            throw  new Exception("test id is not found");
        }
        Course course= getCourse(test.getCourse_id());
        if(course==null){
            throw new Exception("course id is not found");
        }
        Mark mark_info = new Mark(test_id,student_id,mark);
        student.addMark( course,test.getWeight(),mark_info);

    }

    public List<Integer> getSortedStudentIds(){
        List<Integer> res = new ArrayList<>();
        for(Integer id :  students.keySet()){
            res.add(id);
        }
        Collections.sort(res);
        return res;
    }


}
