package multithreading.thread_methods;

public class ThreadMethods {
    public static void main(String[] args) {
        MyThread5 myThread5 = new MyThread5();

        // устанавливаем имя и приоритет потоку(от 0 до 10)
        myThread5.setName("My thread");
        myThread5.setPriority(Thread.MAX_PRIORITY);
        myThread5.setPriority(Thread.MIN_PRIORITY);// можно указать любой
        myThread5.setPriority(Thread.NORM_PRIORITY);
        System.out.println("Name of myThread5: "+ myThread5.getName()+"" +
                "\n Priority myThread5: "+ myThread5.getPriority());

    }
}

class MyThread5 extends Thread{
    @Override
    public void run() {
        System.out.println("Hello");
    }
}
