package test.extensionorother;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvSource;
import test.extensionorother.argumentaggregator.AggregateUser;
import test.extensionorother.argumentaggregator.AggregateWithUser;
import test.extensionorother.parametrresolver.User;


public class ArgumentAggregatorTestCase {

    @ParameterizedTest(name = "Тестик data = {0}, {1}")
    @CsvSource({"Mendeleev,СHEMIST", "Lomonosov,GREAT SCIENTIST"})
    @DisplayName("testParamResolved()")
    void testParamResolved(@AggregateUser User user) {
        System.out.println("USER\n" + user);
    }
}
