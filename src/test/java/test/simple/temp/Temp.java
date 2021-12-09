package test.simple.temp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class Temp {

    /**
     * Демонстрация работы с временными файлами и папками
     * java.nio.file.Path
     * java.io.File
     *
     * @param tempDir - временная папка
     * @throws IOException
     */
    @Test
    void tempDirectoryTestOne(@TempDir Path tempDir) throws IOException {
        Path tempFile = tempDir.resolve("test.txt");
        List<String> lines = Collections.singletonList("ibs.ru");
        Files.write(tempFile, Collections.singletonList("ibs.ru"));
        Assertions.assertTrue(Files.exists(tempFile),
                "Temp File should have been created");
        Assertions.assertEquals(Files.readAllLines(tempFile), lines);
    }
}
