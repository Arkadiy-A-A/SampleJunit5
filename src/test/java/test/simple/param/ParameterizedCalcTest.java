package test.simple.param;



import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import test.Calculator;
import test.base.BaseTests;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Параметризация различными способами
 */
public class ParameterizedCalcTest extends BaseTests {


    @ParameterizedTest(name = "Тестик data = {0}, {1}")
    @CsvSource({
            "1,1,1",
            "1,2,2",
            "2,2,4",
            "3,2,6",
            "0,0,0"
    })
    void test_CsvSource(int a, int b, int c) {
        System.out.println("Праметры:\na = " + a + "\nb = " + b + "\nc = " + c+"\n");
        assertEquals(c, new Calculator().multiplication(a, b));
    }


    @ParameterizedTest
    @MethodSource("myCalc")
    void test_MethodSource_Objects(int a, int b, int c) {
        System.out.println("Праметры:\na = " + a + "\nb = " + b + "\nc = " + c+"\n");
        assertEquals(c, new Calculator().multiplication(a, b));
    }
    static Stream<Arguments> myCalc() {
        return  Stream.of(
                Arguments.of(1, 1, 1),
                Arguments.of(1, 2, 2),
                Arguments.of(2, 2, 4),
                Arguments.of(3, 2, 6),
                Arguments.of(0, 0, 0)
        );
    }
}
