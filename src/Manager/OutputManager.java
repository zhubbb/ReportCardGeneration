package Manager;

import DB.Storage;
import Model.Course;
import Model.Student;

import java.io.*;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.List;

public class OutputManager {
    Storage db;
    BufferedWriter writer;
    String outputPath;
    public OutputManager(Storage db, String outputPath) {
        this.db=db;
        try {
            File file = new File(outputPath);
            file.getParentFile().mkdirs();
            writer=new BufferedWriter(new FileWriter(file,false));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StringBuilder generateStudentReport(int studentId){

        //Student Id: 2, name: B
        //Total Average:      62.15%
        //
        //        Course: Biology, Teacher: Mr. D
        //        Final Grade:      50.10%
        //
        //        Course: Math, Teacher:  Mrs. C
        //        Final Grade:      74.20%

        DecimalFormat formatter = new DecimalFormat("00.00");
        StringBuilder buffer = new StringBuilder();
        Student student = db.getStudent(studentId);
        buffer.append("Student Id: ").append(String.valueOf(studentId)).append(", name: ").append(student.getName()).append("\n");
        buffer.append("Total Average:    ");
        buffer.append( formatter.format(student.getAvgPerformance() ) );
        buffer.append("%\n");



        for(Integer courseId:student.getSortedCourseIds()){

            Course course = db.getCourse(courseId);
            buffer.append("\n");
            //append course info
            buffer.append("        ")
                    .append("Course: ")
                    .append(course.getName())
                    .append(", Teacher: ")
                    .append(course.getTeacher())
                    .append("\n");
            //append score


            buffer.append("        ")
                    .append("Final Grade: ");
            if(student.getCourseCompletion(courseId)) {
                buffer.append(formatter.format(student.getCoursePerformance(courseId)))
                        .append("%\n");
            }else{//course is incomplete
                buffer.append("N/A(Incomplete)\n");
            }

        }
        return buffer;


    }
    public void writeReport(){
        List<Integer> studentIds = db.getSortedStudentIds();
        boolean firstLine=true;
        for(Integer id:studentIds){
            //generate info for each student
            StringBuilder sb = generateStudentReport(id);
            try {
                if(!firstLine){
                    writer.append("\n\n\n");
                }
                writer.append(sb.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            firstLine=false;

        }
    }
    public void close(){
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
