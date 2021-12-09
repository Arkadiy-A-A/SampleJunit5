package test.extensionorother.testinstancepostproc;

public class MockService implements MyService {

    @Override
    public String getString() {
        return "Welcome to Mock";
    }
}
