package readerwriter;

public class Tester {
    public static void main(String[] args) {
        ReadWritePool pool = new ReadWritePool();
        Writer w1 = new Writer(pool, "w1", 1);
        Reader r1 = new Reader(pool, "r1", 200);
        Reader r2 = new Reader(pool, "r2", 300);
        Writer w2 = new Writer(pool, "w2", 2);
        Writer w3 = new Writer(pool, "w3", 3);
        Reader r3 = new Reader(pool, "r3", 400);
    }
}
