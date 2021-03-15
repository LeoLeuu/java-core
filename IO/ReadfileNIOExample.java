package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadfileNIOExample {

    public static void main(String[] args) {
            File file = new File("./src/IO/data/vinh.txt");
            FileInputStream f_in;
            FileOutputStream f_out;
//          read file
            try {
                f_in = new FileInputStream(file);
                FileChannel f_chan = f_in.getChannel();
                long f_size = f_chan.size();
                ByteBuffer buffer = ByteBuffer.allocate((int) f_size);
                f_chan.read(buffer);
                buffer.rewind();
                String s = new String(buffer.array());
                System.out.println(s);
                f_chan.close();
                f_in.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
//          write file
            try {
                f_out = new FileOutputStream(file);
                FileChannel f_chan = f_out.getChannel();
                String s = "Hello";
                byte[] data = s.getBytes();
                ByteBuffer buffer = ByteBuffer.allocateDirect(data.length);
                for (int i = 0; i < data.length; i++)
                    buffer.put(data[i]);
                buffer.rewind();
                f_chan.write(buffer);
                f_chan.close();
                f_out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
