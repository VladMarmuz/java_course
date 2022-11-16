package multithreading.lesson17_atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicEx {
    static AtomicInteger count = new AtomicInteger();//

    public  static void increment(){
        count.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyCounter());
        Thread thread2 = new Thread(new MyCounter());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count);


    }
}

class MyCounter implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            AtomicEx.increment();
        }
    }
}
