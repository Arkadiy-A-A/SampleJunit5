package test.extensionorother;


import org.junit.jupiter.api.Test;
import test.base.BaseCallBackTests;

public class CallBackTestCase extends BaseCallBackTests {

    /**
     * Обычный тест-кейс аннотация @Test
     */
    @Test
    void testCallBack() {
        System.out.println("testCallBack()");
    }

}
