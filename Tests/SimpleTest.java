
import DB.Storage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class SimpleTest {

    @Test
    public void simpleTest() throws Exception {


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


        //unit test for DB.DB
        assertNotEquals(null,db.getStudent(1));
        assertNotEquals(null,db.getTest(1));
        assertEquals(100,db.getTest(2).getWeight());
        assertEquals(50,db.getTest(3).getWeight());
        assertEquals(3, db.getTest(4).getCourse_id());


        //unit test for Model.Student
        Assert.assertEquals(99.6,db.getStudent(1).getTestAttended(1).iterator().next().getScore(),0.001);
        Assert.assertEquals( 50, db.getStudent(1).getTestAttended(2).iterator().next().getScore(),0.001);
        Assert.assertEquals( 99.6, db.getStudent(1).getCoursePerformance(1),0.001  );
        Assert.assertEquals( 50,Math.abs(db.getStudent(1).getCoursePerformance(2)),0.001  );
        assertFalse(db.getStudent(2).getCourseCompletion(3));
        assertTrue(db.getStudent(1).getCourseCompletion(1));
        assertEquals(22,db.getStudent(2).getAvgPerformance(),0.0001);



    }

    @BeforeEach
    public void setUp() throws Exception {

    }
}
