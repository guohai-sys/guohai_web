package test;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTestDemo {

    public static void main(String[] args) {
        LinkedList<String> food = new LinkedList<>();
        int number = 5;
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        Chef chef = new Chef(food, number, condition, reentrantLock);
        Guest guest = new Guest(food, number, condition, reentrantLock);
        new Thread(()->{
            chef.deal();
        }).start();
        new Thread(()->{
            guest.eat();
        }).start();
    }

}
