package mavenTestNGHomework;

import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorMethodTest {
    @BeforeSuite(alwaysRun = true)
    public void testIntro() {
        System.out.println("Laižam testu kopu!");
    }

    @BeforeMethod(alwaysRun = true)
    public void testStart() {
        System.out.println("Tests ir palaists!");
    }

    @BeforeTest(alwaysRun = true)
    public void testBegin() {
        System.out.println("Pirmais tests ir uzsākts!");
    }

    @AfterTest(alwaysRun = true)
    public void testFinish() {
        System.out.println("Pēdējais tests ir pabeigts!");
    }

    @Test
    public void testAddMethod() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.add(10, 20), 30);
    }

    @Test
    public void testSubtractMethod() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.substract(20, 10), 10);
    }

    @Test
    public void testMultiplyMethod() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.multiply(5, 6), 30);
    }

    @Test
    public void testDivideMethod() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(20, 10), 2);
    }
}