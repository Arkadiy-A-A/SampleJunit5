package test.extensionorother.argumentaggregator;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import test.extensionorother.parametrresolver.User;

public class AggregateWithUser implements ArgumentsAggregator {

    @Override
    public User aggregateArguments(ArgumentsAccessor argumentsAccessor,
                                     ParameterContext parameterContext) throws ArgumentsAggregationException {
        String FIO = argumentsAccessor.getString(0);
        String type = argumentsAccessor.getString(1);
        return new User(FIO, type);
    }

}
