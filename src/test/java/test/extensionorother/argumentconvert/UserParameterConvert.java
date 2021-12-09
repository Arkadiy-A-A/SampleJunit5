package test.extensionorother.argumentconvert;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import test.extensionorother.parametrresolver.DataManager;
import test.extensionorother.parametrresolver.User;

public class UserParameterConvert implements ArgumentConverter {

    /**
     *
     * @param o - пришедший параметр
     * @param parameterContext - контекст параметра
     * @return
     * @throws ArgumentConversionException
     */
    @Override
    public Object convert(Object o,
                          ParameterContext parameterContext) throws ArgumentConversionException {
        Assertions.assertEquals(o.getClass(), TypeUser.class);
        Assertions.assertEquals(parameterContext.getParameter().getType(), User.class);

        return DataManager.getInstance().getUserByType(o.toString());
    }
}
