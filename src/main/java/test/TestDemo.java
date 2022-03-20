package test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestDemo {
    static ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {

        ConcurrentHashMap chm = new ConcurrentHashMap<>();
        chm.put("","");
        System.out.println(12 >>> 16);
        System.out.println(Integer.numberOfLeadingZeros(16) | (1 << (16 - 1))); // 0000 0000 0000 0000 0000 0000 0001 0000
        Condition condition = reentrantLock.newCondition();
        test1();

    }
    private static void test1() {
        try{
            test2();
            reentrantLock.lock();
        }catch (Exception e){

        }finally{
            reentrantLock.unlock();
        }
    }
    private static void test2() {
        try{
            reentrantLock.lock();
        }catch (Exception e){
        }finally{
            reentrantLock.unlock();
        }
    }
}
