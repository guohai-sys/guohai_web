package test;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockedQueueTest {

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<String> arrayBlockedQueue = new ArrayBlockingQueue<>(5);
        arrayBlockedQueue.put("aa");
        arrayBlockedQueue.take();
        String remove = arrayBlockedQueue.remove();
    }

}
