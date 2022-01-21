import org.junit.Test;
import org.junit.Before;
import java.util.*;
import static junit.framework.TestCase.assertEquals;

public class StudentTest {
    Student student;


    @Before
    public void setUp() {
        student = new Student(12, "Bosch");
        student.addGrade(100);
    }
    @Test
    public void getIDLong(){
        assertEquals("Bosch", student.getName());
    }

    @Test
    public void addGrade(){
        assertEquals(1, student.getGrades().size());
        student.addGrade(99);
        student.addGrade(99);
        student.addGrade(99);
        assertEquals(4, student.getGrades().size());
    }
    @Test
    public void testGradeAverage(){
        student.addGrade(90);
        student.addGrade(80);
        student.addGrade(100);

        assertEquals(92.5, student.getGradeAverage());
    }
    @Test
    public void getGrades(){
        ArrayList<Integer> grades = new ArrayList<>();
        grades.add(100);
        assertEquals(grades, student.getGrades());
    }
    @Test
    public void deleteGrades(){
        student = new Student(12, "Bosch");
        student.addGrade(88);
        student.addGrade(88);
        student.addGrade(78);
        ArrayList<Integer> expectedGrades = new ArrayList<>();

        expectedGrades.add(99);
        expectedGrades.add(88);

    }
}