
import java.io.IOException;

public class ExceptionChaining{

    static class DataException extends RuntimeException {
        public DataException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    static class ServiceException extends RuntimeException {
        public ServiceException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    // layer 1: low-level I/O fails
    static void readFromDisk() throws IOException {
        throw new IOException("disk read error");
    }

    // layer 2: data layer wraps the IOException
    static void loadRecord() {
        try {
            readFromDisk();
        } catch (IOException e) {
            throw new DataException("could not load record", e);
        }
    }

    // layer 3: service layer wraps the DataException
    static void handleRequest() {
        try {
            loadRecord();
        } catch (DataException e) {
            throw new ServiceException("request failed", e);
        }
    }

    public static void main(String[] args) {
        try {
            handleRequest();
        } catch (ServiceException e) {
            // walk the chain manually
            Throwable current = e;
            while (current != null) {
                System.out.println(current.getClass().getSimpleName() + ": " + current.getMessage());
                current = current.getCause();
            }
        }
    }
}