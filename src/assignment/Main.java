package assignment;

public class Main {
    public static void main(String[] args) {
        Buffer<Integer> buffer = new Buffer<>(5);
        for (int i = 0; i < 5; i++) {
            new Producer(buffer, "Producer " + i, (i+1)*1117);
        }
        for (int i = 0; i < 6; i++) {
            new Consumer(buffer, "Consumer " + i, (i+1) * 1729);
        }
    }
}
