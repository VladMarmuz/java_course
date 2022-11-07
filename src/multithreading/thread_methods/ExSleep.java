package multithreading.thread_methods;

public class ExSleep {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Worker());
        System.out.println(thread1.getState());// показывает, в каком состоянии находится поток на данный момент

        thread1.start();
        System.out.println(thread1.getState());

        // thread1.join(1500);//говорит либо жди, пока выполнится поток thread1, либо 1.5 сек
        thread1.join();

        System.out.println(thread1.getState());
        System.out.println("Method main finished");
    }
}

class Worker implements Runnable {

    @Override
    public void run() {
        System.out.println("Work began!");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Work finish");
    }
}
