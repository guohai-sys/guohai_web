package test;

import java.util.concurrent.*;

public class ThreadPoolExcutorTest {

    public static void main(String[] args) {
        ExecutorService es1 = Executors.newCachedThreadPool();
        ExecutorService es2 = Executors.newFixedThreadPool(5);
        ExecutorService es3 = Executors.newSingleThreadExecutor();
        ExecutorService ess1 = Executors.newScheduledThreadPool(100);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 1, TimeUnit.SECONDS
                , new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        //threadPoolExecutor.allowCoreThreadTimeOut(true);
        for (int i = 0; i < 6; i++) {
            threadPoolExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName());
                BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
                System.out.println("sssssssssssssssssssssssss"+queue.size());
                while(true){
                    int j =0;
                    j++;
                }
            });
        }
        BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
        System.out.println("sssssssssssssssssssssssss"+queue.size());

    }

}
