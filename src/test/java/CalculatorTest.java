import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    /*
     * Unit tests
     * делаем в основном положительные тесты
     * */
    Calculator calc;

    @Before
    public void init() {
        calc = new Calculator();
    }

    @Test
    public void checkSumOfIntegers() {
        int expectedSum = 11;
        int ActualSum = calc.getSum(5, 6);
        Assert.assertEquals(expectedSum, ActualSum);
    }

    @Test
    public void checkDiffOfIntegers() {
        int expectedDiff = 3;
        int expectedDiffNEG  = -3;
        int expectedDiffPOS  = 13;
        int expectedDiffPOSplusNOL = 123;

        int ActualDiff = calc.getDifference(7, 4);
        int ActualDiffNEG = calc.getDifference(-8, -5);
        int ActualDiffPOS = calc.getDifference(15, 2);
        int ActualDiffPOSplusNOL = calc.getDifference(123, 0);
        Assert.assertEquals(expectedDiff, ActualDiff);

        Assert.assertEquals("POS",expectedDiffPOS, ActualDiffPOS );
        Assert.assertEquals("NEG",expectedDiffNEG, ActualDiffNEG );
        Assert.assertEquals("POSplusNOL",expectedDiffPOSplusNOL, ActualDiffPOSplusNOL);



    }

}
