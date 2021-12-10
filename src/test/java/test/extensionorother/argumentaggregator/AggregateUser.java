package test.extensionorother.argumentaggregator;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.aggregator.AggregateWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@AggregateWith(AggregateWithUser.class)
public @interface AggregateUser {
}
