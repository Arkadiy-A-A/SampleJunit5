package test.extensionorother.callback;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class MyBeforeEachCallback implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println("MyBeforeEachCallback!!!");
    }
}
