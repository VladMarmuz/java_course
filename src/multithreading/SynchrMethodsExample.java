package multithreading;

public class SynchrMethodsExample {
    public static void main(String[] args) {
        //Разбираем ,когда несколько потоков хоят изменить одну переменную
        // lock - замок , ставится на участок кода, для того чтобы этот код в одно и то же время мог выполнять только 1 поток
        MyRunnableImpl runnable = new MyRunnableImpl();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class Counter {
    static int count = 0;
}


class MyRunnableImpl implements Runnable {

    public synchronized void increment(){
        Counter.count++;
        System.out.print("Count = "+ Counter.count+ " "+ Thread.currentThread().getName()+" ");
    }


    @Override
    public void run() {
        for (int i = 0; i <3 ; i++) {
           increment();
        }

    }
}
