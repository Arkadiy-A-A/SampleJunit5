package test.extensionorother.testinstancepostproc;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import java.lang.reflect.Field;

public class GetterService implements TestInstancePostProcessor {
    /**
     *
     * @param testInstance - экземпляр класса который создает JUnit чтоб запустить тест
     * @param context - мета информация об уровне на котором происходит действие какого-либо расширения (уровень класса, метода)
     * @throws Exception
     */
    @Override
    public void postProcessTestInstance(Object testInstance,
                                        ExtensionContext context) throws Exception {
        Field[] fields = testInstance.getClass().getFields();
        for (Field item : fields) {
            if (item.getType().isAssignableFrom(MyService.class)){
                item.setAccessible(true);
                item.set(testInstance, new IbsService());
            }
        }
    }
}
