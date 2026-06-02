import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LegacyFileHandling {
    public static void main(String[] args) throws IOException {

        // Create and write to a resource file
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/resource/file_handling/cricket.txt"))){
            bw.write("player-name, country");
            bw.newLine();
            bw.write("Chris Gayle, Windies");
            bw.newLine();
            bw.write("Josh Butler, England");
            // bw.close() is called automatically
        }

        // Read data from a resource file
        try(BufferedReader reader = new BufferedReader(new FileReader("src/resource/file_handling/cricket.txt"))){
            String line;
            List<String> list = new ArrayList<>();
            while((line = reader.readLine()) != null) list.add(line);
            System.out.println(list);
        }
    }
}
