import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ThrowAndWrap {

    static class ConfigException extends RuntimeException{
        public ConfigException(String message, Throwable cause){
            super(message, cause);
        }
    }

    public static String loadConfig(String path){
        try{
            return Files.readString(Path.of(path));
        } catch(IOException e){
            throw new ConfigException("Failed to load config from " + path, e);
        }
    }

    public static void main(String[] args){
        loadConfig("does-not-exists.txt");
    }
}
