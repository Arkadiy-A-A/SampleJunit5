package test.extensionorother.callback;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class MyBeforeAllCallback implements BeforeAllCallback {
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        System.out.println("MyBeforeAllCallback!!!");
    }
}
