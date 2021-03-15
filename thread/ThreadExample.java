package thread;

public class ThreadExample extends Thread{
    @Override
    public void run() {
        for (int i=0;i<20;i++) {
            System.out.println("Inside: " + Thread.currentThread().getName());
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
    public static class MainThread {
        public static void main(String[] args) {
            ThreadExample threadExample = new ThreadExample();
            int num = 0;
            threadExample.start();
            for (int i=0;i<20;i++)
                System.out.println("Main: "+ Thread.currentThread().getName());
        }
    }
}

