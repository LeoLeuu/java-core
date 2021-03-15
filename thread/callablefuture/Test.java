package thread.callablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
        List<Future<Integer>> list= new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Callable<Integer> callable;
        Future<Integer> future;
//        for (int i = 1;i<11;i++){
//            callable = new CallableWork(i);
//            future = executor.submit(callable);
//            list.add(future);
//        }
        List<Callable<Integer>> callables = new ArrayList<>();
        for (int i=1;i<=10;i++){
            callables.add(new CallableWork(i));
        }
        List<Future<Integer>> futures = null;
        try {
            futures = executor.invokeAll(callables);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        while (!executor.isTerminated()){}
        for (Future<Integer> f:futures){
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
//        for (Future<Integer> f: list){
//            try {
//                System.out.println(f.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
        System.out.println("Finish all!");
    }
}
