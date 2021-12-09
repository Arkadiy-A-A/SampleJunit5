package test.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import test.extensionorother.callback.*;

@ExtendWith({
        MyBeforeAllCallback.class,
        MyBeforeEachCallback.class,
        MyBeforeTestExecutionCallback.class,
        MyAfterTestExecutionCallback.class,
        MyAfterEachCallback.class,
        MyAfterAllCallback.class
})
public class BaseCallBackTests {

    @BeforeAll
    static void beforeClass() {
        System.out.println();
        System.out.println();
        System.out.println("@BeforeAll");
        System.out.println();
    }

    @BeforeEach
    void before() {
        System.out.println("@BeforeEach");
    }

    @AfterEach
    void after() {
        System.out.println("@AfterEach");
    }

    @AfterAll
    static void afterClass() {
        System.out.println();
        System.out.println("@AfterAll");
        System.out.println();
        System.out.println();
    }

}
