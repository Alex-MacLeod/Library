package library.writer;

import library.util.JSONConverter;

public class ConsoleWriter implements OutputWriter {

    @Override
    public void output(Object obj) {
        JSONConverter.outputJson(obj);
    }
}
