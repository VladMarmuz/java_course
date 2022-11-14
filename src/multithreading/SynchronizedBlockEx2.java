package multithreading;

public class SynchronizedBlockEx2 {
    static int count= 0;

    // Если метод static, то в synchronised блоке пишется не объект , а класс
    public static synchronized void increment(){
        synchronized (SynchronizedBlockEx2.class) {
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new R2());
        Thread thread2 = new Thread(new R2());
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(count);
    }
}

class R2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            SynchronizedBlockEx2.increment();
        }

    }
}
