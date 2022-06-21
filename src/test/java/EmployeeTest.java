import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeTest {
    @Test
    public void employeenameTest(){
        Employee emp = new Employee();
        emp.setName("Linda");
        Assert.assertEquals(emp.getName(), "Linda");
    }
    @Test
    public void employeesurnameTest(){
        Employee emp = new Employee();
        emp.setSurname("Roze");
        Assert.assertEquals(emp.getSurname(), "Roze");
    }
    @Test
    public void employeeyearTest(){
        Employee emp = new Employee();
        emp.setYear(35);
        Assert.assertEquals(emp.getYear(), 35);
    }
    @Test
    public void employeeroleTest(){
        Employee emp = new Employee();
        emp.setRole("QA engineer");
        Assert.assertEquals(emp.getRole(), "QA engineer");
    }

    @Test
    public void testAllArguments(){
        Employee emp = new Employee("Linda", "Roze", 35, "QA");
        Assert.assertEquals(emp.getName(), "Linda");
        Assert.assertEquals(emp.getSurname(), "Roze");
        Assert.assertEquals(emp.getYear(), 35);
        Assert.assertEquals(emp.getRole(), "QA");


    }
}
