package test.suit;

import org.junit.platform.suite.api.*;
import test.simple.SimpleTestCase;
import test.simple.param.ParameterizedCalcTest;


@Suite
////@RunWith(JUnitPlatform.class)
//// Выбираем пакет с тестовыми классами
@SuiteDisplayName("AAAAAAAAAA")
@SelectPackages("test.simple")
//@IncludeClassNamePatterns(".*TestCase")
//@IncludeTags("Smoke")
////@IncludePackages("com")
////@SelectDirectories("directory")
////@SelectFiles(@SelectFile("ascasc"))
////@IncludeClassNamePatterns(".*TestCase")
//
//
//
////  Выбираем конкретные классы объединяем их как бы в сьюты
//@SelectClasses({
//        SimpleTestCase.class,
//        ParameterizedCalcTest.class
//})
public class SuiteExampleTest {

}
