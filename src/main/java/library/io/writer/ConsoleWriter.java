package library.io.writer;

import library.io.JSONConverter;

public class ConsoleWriter implements OutputWriter {

    @Override
    public void output(Object obj) {
        JSONConverter.outputJson(obj);
    }
}
