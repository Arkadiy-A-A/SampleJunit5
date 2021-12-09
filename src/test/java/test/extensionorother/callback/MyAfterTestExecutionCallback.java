package test.extensionorother.callback;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class MyAfterTestExecutionCallback implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        System.out.println("MyAfterTestExecutionCallback!!!");
    }

}
