package readerwriter;

import java.util.concurrent.Semaphore;

public class ReadWritePool {
    private int data = 0;
    private int numOfReaders = 0;

    static Semaphore semRead = new Semaphore(1);
    static Semaphore semWrite = new Semaphore(1);

    boolean admitReader() {
        try {
            semRead.acquire();
            if (numOfReaders == 0)
                semWrite.acquire();
            numOfReaders++;
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }
    void releaseReader() {
        if (--numOfReaders == 0)
            semWrite.release();
        semRead.release();
    }

    void read(String name) {
        if (admitReader()) {
            System.out.println("Reader " + name + " reads: " + data);
            releaseReader();
        }
    }

    void write(int step, String name) {
        try {
            semWrite.acquire();
        } catch (InterruptedException e) {
            ;
        }
        this.data += step;
        System.out.println("Writer " + name + " writes: " + data);
        semWrite.release();
    }
}
