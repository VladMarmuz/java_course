package multithreading.lessaon1create_thread;

public class NewThreadExamples {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        myThread1.start();//запускаем потоки
        myThread2.start();

    }
}


//cоздаём 2 новых потока
class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 1000; i >0 ; i--) {
            System.out.println(i);
        }
    }
}
