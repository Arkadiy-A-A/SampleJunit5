package test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import test.base.BaseTests;
import test.myanatation.TestOnMac;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


import static org.junit.jupiter.api.condition.JRE.*;
import static org.junit.jupiter.api.condition.OS.*;

/**
 * Примеры с новыми возможностями
 */
@DisplayName("A special test case")
public class SimpleTests extends BaseTests {

    /**
     * Собственная аннотация скомбинированная из других
     */
    @TestOnMac
    void testOnMac() {
        // ...
    }

    /**
     * Трехкратное повторение теста
     */
    @Test
    @RepeatedTest(name = "Имя теста", value = 3)
    void testRepeated() {
    }


    /**
     * DisplayName - имя теста
     */
    @Test
    @DisplayName("This will Fail, don't worry!")
    void test_fail() {

        Assertions.fail();

        Assertions.fail("Not yet implemented");

        Assertions.fail(() -> {
            return "Not yet implemented";
        });

        Assertions.fail("Not Yet Implemented", new RuntimeException("Explicitly Failed"));

        Assertions.fail(new RuntimeException("Explicitly Failed"));
    }


    /**
     * Возможность динамически формировать имя теста при нескольких запусках
     * @param testInfo - специальный объект с помощью кторого в самом тесте можно достать информацию о нем
     */
    @RepeatedTest(value = 2, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("MyTest")
    void test_with_cutom_DisplayName(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }


    /**
     * Игнорирование теста Disabled
     */
    @Test
    @Disabled("Обязательно прописываем почему")
    void DisabledTests() {
        //all tests disabled
    }

    @Test
    @DisplayName("assertNull Examples")
    void test_assertNull() {
        Assertions.assertNull(null);
        Assertions.assertNull(new Object(), "assertNull Fail Message");
    }

    @Test
    @DisplayName("assertNotNull Examples")
    void test_assertNotNull() {
        Assertions.assertNotNull(new Object());
        Assertions.assertNotNull(null, "assertNotNull Fail Message");
    }

    @Test
    @DisplayName("assertSame Examples")
    void test_assertSame() {
        Assertions.assertSame("Hi", "Hi");
        Assertions.assertSame("Hi", new String("Hi"), "My Failure Message");

    }

    @Test
    @DisplayName("assertNotSame Examples")
    void test_assertNotSame() {
        Assertions.assertNotSame("Hi", "Hello");
        Assertions.assertNotSame("Hi", "Hi", "assertNotSame Failure Message");

    }


    @Test
    @DisplayName("assertTrue Examples")
    void test_assertTrue() {
        Assertions.assertTrue(3 > 0);

        Assertions.assertTrue(() -> {
            return true;
        });

        Assertions.assertTrue(3 > 0, "assertTrue fail message");

        Assertions.assertTrue(3 > 0, () -> {
            return "assertTrue fail message";
        });

        Assertions.assertTrue(() -> { return true; }, "assertTrue fail message");

        Assertions.assertTrue (
                () -> { return true; },
                () -> { return "assertTrue fail message"; }
        );
    }

    @Test
    @DisplayName("assertFalse Examples")
    void test_assertFalse() {

        Assertions.assertFalse(3 < 0);

        Assertions.assertFalse(() -> {
            return false;
        });

        Assertions.assertFalse(3 < 0, "assertFalse fail message");

        Assertions.assertFalse(3 < 0, () -> {
            return "assertFalse fail message";
        });

        Assertions.assertFalse(() -> { return false; }, "assertFalse fail message");

        Assertions.assertFalse(
                () -> { return false; },
                () -> { return "assertFalse fail message"; }
        );
    }

    @Test
    @DisplayName("assertArrayEquals Examples")
    void test_assertArrayEquals() {
        String[] s1 = {"A", "B"};
        String[] s2 = {"A", "B"};
        Assertions.assertArrayEquals(s1, s2);
        Assertions.assertArrayEquals(s1, s2, "My Custom Failure Message");
    }


    @Test
    @DisplayName("assertIterableEquals Examples")
    void test_assertIterableEquals() {
        List<String> l1 = new ArrayList<>(Arrays.asList("A", "B"));
        List<String> l2 = new LinkedList<>(Arrays.asList("A", "B"));
        Assertions.assertIterableEquals(l1, l2);
        Assertions.assertIterableEquals(l1, l2, "Custom Failure Message");
    }

    @Test
    @DisplayName("assertThrows Examples")
    void test_assertThrows() {
        Assertions.assertThrows(Exception.class, () -> {
            throw new RuntimeException();
        });

        Assertions.assertThrows(IOException.class, () -> {throw new RuntimeException();});

        Assertions.assertThrows(IOException.class, () -> {throw new RuntimeException();}, "assertThrows Failure Message");
    }


    @Test
    @DisplayName("assertEquals Examples")
    void test_assertEquals() {
        Assertions.assertEquals(10, 10);
        Assertions.assertEquals(true, true, "assertEquals Failure Message");
        Assertions.assertEquals("Hi", new String("Hi"));
        Assertions.assertEquals(new File("test"), new File("test"));
    }

    @Test
    @DisplayName("assertNotEquals Examples")
    void test_assertNotEquals() {
        Assertions.assertNotEquals(10, 100);
        Assertions.assertNotEquals(true, false, "assertEquals Failure Message");
        Assertions.assertNotEquals("Hi", new String("Hello"));
        Assertions.assertNotEquals(new File("test"), new File("test1"));
    }

    @Test
    void testAssertAll() {
        String str1 = "abc";
        String str2 = "pqr";
        String str3 = "xyz";
        Assertions.assertAll("numbers",
                () -> Assertions.assertEquals(str1, "abc"),
                () -> Assertions.assertEquals(str2, "pqr"),
                () -> Assertions.assertEquals(str3, "xyz")
        );
//        uncomment below code and understand each assert execution
        Assertions.assertAll("numbers",
                () -> Assertions.assertEquals(str1, "abc"),
                () -> Assertions.assertEquals(str2, "pqr1"),
                () -> Assertions.assertEquals(str3, "xyz1")
        );
    }

    @Test
    void testAssertTrue() {
        Assertions.assertTrue("FirstName".startsWith("F"));
    }

    @Test
    void testAssertThrows() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Illegal Argument Exception occured");
        });
        Assertions.assertEquals("Illegal Argument Exception occured", exception.getMessage());
    }


    @Test
    @DisplayName("assertTimeout Examples")
    void test_assertTimeout() {
        Assertions.assertTimeout(Duration.ofSeconds(3), () -> {
            Thread.sleep(2000);
            System.out.println("Done");
        });

        Assertions.assertTimeout(Duration.ofNanos(1), () -> {
            Thread.sleep(20);
            System.out.println("Done");
        }, "assertTimeout Failure Message: Too less time to execute");

    }


    @Test
    @DisplayName("😱")
    void testWithDisplayNameContainingEmoji() {
    }


    /**
     * Ниже представлены различные способы включение или выключения тестов
     *
     * @EnabledOnJre
     * @DisabledOnJre
     *
     * @EnabledForJreRange
     * @DisabledForJreRange
     *
     * @EnabledOnOs
     * @DisabledOnOs
     *
     * @EnabledIfSystemProperty
     * @DisabledIfSystemProperty
     */
    @Test
    @Tag("java8")
    @EnabledOnJre(JAVA_8)
    void onlyOnJava8() {
        // ...
    }

    @Test
    @EnabledOnJre({JAVA_9, JAVA_10})
    void onJava9Or10() {
        // ...
    }

    @Test
    @EnabledForJreRange(min = JAVA_9, max = JAVA_11)
    void fromJava9to11() {
        // ...
    }

    @Test
    @EnabledForJreRange(min = JAVA_9)
    void fromJava9toCurrentJavaFeatureNumber() {
        // ...
    }

    @Test
    @EnabledForJreRange(max = JAVA_11)
    void fromJava8To11() {
        // ...
    }

    @Test
    @DisabledOnJre(JAVA_9)
    void notOnJava9() {
        // ...
    }

    @Test
    @DisabledForJreRange(min = JAVA_9, max = JAVA_11)
    void notFromJava9to11() {
        // ...
    }

    @Test
    @DisabledForJreRange(min = JAVA_9)
    void notFromJava9toCurrentJavaFeatureNumber() {
        // ...
    }

    @Test
    @DisabledForJreRange(max = JAVA_11)
    void notFromJava8to11() {
        // ...
    }


    @Test
    @EnabledOnOs(MAC)
    void onlyOnMacOs() {
        // ...
    }

    @Test
    @EnabledOnOs({LINUX, WINDOWS})
    void onLinuxOrWindows() {
        // ...
    }

    @Test
    @DisabledOnOs(WINDOWS)
    void notOnWindows() {
        // ...
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
    void onlyOn64BitArchitectures() {
        // ...
    }

    @Test
    @DisabledIfSystemProperty(named = "ci-server", matches = "true")
    void testNotOnCiServer() {
        System.out.println("testNotOnCiServer");
        // ...
    }

    @Test
    @DisplayName("Assume test simple")
    void testAssume() {
        //    assumeTrue([String message], boolean b) — Проверка на истинность логического утверждения.
        //    assumeFalse([String message], boolean b) — Проверка на истинность логического утверждения, обратно assumeTrue.
        //    assumeNoException([String message], Throwable t) — Предположение, что тест завершится нормально. Если метод вызывается и в качестве t передается выброшенное исключение, то тест игнорируется (обычно применяется в блоке catch конструкции try-catch и передается выброшенное исключение).
        //    assumeNotNull(Object... objects) — Если вызывается с одним (или более) не нулевым объектом, то тест прерывается и игнорируется.
        //    assumeThat([String message], T actual, Matcher<T> matcher)  — Проверка, что actual удовлетворяет условию заданному matcher.
        Assumptions.assumeTrue(true, "[String message]");
        System.out.println("testAssume");
    }

}
