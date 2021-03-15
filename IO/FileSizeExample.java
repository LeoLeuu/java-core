package IO;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class FileSizeExample {
    static AtomicLong length = new AtomicLong();
    public static void main(String[] args) {
        File file = new File("./src/IO/data");
        System.out.println(file.isFile());
        System.out.println(getSize(file));
    }
    public static long getSize(File file){
        if (file.isFile()) return file.length();

        Arrays.stream(file.listFiles()).forEach(f ->{
            length.getAndSet(length.longValue()+(f.isDirectory() ? getSize(f) : f.length()));
        });
        return length.longValue();
    };
}
