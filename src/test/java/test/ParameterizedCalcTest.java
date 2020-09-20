package test;



import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import test.base.BaseTests;
import test.data.Book;
import java.lang.annotation.ElementType;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Параметризация различными способами
 */
public class ParameterizedCalcTest extends BaseTests {

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void test_ValueSource(int i) {
        System.out.println(i);
    }

    @ParameterizedTest(name = "Проверка ElementType = {0}")
    @ValueSource(strings = { "1", "2", "3" })
    void test_ValueSource_String(String s) {
        assertTrue(Integer.parseInt(s) < 5);
    }

    @ParameterizedTest(name = "Проверка ElementType = {0}")
    @EnumSource(value = ElementType.class, names = { "TYPE", "METHOD", "FIELD" })
    void test_EnumSource_Extended(ElementType et) {
        assertTrue(EnumSet.of(ElementType.FIELD, ElementType.TYPE, ElementType.METHOD).contains(et));
    }

    @ParameterizedTest
    @MethodSource("ms")
    void test_MethodSource(String s) {
        assertNotNull(s);
    }
    static Stream<String> ms() {
        return Stream.of("A", "B");
    }

    @ParameterizedTest
    @MethodSource("test.data.DataClass#msMP")
    void test_MethodSource_MultipleParams(int i, String s) {
        assertTrue(4 > i);
        assertTrue(Arrays.asList("A", "B", "C").contains(s));
    }

    @ParameterizedTest(name = "Тестик data = {0}, {1}")
    @CsvSource({"1,A", "2,B"})
    void test_CsvSource(int i, String s) {
        assertTrue(3 > i);
        assertTrue(Arrays.asList("A", "B", "C").contains(s));
    }

    @ParameterizedTest
    @CsvSource(delimiter='|', value= {"1|'A'","2|B"})
    void test_CsvSource2(int i, String s) {
        assertTrue(3 > i);
        assertTrue(Arrays.asList("A", "B", "C").contains(s));
    }


    @ParameterizedTest(name = "тестик data = {0} {1}")
    @CsvFileSource(resources = "/country_code.csv", numLinesToSkip = 1)
    void test_CsvFileSource(String country, int code) {
        assertNotNull(country);
        assertTrue(0 < code);
    }



    static Book[] mpBooks() {
        return new Book[] {new Book("Harry Potter"), new Book("Five Point Someone")};
    }
    @ParameterizedTest
    @MethodSource("mpBooks")
    void test_MethodSource_Objects(Book b) {
        assertNotNull(b.getTitle());
    }


    @ParameterizedTest
    @ValueSource(strings = {"Harry Potter", "Hamlet"})
    void test_ValueSource_Objects(Book b) {
        assertNotNull(b.getTitle());
    }
}
