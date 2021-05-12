package assignment;


import java.util.Random;

public class Producer implements Runnable{
    private final Buffer<Integer> buffer;
    private final int sleeptime;
    Producer(Buffer<Integer> buffer, String threadname, int sleeptime) {
        this.buffer = buffer;
        this.sleeptime = sleeptime;
        new Thread(this, threadname).start();
    }

    @Override
    public void run() {
        Random generator = new Random();
        try {
            //Every producer produces 6 integers. I decided to restrict instead of running them indefinitely
            for(int i = 0; i < 6; i++) {
                //randomly generates a interger
                int generated = generator.nextInt(100);
                //generated value is put into the buffer
                buffer.put(generated, Thread.currentThread().getName());
                Thread.sleep(sleeptime);
            }
        } catch (InterruptedException e) {
            //do nothing
        }
        System.out.println(Thread.currentThread().getName() + " completed production.");
    }
}
