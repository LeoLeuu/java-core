package thread;

import java.util.concurrent.TimeUnit;
import static java.util.Arrays.stream;

public class RunnableExample implements Runnable{
    private String message;


    public RunnableExample(String message){
        this.message = message;
    }
    @Override
    public void run() {
        String[] elements = message.split(" ");
        stream(elements).forEach(ele ->{
            System.out.println(Thread.currentThread().getName()+" print "+ele);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
    static class ThreadTest{
        public static void main(String[] args) {
            RunnableExample message = new RunnableExample("Say hello! ");
            new Thread(message).start();
        }
    }
}
