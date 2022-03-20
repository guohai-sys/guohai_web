package test;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Guest {

    private LinkedList<String> food;
    private int number;
    private Condition condition;
    private ReentrantLock reentrantLock;

    public Guest(LinkedList<String> food, int number, Condition condition, ReentrantLock reentrantLock) {
        this.food = food;
        this.number = number;
        this.condition = condition;
        this.reentrantLock = reentrantLock;
    }

    public void eat(){

        while (true){
            reentrantLock.lock();
            try {
                while (food.size() == 0){
                    System.out.println("没有饭吃了，我睡觉了！");
                    condition.await();

                }
                food.removeLast();
                System.out.println("吃饭了！"+"还有:"+food.size()+"碗");
                condition.signal();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }

        }

    }

}
