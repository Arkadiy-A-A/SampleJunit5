package test.data;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataClass {
    public static Stream<Arguments> msMP() {
        return Stream.of(
                Arguments.of(1, "A"),
                Arguments.of(2, "B"),
                Arguments.of(3, "C"));
    }
}
