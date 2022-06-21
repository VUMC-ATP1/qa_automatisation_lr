import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
    @Test
    public void testAddMethod(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.add(10.00, 20.00), 30.00); //vienmēr pārbauda kaut ko - iekavās dotās vērtības, trešais parametrs ir sagaidāmais
    }
    @Test
    public void testSubtractMethod(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.subtract(40.00, 20.00), 20.00); //vienmēr pārbauda kaut ko -
    }
    @Test
    public void testDivideMethod(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(30.00, 2.00), 15.00); //vienmēr pārbauda kaut ko -
    }
    @Test
    public void testMultipleMethod(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.multiple(7.00, 8.00), 56.00); //vienmēr pārbauda kaut ko -
    }
}
