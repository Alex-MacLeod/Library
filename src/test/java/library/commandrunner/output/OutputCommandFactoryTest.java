package library.commandrunner.output;

import library.customer.Customer;
import library.io.writer.ConsoleWriter;
import library.io.writer.FileWriter;
import library.item.Item;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OutputCommandFactoryTest {

    @Test
    public void factoryShouldCreateLibraryCommandRunnerWithConsoleWriter() {
        // Given
        List<String> args = List.of("output", "console", "library");

        // When
        OutputCommand toBeTested = OutputCommandFactory.getOutputCommand(args);

        // Then
        assertDoesNotThrow(() -> new IllegalArgumentException("Invalid output write 'console'"));
        assertDoesNotThrow(() -> new IllegalArgumentException("Did not recognise 'library' as a valid data type to be outputted"));

        Object outputData = toBeTested.getData();

        assertTrue(toBeTested.getWriter() instanceof ConsoleWriter);
        assertTrue(outputData instanceof List);
        assertTrue((((List<?>) outputData).size() > 0 && ((List<?>) outputData).get(0) instanceof Item));
    }

    @Test
    public void factoryShouldCreateCustomerCommandRunnerWithConsoleWriter() {
        // Given
        List<String> args = List.of("output", "console", "customers");

        // When
        OutputCommand toBeTested = OutputCommandFactory.getOutputCommand(args);

        // Then
        assertDoesNotThrow(() -> new IllegalArgumentException("Invalid output writer 'console'"));
        assertDoesNotThrow(() -> new IllegalArgumentException("Did not recognise 'customers' as a valid data type to be outputted"));

        Object outputData = toBeTested.getData();

        assertTrue(toBeTested.getWriter() instanceof ConsoleWriter);
        assertTrue(outputData instanceof List);
        assertTrue((((List<?>) outputData).size() > 0 && ((List<?>) outputData).get(0) instanceof Customer));
    }

    @Test
    public void factoryShouldCreateLibraryCommandRunnerWithFileWriter() {
        // Given
        List<String> args = List.of("output", "file", "library");

        // When
        OutputCommand toBeTested = OutputCommandFactory.getOutputCommand(args);

        // Then
        assertDoesNotThrow(() -> new IllegalArgumentException("Invalid output writer 'file'"));
        assertDoesNotThrow(() -> new IllegalArgumentException("Did not recognise 'library' as a valid data type to be outputted"));

        Object outputData = toBeTested.getData();

        assertTrue(toBeTested.getWriter() instanceof FileWriter);
        assertTrue(outputData instanceof List);
        assertTrue((((List<?>) outputData).size() > 0 && ((List<?>) outputData).get(0) instanceof Item));
    }

    @Test
    public void factoryShouldCreateCustomerCommandRunnerWithFileWriter() {
        // Given
        List<String> args = List.of("output", "file", "customers");

        // When
        OutputCommand toBeTested = OutputCommandFactory.getOutputCommand(args);

        // Then
        assertDoesNotThrow(() -> new IllegalArgumentException("Invalid output writer 'file'"));
        assertDoesNotThrow(() -> new IllegalArgumentException("Did not recognise 'customers' as a valid data type to be outputted"));

        Object outputData = toBeTested.getData();

        assertTrue(toBeTested.getWriter() instanceof FileWriter);
        assertTrue(outputData instanceof List);
        assertTrue((((List<?>) outputData).size() > 0 && ((List<?>) outputData).get(0) instanceof Customer));
    }

    @Test
    public void noWriterArgumentShouldDefaultToConsole() {
        // Given
        List<String> args = List.of("output", "library");

        // When
        OutputCommand toBeTested = OutputCommandFactory.getOutputCommand(args);

        // Then
        assertDoesNotThrow(() -> new IllegalArgumentException("Invalid output write 'console'"));
        assertDoesNotThrow(() -> new IllegalArgumentException("Did not recognise 'library' as a valid data type to be outputted"));

        Object outputData = toBeTested.getData();

        assertTrue(toBeTested.getWriter() instanceof ConsoleWriter);
        assertTrue(outputData instanceof List);
        assertTrue((((List<?>) outputData).size() > 0 && ((List<?>) outputData).get(0) instanceof Item));
    }

    @Test
    public void factoryShouldThrowExceptionWhenNoArgs() {
        // Given
        List<String> args = List.of();

        // When/Then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> OutputCommandFactory.getOutputCommand(args));
        assertEquals("Too few arguments", exception.getMessage());
    }

    @Test
    public void factoryShouldThrowExceptionWhenInvalidWriterType() {
        // Given
        List<String> args = List.of("output", "invalidWriter", "library");

        // When/Then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> OutputCommandFactory.getOutputCommand(args));
        assertEquals("Invalid output writer 'invalidWriter'", exception.getMessage());
    }

    @Test
    public void factoryShouldThrowExceptionWhenInvalidDataType() {
        // Given
        List<String> args = List.of("output", "console", "invalidData");

        // When/Then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> OutputCommandFactory.getOutputCommand(args));
        assertEquals("Did not recognise 'invalidData' as a valid data type to be outputted", exception.getMessage());
    }
}