package test.simple;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.condition.JRE.*;
import static org.junit.jupiter.api.condition.OS.MAC;

@DisplayName("Condition TestCase Annotation")
public class ConditionTestCase {

    /**
     * Тест-кейс с аннотацией @EnabledOnJre - включает тест-кейса для определённой версии JAVA
     *
     * Пример:
     *     1) @EnabledOnJre({JAVA_8, JAVA_11}) - включает тест-кейса для JAVA 8 и 11
     */
    @Test
    @EnabledOnJre(JAVA_8)
    void testEnabledOnJre() {
        System.out.println("testEnabledOnJre()");
    }

    /**
     * Тест-кейс с аннотацией @DisabledOnJre - отключает тест-кейса для определённой версии JAVA
     *
     * Пример:
     *     1) @DisabledOnJre({JAVA_8, JAVA_11}) - отключает тест-кейс для JAVA 8 и 11
     */
    @Test
    @DisabledOnJre(JAVA_8)
    void testDisabledOnJre() {
        System.out.println("testDisabledOnJre()");
    }

    /**
     * Тест-кейс с аннотацией @EnabledForJreRange - включает тест-кейс для версии JAVA попадающая в диапазон
     *
     * Пример:
     *     1) @EnabledForJreRange(min = JAVA_11) - включает тест-кейс для JAVA 11 и выше
     *     2) @EnabledForJreRange(max = JAVA_11) - включает тест-кейс для JAVA 11 и ниже до 8
     */
    @Test
    @EnabledForJreRange(min = JAVA_11, max = JAVA_17)
    void testEnabledForJreRange() {
        System.out.println("testEnabledForJreRange()");
    }

    /**
     * Тест-кейс с аннотацией @DisabledForJreRange - отключает тест-кейс для версии JAVA попадающая в диапазон
     *
     * Пример:
     *     1) @DisabledForJreRange(min = JAVA_11) - отключает тест-кейс для JAVA 11 и выше
     *     2) @DisabledForJreRange(max = JAVA_11) - отключает тест-кейс для JAVA 11 и ниже до 8
     */
    @Test
    @DisabledForJreRange(min = JAVA_9)
    void testDisabledForJreRange() {
        System.out.println("testDisabledForJreRange()");
    }


    /**
     * Тест-кейс с аннотацией @EnabledOnOs - включает тест-кейс для указанной ОС
     *
     * Пример:
     *     1) @EnabledOnOs({LINUX, WINDOWS}) - включает тест-кейс для ОС LINUX, WINDOWS
     */
    @Test
    @EnabledOnOs(MAC)
    void testEnabledOnOs() {
        System.out.println("testEnabledOnOs()");
    }

    /**
     * Тест-кейс с аннотацией @DisabledOnOs - отключает тест-кейс для указанной ОС
     *
     * Пример:
     *     1) @DisabledOnOs({LINUX, WINDOWS}) - отключает тест-кейс для ОС LINUX, WINDOWS
     */
    @Test
    @DisabledOnOs(MAC)
    void testDisabledOnOs() {
        System.out.println("testDisabledOnOs()");
    }

    /**
     * Тест-кейс с аннотацией @EnabledIfSystemProperty
     * Включает тест-кейс по определённому системному св-ву (по ключу), значение которого совпадает с заданным (по маске)
     *
     * Пример:
     *     1) @EnabledIfSystemProperty(named = "os.arch", matches = ".*64") - включает тест-кейс, если системное
     *        св-во os.arch заканчивается словом "64"
     */
    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64")
    void testEnabledIfSystemProperty() {
        System.out.println("testEnabledIfSystemProperty()");
    }

    /**
     * Тест-кейс с аннотацией @DisabledIfSystemProperty
     * Отключает тест-кейс по определённому системному св-ву (по ключу), значение которого совпадает с заданным (по маске)
     *
     * Пример:
     *     1) @DisabledIfSystemProperty(named = "my.sys.prop", matches = "true") - отключает тест-кейс, если системное
     *        св-во my.sys.prop=true
     */
    @Test
    @Tag("ASD")
    @DisabledIfSystemProperty(named = "my.sys.prop", matches = "true")
    void testDisabledIfSystemProperty() {
        System.out.println("testDisabledIfSystemProperty()");
    }
}
