import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CohortsTest {
    Cohort emptyCohort;
    Cohort cohortHaveMany;
    Cohort cohortHaveOne;

    @Before
    public void setUp(){
        emptyCohort=new Cohort();
        cohortHaveOne = new Cohort();
        cohortHaveMany = new Cohort();
        Student nick_james = new Student(1, "Nick James");
        nick_james.addGrade(99);

        Student nick_jr  = new Student(2, "Nick Jr");
        nick_jr.addGrade(99);
        nick_jr.addGrade(99);
        nick_jr.addGrade(99);

        cohortHaveOne.addStudent(nick_james);
        cohortHaveMany.addStudent(nick_james);
        cohortHaveMany.addStudent(nick_jr);

    }
    @Test
    public void addStudentTest(){
        cohortHaveMany.addStudent(new Student(3, "Jon Andrew"));
        assertEquals("Jon Andrew", cohortHaveMany.getStudents().get(2).getName());
        cohortHaveMany.addStudent(new Student(4, "Michael Leo"));
        assertEquals(4, cohortHaveMany.getStudents().size());
    }
    @Test
    public void getStudentsTest(){
        assertEquals(0, emptyCohort.getStudents().size());
        assertEquals(1, cohortHaveOne.getStudents().size());

        assertEquals(1, cohortHaveMany.getStudents().get(0).getId());
        assertEquals(2, cohortHaveMany.getStudents().get(1).getId());
    }

    @Test
    public void getAverageTest(){
        assertEquals(Double.NaN, emptyCohort.getCohortAverage(), 0);
        assertEquals(99.0, cohortHaveOne.getCohortAverage(), 0);
        assertEquals(99.0, cohortHaveMany.getCohortAverage(), 0);
    }
}
