package multithreading;

public class Ex2 {
    //Разбираем ,когда несколько потоков хоят изменить одну переменную
    // lock - замок , ставится на участок кода, для того чтобы этот код в одно и то же время мог выполнять только 1 поток
    static int count= 0;

    public static synchronized void increment(){
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new R());
        Thread thread2 = new Thread(new R());
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(count);
    }
}

class R implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Ex2.increment();
        }

    }
}
