package IO;

import java.io.*;

public class ReaderWriterExample {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("./src/IO/data/vinh.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null)
                System.out.println(line);
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter writer = new FileWriter("./src/IO/data/vinh.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("hello!");
            bufferedWriter.newLine();
            bufferedWriter.write("gud bye!");
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
