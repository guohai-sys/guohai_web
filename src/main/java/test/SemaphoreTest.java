package test;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println("我抢到车位了："+Thread.currentThread().getName());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("我出来了："+Thread.currentThread().getName());
                    semaphore.release();
                }
            }).start();
        }

    }
}
