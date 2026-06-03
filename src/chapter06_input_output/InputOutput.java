import java.io.*;

/**
 * 1. FileWriter - write to file
 * 2. FileReader - read from file
 * 3. BufferedWriter - write with buffer
 * 4. BufferedReader - read with buffer
 * 5. FileInputStream - read bytes
 * 6. FileOutputStream - write bytes
 * 7. File - file operations
 */
public class InputOutput {
    public static void main(String[] args) throws IOException {
        // 1. FileWriter
        FileWriter fw = new FileWriter("fundamentals/chapter6_input_output/files/output.txt");
        int i = 0;
        while (i < 1_000) {
            fw.write("I love Factorio\n");
            fw.write("I love Coding\n");
            fw.write("I love Java\n");
            i++;
        }
        fw.close();

        // 2. BufferedWriter - write with buffer, faster for large files
        BufferedWriter bw = new BufferedWriter(new FileWriter("fundamentals/chapter6_input_output/files/bufferedWriter.txt"));
        int j = 0;
        while (j < 1_000) {
            bw.write("I love Factorio\n");
            bw.write("I love Coding\n");
            bw.write("I love Java\n");
            j++;
        }
        bw.close();

        // 3. FileReader
        FileReader fr = new FileReader("fundamentals/chapter6_input_output/files/output.txt");
        int c;
        while ((c = fr.read()) != -1) {
            System.out.print((char) c);
        }
        fr.close();

        // 4. BufferReader - read with buffer, faster for large files
        BufferedReader br = new BufferedReader(new FileReader("fundamentals/chapter6_input_output/files/output.txt"));
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();

        // 5. FileInputStream & FileOutputStream - write bytes
        FileInputStream imageProcessor = new FileInputStream("fundamentals/chapter6_input_output/files/image.jpg");
        FileOutputStream imageCopier= new FileOutputStream("fundamentals/chapter6_input_output/files/image_copy.jpg");
        int b;
        while ((b = imageProcessor.read()) != -1) {
            imageCopier.write(b);
        }
        imageProcessor.close();
        imageCopier.close();

        // 6. File operations
        File file = new File("fundamentals/chapter6_input_output/files/output.txt");
        System.out.println(file.exists());
        System.out.println(file.getName());
        System.out.println(file.length());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        // file.delete(); this deletes the output.txt file
    }
}
