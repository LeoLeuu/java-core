package lambda;

public class LambdaExample {
    public static void main(String[] args) {
        Runnable runnable = ()-> {
            System.out.println("lambda...");
        };
        new Thread(runnable).start();
    }
}
