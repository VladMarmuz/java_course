package multithreading.lessaon1create_thread;

public class RunnableEx {
    // с помощью Runnable чаще всего создаются потоки
    public static void main(String[] args) {
        Thread thread1= new Thread(new MyThread3());
        Thread thread2= new Thread(new MyThread4());

        // можно создать поток с помощью анонимного класса
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        }).start();

        new Thread(()-> System.out.println("Good Bye!")).start();

        thread1.start();
        thread2.start();

    }
}

class MyThread3 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}

class MyThread4 implements Runnable{

    @Override
    public void run() {
        for (int i = 1000; i > 0; i--) {
            System.out.println(i);
        }
    }
}
