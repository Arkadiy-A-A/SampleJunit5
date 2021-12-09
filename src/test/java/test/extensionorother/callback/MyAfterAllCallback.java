package test.extensionorother.callback;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class MyAfterAllCallback implements AfterAllCallback {

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        System.out.println("MyAfterAllCallback!!!");
    }

}
