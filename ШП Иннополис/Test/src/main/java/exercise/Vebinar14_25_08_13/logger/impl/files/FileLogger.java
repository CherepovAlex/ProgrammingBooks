package exercise.Vebinar14_25_08_13.logger.impl.files;

import exercise.Vebinar14_25_08_13.logger.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public abstract class FileLogger implements Logger {
    protected String fileName;

    public abstract String getFileExtension();

    public FileLogger() {
        this.fileName = "default_logger" + getFileExtension();
    }

    @Override
    public void log(String data) {
        try (Writer writer = new FileWriter(fileName, true)) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
