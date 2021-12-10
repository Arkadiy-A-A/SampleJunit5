package test.extensionorother;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import test.extensionorother.parametrresolver.User;
import test.extensionorother.parametrresolver.UserParameterResolver;

@ExtendWith(UserParameterResolver.class)
public class ParameterResolvedTestCase {

    @Test
    @Tag("ADMIN")
    @DisplayName("testParamResolved()")
    void testParamResolved(User user) {
        System.out.println("USER\n" + user);
    }
}
