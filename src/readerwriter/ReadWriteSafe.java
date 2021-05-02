package readerwriter;

public class ReadWriteSafe implements ReadWrite{
    private int readers = 0;
    private boolean writing = false;

    @Override
    public void acquireRead() throws InterruptedException {
        while (writing) wait();
        ++readers;
    }

    @Override
    public void releaseRead() {
        --readers;
        if (readers == 0) notify();
    }

    @Override
    public void acquireWrite() throws InterruptedException {
        while (readers != 0 || writing) wait();
        writing = true;
    }

    @Override
    public void releaseWrite() {
        writing = false;
        notifyAll();
    }
}

