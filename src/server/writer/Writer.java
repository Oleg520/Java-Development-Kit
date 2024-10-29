package server.writer;

import java.io.File;

public interface Writer {
    boolean save(String text);

    String read();

    void setPath(File filePath);
}
