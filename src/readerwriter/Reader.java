package readerwriter;

public class Reader implements Runnable{
    ReadWritePool pool;
    String name;
    int sleeptime;
    Reader(ReadWritePool pool, String name, int sleeptime) {
        this.pool = pool;
        this.name = name;
        this.sleeptime = sleeptime;
        new Thread(this, name).start();
    }
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            pool.read(name);
            try {
                Thread.sleep(sleeptime);
            } catch (InterruptedException e) {
                ;
            }
        }
    }
}
