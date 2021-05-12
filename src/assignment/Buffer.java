package assignment;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer<Task> {
    private final Queue<Task> queue;
    private final int maxsize;
    public Buffer(int size) {
        this.maxsize = size;
        queue = new LinkedList<>();
    }
    public synchronized void put(Task task, String producername) throws InterruptedException {
        while (queue.size() == maxsize) wait();
        System.out.println(producername + " Produced " + task.toString());
        queue.add(task);
        notifyAll();
    }
    public synchronized void remove(String consumername) throws InterruptedException {
        while (queue.isEmpty()) wait();
        Task removedTask = queue.poll();
        System.out.println(consumername + " Consumed " + removedTask.toString());
        notifyAll();
    }
}
