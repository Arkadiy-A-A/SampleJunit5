package test.extensionorother.parametrresolver;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.*;

public class UserParameterResolver implements ParameterResolver {

    /**
     * Метод должен вернуть инфу подходит ли объект который мы хотим туда подставить
     *
     * @param parameterContext - контекс параметра который передан в метод
     * @param extensionContext - содержит инфу уровня класса или метода
     * @return boolean - true значит подставляем объект, false значит не наш метод
     * @throws ParameterResolutionException
     */
    @Override
    public boolean supportsParameter(ParameterContext parameterContext,
                                     ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().isAssignableFrom(User.class);
    }

    /**
     * Метод который подставит все что нужно
     * @param parameterContext - контекс параметра который передан в метод
     * @param extensionContext - содержит инфу уровня класса или метода
     * @return User - вернут нужного юзера
     * @throws ParameterResolutionException
     */
    @Override
    public User resolveParameter(ParameterContext parameterContext,
                                   ExtensionContext extensionContext) throws ParameterResolutionException {

        Tag tag = extensionContext.getRequiredTestMethod().getAnnotation(Tag.class);

        if(tag == null){
            throw new ParameterResolutionException("Тег должен быть задан");
        }

        return DataManager.getInstance().getUserByType(tag.value());
    }
}
