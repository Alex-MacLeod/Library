package library.commandrunner.io.writer;

import library.util.JSONConverter;

import java.io.IOException;

public class FileWriter implements OutputWriter {

    @Override
    public void output(Object obj) {
        try {
            JSONConverter.writeJson(obj, "/output.txt");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
