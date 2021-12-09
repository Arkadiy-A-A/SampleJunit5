package test.simple.order;

import org.junit.jupiter.api.*;
import test.Calculator;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderingTestCase {

    private final Calculator calculator = new Calculator();

    @Test
    @Disabled("for demonstration purposes")
    @Order(3)
    void testB() {
    }

    @Test
    @Order(2)
    void testA() {
    }

    @Test
    @Order(1)
    void testD() {
    }

    @Test
    @Order(4)
    void testC() {
    }

}
