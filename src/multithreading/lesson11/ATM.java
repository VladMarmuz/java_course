package multithreading.lesson11;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ATM {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        new User("Vlad", lock);
        new User("Kirill", lock);
        new User("Egor", lock);
        Thread.sleep(5000);
        new User("Denis", lock);
        new User("Matvey", lock);

    }
}

class User extends Thread{
    String name;
    Lock lock;

    public User(String name, Lock lock){
        this.name = name;
        this.lock=lock;
        this.start();
    }

    public void run(){
       /* System.out.println(name + " waiting ");
        lock.lock();*/
        if (lock.tryLock()) {// если поток смог захватить монитор , то выводи инфу иначе другую

            try {
                System.out.println(name + " started operation");
                Thread.sleep(3000);
                System.out.println(name + " finished operation");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }else
            System.out.println(name+ "Doesn't want to waiting for atm");

    }
}

