package test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(()->{
            try {
                System.out.println("初级程序员来了！");
                countDownLatch.await();
                System.out.println("我是初级程序员：小李");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                System.out.println("中级程序员来了！");
                countDownLatch.await();
                System.out.println("我是中级程序员：小王");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                System.out.println("高级程序员来了！");
                countDownLatch.await();
                System.out.println("我是高级程序员：小张");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(3000);
        System.out.println("----------------------------------------");
        System.out.println("项目经理来了，大家开始自我介绍把！");
        countDownLatch.countDown();
    }
}
