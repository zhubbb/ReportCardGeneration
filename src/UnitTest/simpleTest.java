package UnitTest;

import DB.Storage;

public class simpleTest {

    public static void main(String[] args) throws Exception {

        //unit test for DB.Storage
        Storage db = new Storage();
        db.addStudent(1,"A");
        db.addStudent(2,"B");

        db.addCourse(1,"course1","t1");
        db.addCourse(2,"course2","t2");
        db.addCourse(3,"course3","t2");

        db.addTest(1,1,100);
        db.addTest(2,2,100);

        db.addTest(3,3,50);
        db.addTest(4,3,50);

        db.addMark(1,1,99.6);
        db.addMark(2,1,50);

        db.addMark(1,2,22);

        //incomplete course for student2
        db.addMark(3,2,77);

        assert(db.getStudent(1)!=null);
        assert(db.getTest(1)!=null);
        assert(db.getTest(2).getWeight()==100);
        assert(db.getTest(3).getWeight()==50);
        assert(db.getTest(4).getCourse_id()==3);


        //unit test for Model.Student
        assert(db.getStudent(1).getTestAttended(1).iterator().next().getScore()==99.6);
        assert(db.getStudent(1).getTestAttended(2).iterator().next().getScore()==50);
        assert( Math.abs(db.getStudent(1).getCoursePerformance(1)-99.6)<=0.001  );
        assert( Math.abs(db.getStudent(1).getCoursePerformance(2)-50)<=0.001  );
        assert(db.getStudent(2).getCourseCompletion(3)==false);
        assert(db.getStudent(1).getCourseCompletion(1)==true);
        assert(db.getStudent(2).getAvgPerformance()==22);



    }
}
