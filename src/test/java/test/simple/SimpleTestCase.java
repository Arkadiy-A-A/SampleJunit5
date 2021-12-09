package test.simple;

import org.junit.jupiter.api.*;
import test.base.BaseTests;
import test.simple.myanatation.Smoke;
import test.simple.myanatation.TestOnMac;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.RepeatedTest.LONG_DISPLAY_NAME;

/**
 * Примеры с новыми возможностями
 */
@DisplayName("Base TestCase Annotation")
public class SimpleTestCase extends BaseTests {

    /**
     * Обычный тест-кейс аннотация @Test
     */
    @Test
    void testSimple() {
        System.out.println("testSimple()");
    }

    /**
     * Тест кейс с аннотацией @DisplayName - наименование тест-кейса
     */
    @Test
    @DisplayName("My name is testDisplayName()")
    void testDisplayName() {
        System.out.println("testDisplayName()");
    }

    /**
     * Тест кейс с аннотацией @DisplayName - возможность прописать эмоджи в тест-кейсе
     */
    @Test
    @DisplayName("😱 -> My name is testWithDisplayNameContainingEmoji()")
    void testWithDisplayNameContainingEmoji() {
        System.out.println("testWithDisplayNameContainingEmoji()");
    }

    /**
     * Тест кейс с аннотацией @Timeout - задание ограничение по времени выполнения тетс-кейса
     */
    @Test
    @Timeout(7)
    @DisplayName("My name is testTimeout()")
    void testTimeout() {
        System.out.println("testTimeout()");
    }

    /**
     * Тест-кейс с аннотацией @Disabled - игнорирование (отключение) тест-кейса
     */
    @Test
    @DisplayName("My name is testDisabled()")
    @Disabled("The reason for the disabling must always be indicated.")
    void testDisabled() {
        System.out.println("Don't expect results from me. I am disabled. SEE ANNOTATION @DISABLED!!!");
    }

    /**
     * Тест-кейс с аннотацией @Tag - тегирование тест-кейса
     */
    @Test
    @Tag("Smoke")
    @DisplayName("My name is testWithTag()")
    void testWithTag() {
        System.out.println("testWithTag()");
    }

    /**
     * Тест-кейс с аннотацией @Tags - множественное тегирование тест-кейса
     */
    @Test
    @Tags({
            @Tag("Smoke"),
            @Tag("Regress"),
            @Tag("Tags")
    })
    @DisplayName("My name is testWithTags()")
    void testWithTags() {
        System.out.println("testWithTags()");
    }


    /**
     * Тест-кейс с аннотацией @RepeatedTest - позволяет запустить тест-кейса n-ое колличество раз
     */
    @Tag("Repeated")
    @RepeatedTest(name = LONG_DISPLAY_NAME, value = 2)
    void testRepeated() {
        System.out.println("testRepeated()");
    }


    /**
     * Возможность динамически формировать имя теста при нескольких запусках
     * @param testInfo - специальный объект с помощью кторого в самом тесте можно достать информацию о нем
     */
    @Test
    @DisplayName("My name is testWithArgumentMethod(TestInfo testInfo)")
    void testWithArgumentMethod(TestInfo testInfo) {
        System.out.println("testWithArgumentMethod() " + testInfo.getDisplayName());
    }


    /**
     * Собственная аннотация скомбинированная из других
     */
    @TestOnMac
    void testOnMac() {
        // ...
    }

}
