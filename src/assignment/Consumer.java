package assignment;


public class Consumer implements Runnable{
    private final Buffer<Integer> buffer;
    private final int sleeptime;

    Consumer(Buffer<Integer> buffer, String threadname, int sleeptime) {
        this.buffer = buffer;
        this.sleeptime = sleeptime;
        new Thread(this, threadname).start();
    }

    @Override
    public void run() {
        try {
            //every conusmer consumes 6 integers, not mandatory but i decided to distribute 30 integers equally
            for (int i = 0; i < 5; i++) {
                buffer.remove(Thread.currentThread().getName());
                Thread.sleep(sleeptime);
            }
        } catch (InterruptedException e) {
            //do nothing
        }
        System.out.println(Thread.currentThread().getName() + " Completed consumption.");
    }
}
