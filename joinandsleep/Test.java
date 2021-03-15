package joinandsleep;

public class Test {
    public static void main(String[] args) {
        Sleep sleep = new Sleep();
        Sleep sleep1 = new Sleep();
        sleep.start();
        try {
            sleep.join(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sleep.setAlive(false);
        sleep1.start();
        try {
            sleep1.join(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sleep1.setAlive(false);
    }
}
