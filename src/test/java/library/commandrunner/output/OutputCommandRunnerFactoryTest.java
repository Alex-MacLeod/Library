package library.commandrunner.output;

import library.customer.Customer;
import library.io.writer.ConsoleWriter;
import library.io.writer.FileWriter;
import library.item.Item;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OutputCommandRunnerFactoryTest {

    @Test
    public void factoryShouldCreateLibraryCommandRunnerWithConsoleWriter() {
        List<String> args = List.of("console", "library");
        assertDoesNotThrow(() -> new IllegalArgumentException("Invalid output write 'console'"));
        assertDoesNotThrow(() -> new IllegalArgumentException("Did not recognise 'library' as a valid data type to be outputted"));

        OutputCommandRunner toBeTested = OutputCommandRunnerFactory.getOutputCommandRunner(args);
        Object outputData = toBeTested.getData();

        assertTrue(toBeTested.getWriter() instanceof ConsoleWriter);
        assertTrue(outputData instanceof List);
        assertTrue((((List) outputData).size() > 0 && ((List) outputData).get(0) instanceof Item));
    }

    @Test
    public void factoryShouldCreateCustomerCommandRunnerWithConsoleWriter() {
        List<String> args = List.of("console", "customers");
        assertDoesNotThrow(() -> new IllegalArgumentException("Invalid output writer 'console'"));
        assertDoesNotThrow(() -> new IllegalArgumentException("Did not recognise 'customers' as a valid data type to be outputted"));

        OutputCommandRunner toBeTested = OutputCommandRunnerFactory.getOutputCommandRunner(args);
        Object outputData = toBeTested.getData();

        assertTrue(toBeTested.getWriter() instanceof ConsoleWriter);
        assertTrue(outputData instanceof List);
        assertTrue((((List) outputData).size() > 0 && ((List) outputData).get(0) instanceof Customer));
    }

    @Test
    public void factoryShouldCreateLibraryCommandRunnerWithFileWriter() {
        List<String> args = List.of("file", "library");
        assertDoesNotThrow(() -> new IllegalArgumentException("Invalid output writer 'file'"));
        assertDoesNotThrow(() -> new IllegalArgumentException("Did not recognise 'library' as a valid data type to be outputted"));

        OutputCommandRunner toBeTested = OutputCommandRunnerFactory.getOutputCommandRunner(args);
        Object outputData = toBeTested.getData();

        assertTrue(toBeTested.getWriter() instanceof FileWriter);
        assertTrue(outputData instanceof List);
        assertTrue((((List) outputData).size() > 0 && ((List) outputData).get(0) instanceof Item));
    }

    @Test
    public void factoryShouldCreateCustomerCommandRunnerWithFileWriter() {
        List<String> args = List.of("file", "customers");
        assertDoesNotThrow(() -> new IllegalArgumentException("Invalid output writer 'file'"));
        assertDoesNotThrow(() -> new IllegalArgumentException("Did not recognise 'customers' as a valid data type to be outputted"));

        OutputCommandRunner toBeTested = OutputCommandRunnerFactory.getOutputCommandRunner(args);
        Object outputData = toBeTested.getData();

        assertTrue(toBeTested.getWriter() instanceof FileWriter);
        assertTrue(outputData instanceof List);
        assertTrue((((List) outputData).size() > 0 && ((List) outputData).get(0) instanceof Customer));
    }

    @Test
    public void noWriterArgumentShouldDefaultToConsole() {
        List<String> args = List.of("library");
        assertDoesNotThrow(() -> new IllegalArgumentException("Invalid output write 'console'"));
        assertDoesNotThrow(() -> new IllegalArgumentException("Did not recognise 'library' as a valid data type to be outputted"));

        OutputCommandRunner toBeTested = OutputCommandRunnerFactory.getOutputCommandRunner(args);
        Object outputData = toBeTested.getData();

        assertTrue(toBeTested.getWriter() instanceof ConsoleWriter);
        assertTrue(outputData instanceof List);
        assertTrue((((List) outputData).size() > 0 && ((List) outputData).get(0) instanceof Item));
    }

    @Test
    public void factoryShouldThrowExceptionWhenNoArgs() {
        List<String> args = List.of();
        assertThrows(IllegalArgumentException.class, () -> OutputCommandRunnerFactory.getOutputCommandRunner(args));
    }

    @Test
    public void factoryShouldThrowExceptionWhenInvalidWriterType() {
        List<String> args = List.of("invalidOutput", "library");
        assertThrows(IllegalArgumentException.class, () -> OutputCommandRunnerFactory.getOutputCommandRunner(args));
    }

    @Test
    public void factoryShouldThrowExceptionWhenInvalidDataType() {
        List<String> args = List.of("console", "invalidData");
        assertThrows(IllegalArgumentException.class, () -> OutputCommandRunnerFactory.getOutputCommandRunner(args));
    }
}