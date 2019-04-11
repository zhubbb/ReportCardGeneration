package DB;

import Model.Course;
import Model.Mark;
import Model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class StorageTest  {
    Storage db;
    @Before
    public void setUp() throws Exception {
        db =new Storage();
        db.addCourse(1,"c1","t1");
        db.addStudent(1,"s1");
        db.addTest(1,1,10);


    }

    @After
    public void tearDown() throws Exception {
        db=null;
    }

    @Test
    public void addCourse() {
        Course course = db.addCourse(2,"c2","t2");
        assertEquals(course, db.courses.get(2));


    }

    @Test
    public void getCourse() {

        Course course = db.addCourse(2,"c2","t2");
        assertEquals( course, db.getCourse(2));

    }

    @Test
    public void addStudent() {

        Student student= db.addStudent(1,"s1");
        assertEquals(student,db.students.get(1));
    }

    @Test
    public void getStudent() {
        Student student= db.addStudent(1,"s1111");
        assertEquals(student,db.getStudent(1));
    }



    @Test
    public void getTest() {
        Model.Test test = new Model.Test(2,1,9);
        db.tests.put( 2 ,test );
        assertEquals(test, db.getTest(2));
    }

    @Test
    public void addTest() throws Exception {

        Model.Test test = db.addTest(2,1,9);
        assertEquals(test,db.getTest(2));
    }

    @Test
    public void addMark() throws Exception {
        Mark mark = db.addMark(1,1,100);
        assertTrue(db.getStudent(1).getTestAttended(1).contains(mark));
    }

    @Test
    public void getSortedStudentIds() {
        db.addStudent(2,"2");
        Iterator<Integer> ids = db.getSortedStudentIds().iterator();
        assertTrue( ids.next()<ids.next()  );
    }


}