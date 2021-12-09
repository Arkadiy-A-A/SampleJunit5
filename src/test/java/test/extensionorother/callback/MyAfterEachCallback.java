package test.extensionorother.callback;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class MyAfterEachCallback implements AfterEachCallback {

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.println("MyAfterEachCallback!!!");
    }

}
