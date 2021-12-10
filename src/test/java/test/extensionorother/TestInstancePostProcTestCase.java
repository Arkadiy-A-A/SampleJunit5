package test.extensionorother;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import test.extensionorother.testinstancepostproc.GetterService;
import test.extensionorother.testinstancepostproc.MyService;

@ExtendWith(GetterService.class)
public class TestInstancePostProcTestCase {

    public MyService myService;

    @Test
    void testIbs(){
        Assertions.assertEquals("Welcome to IBS Appline Compani", myService.getString());
    }

    @Test
    void testMock(){
        Assertions.assertEquals("Welcome to Mock", myService.getString());
    }
}
