package callablefuture;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableWork implements Callable<Integer> {
    private Random ran = new Random();
    public int n;
    public CallableWork(int n){
        this.n = n;
    }
    @Override
    public Integer call() throws Exception {
        Thread.sleep(ran.nextInt(10)*1000);
        int result = n*n;
        System.out.println("Finish "+n);
        return result;
    }
}
