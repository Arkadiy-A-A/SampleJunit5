package test.extensionorother;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.EnumSource;
import test.extensionorother.argumentconvert.TypeUser;
import test.extensionorother.argumentconvert.UserParameterConvert;
import test.extensionorother.parametrresolver.User;

public class ArgumentConvertTestCase {

    @ParameterizedTest
    @EnumSource(
            value = TypeUser.class,
            names = {"OPER", "ADMIN"}
    )
    @DisplayName("testParamResolved()")
    void testParamResolved(@ConvertWith(UserParameterConvert.class) User user) {
        System.out.println("USER\n" + user);
    }
}
