package multithreading;

public class SynchronizedBlockEx {
    public static void main(String[] args) {
        //Разбираем ,когда несколько потоков хоят изменить одну переменную
        // lock - замок , ставится на участок кода, для того чтобы этот код в одно и то же время мог выполнять только 1 поток
        MyRunnableImpl2 runnable = new MyRunnableImpl2();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class Counter2 {
    static int count = 0;
}


class MyRunnableImpl2 implements Runnable {

    private void doWork2(){
        System.out.println("Yooooouuu!!!");
    }


    private void doWork1() {
        doWork2();
        // Синхронайз блок, не static метод в скобках пишется объект,монитор которого,
        // мы будем захватывать, а в фигурных пишем код, который должен быть синхронизирован
        // Lock и unlock
        synchronized (this) {
            Counter2.count++;
            System.out.println(Counter2.count);
        }
    }


    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            doWork1();
        }

    }
}
