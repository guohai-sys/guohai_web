package test;

import java.util.concurrent.*;

public class ConcurrentHashMapTest {

    public static void main(String[] args) {

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
    /**
     *
     *
     *
     */

}
