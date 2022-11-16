package multithreading.lesson1create_thread;

public class RunnableEx2 extends Thread {
    @Override
    public void run() {
        System.out.println("Method run. Thread name = "+ Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        //нельзя запускать методом run(только методом start()), потому что он не запустит новый поток,
        // а просто будет выполнен метод run потоком main

        RunnableEx2 thread = new RunnableEx2();
        // thread.run(); // так нельзя!
        thread.start();
        System.out.println("Method run. Thread name = "+ Thread.currentThread().getName());
    }

}
