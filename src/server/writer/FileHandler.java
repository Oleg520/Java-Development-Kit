package server.writer;

import java.io.*;

public class FileHandler implements Writer {
    private File filePath;

    @Override
    public boolean save(String text) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(text);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String read() {
        try (FileReader reader = new FileReader(filePath)) {
            StringBuilder s = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                s.append((char) c);
            }
            return s.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void setPath(File filePath) {
        this.filePath = filePath;
    }
}
