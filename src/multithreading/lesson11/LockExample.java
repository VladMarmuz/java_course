package multithreading.lesson11;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    public static void main(String[] args) {
        Call call = new Call();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.mobileCall();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.skypeCall();
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.whatsappCall();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }



}

class Call {
    Lock lock = new ReentrantLock();

    public void mobileCall(){
        lock.lock(); // локает код для выполнения только одним объектом
        try {
            System.out.println("Mobile call began");
            Thread.sleep(3000);
            System.out.println("Mobile call ended");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock(); // разблокирует код для доступа дугих потоков
        }
    }
    public void skypeCall(){
        lock.lock(); // локает код для выполнения только одним объектом
        try {
            System.out.println("Skype call began");
            Thread.sleep(5000);
            System.out.println("Skype call ended");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock(); // разблокирует код для доступа дугих потоков
        }
    }
    public void whatsappCall(){
        lock.lock(); // локает код для выполнения только одним объектом
        try {
            System.out.println("Whatsapp call began");
            Thread.sleep(7000);
            System.out.println("Whatsapp call ended");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock(); // разблокирует код для доступа дугих потоков
        }
    }
}
