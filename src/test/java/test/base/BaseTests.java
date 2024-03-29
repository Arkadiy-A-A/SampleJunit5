package test.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTests {

    @BeforeAll
    static void beforeClass() {
        System.out.println();
        System.out.println();
        System.out.println("@BeforeAll");
    }



    @BeforeEach
    void before() {
        System.out.println();
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
