package Model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseTest {
    Course course;
    Model.Test test;
    @Before
    public void setUp() {
        course = new Course(1,"c1","t1");
        test = new Model.Test(1,1,99);
        course.addTest(test);
    }

    @After
    public void tearDown() {
        course=null;
    }

    @Test
    public void getId() {
        assertEquals(1,course.id);
    }

    @Test
    public void getName() {
        assertEquals("c1",course.getName());
    }

    @Test
    public void getTeacher() {
        assertEquals("t1",course.getTeacher());
    }

    @Test
    public void getTotal_weight() {
        assertEquals(99,course.getTotal_weight());
    }

    @Test
    public void getTests() {
        assertEquals(test,course.getTests().values().iterator().next());
    }

    @Test
    public void addTest() {
        Model.Test test2 = new Model.Test(2,1,99);
        course.addTest(test2);
        assertEquals(test2,course.getTests().get(2));
    }
}