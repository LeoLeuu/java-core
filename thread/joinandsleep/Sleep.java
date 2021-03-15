package thread.joinandsleep;

public class Sleep extends Thread{
    private boolean alive = true;
    @Override
    public void run() {
        super.run();
            for (int i = 0; i < 9; i++) {
                while (alive) {
                    System.out.println("This is " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Finish " + Thread.currentThread().getName());
        }
    public void setAlive(boolean alive){
        this.alive = alive;
    }
}
