package exercise.Vebinar14_25_08_13.logger.impl.files;

public class TxtFileLogger extends FileLogger {

    public TxtFileLogger(String fileName) {
        super.fileName = fileName + getFileExtension();
    }

    public TxtFileLogger() {
        super();
    }

    @Override
    public String getFileExtension() {
        return ".txt";
    }
}
