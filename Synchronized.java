import static java.lang.Thread.sleep;

public class Synchronized {
    private int a = 0;
    public Synchronized(){}
    public static synchronized void count1(String s){
        for (int i =0;i<5;i++)
            System.out.println(s+ ": a ="+i);
        try {
            sleep(800);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(){
            public void run(){
                Synchronized o1 = new Synchronized();
                o1.count1(Thread.currentThread().getName());
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                Synchronized o2 = new Synchronized();
                o2.count1(Thread.currentThread().getName());
            }
        };
        t1.start();
        t2.start();

    }
}
