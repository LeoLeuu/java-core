package thread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ReadWriteLockExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Map<String,String> map = new HashMap<>();

        executor.submit(()->{
            System.out.println("Start writing...");
            try {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                map.put("foo","bar");
            } finally {
                System.out.println("end writing");
            }
        });
        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                System.out.println("Start reading");
                try {
                    System.out.println(map.get("foo"));
                } finally {
                    System.out.println("end reading");
                }
            }
        };
        executor.submit(readTask);
//        ReadWriteLock lock = new ReentrantReadWriteLock();
//
//        executor.submit(()->{
//            System.out.println("Star writing");
//            lock.writeLock().lock();
//            try {
//                try {
//                    TimeUnit.SECONDS.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                map.put("foo","bar");
//            } finally {
//                lock.writeLock().unlock();
//                System.out.println("end writing");
//            }
//        });
//        Runnable readTask = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Star reading");
//                lock.readLock().lock();
//                try {
//                    System.out.println(map.get("foo"));
//                } finally {
//                    lock.readLock().unlock();
//                    System.out.println("end reading");
//                }
//            }
//        };
//        executor.submit(readTask);
    }
}
