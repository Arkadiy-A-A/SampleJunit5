package test.extensionorother.callback;

import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class MyBeforeTestExecutionCallback implements BeforeTestExecutionCallback {
    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        System.out.println("MyBeforeTestExecutionCallback!!!");
    }
}
