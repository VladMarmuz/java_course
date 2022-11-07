package multithreading.thread_methods;

public class ThreadMethods2 extends Thread{
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        /*for (int i = 0; i < 5; i++) {
            System.out.println(i);
            Thread.sleep(1000);// заставляет поток заснуть на некоторое время ( в данный момент на 1 сек.==1000 милисекунд)
        }
        System.out.println("Let's goooo!");*/

        Thread thread1 = new Thread(new MyRunnable());
        ThreadMethods2 thread2 = new ThreadMethods2();
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();// main будет ждать пока выполнится поток, у которого вызван метод join() и потом продолжит своё выполненине

        System.out.println("The end");

        
    }
}


class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName()+" "+ i);
        }
    }
}
