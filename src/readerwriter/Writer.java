package readerwriter;

public class Writer implements Runnable{
    ReadWritePool pool;
    String name;
    int genConst;
    Writer(ReadWritePool pool, String name, int genConst) {
        this.pool = pool;
        this.genConst = genConst;
        this.name = name;
        new Thread(this, name).start();
    }
    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            pool.write(genConst, name);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                ;
            }
        }
    }
}
