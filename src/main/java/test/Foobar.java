package test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Foobar {

    static ReentrantLock reentrantLock = new ReentrantLock();
    static Condition f = reentrantLock.newCondition();
    static Condition b = reentrantLock.newCondition();
    private static int n;
    private static volatile int j = 1;
    public Foobar(int n) {
        this.n = n;
    }
    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            reentrantLock.lock();
            while ( j != 1 ){
                f.await();
            }
            printFoo.run();
            j = 2;
            b.signal();
            reentrantLock.unlock();
        }
    }
    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            reentrantLock.lock();
            while (j != 2){
                b.await();
            }
            printBar.run();
            j = 1;
            f.signal();
            reentrantLock.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException {

        Foobar foobar = new Foobar(2);

        new Thread(()->{
            try {
                foobar.foo(()->{ // 打印foo
                    System.out.print("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                foobar.bar(()->{ // 打印bar
                    System.out.print("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

}
























