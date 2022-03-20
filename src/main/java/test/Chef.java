package test;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Chef {

    private LinkedList<String> food;
    private int number;
    private Condition condition;
    private ReentrantLock reentrantLock;

    public Chef(LinkedList<String> food, int number, Condition condition, ReentrantLock reentrantLock) {
        this.food = food;
        this.number = number;
        this.condition = condition;
        this.reentrantLock = reentrantLock;
    }

    public void deal(){

        while (true){
            reentrantLock.lock();
            try {
                while (food.size() == number){
                    System.out.println("做完饭了，我睡觉了！");
                    condition.await();
                }
                food.addFirst("饭");
                System.out.println("饭熟了！"+"还有:"+food.size()+"碗");
                condition.signal();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }

    }

}
