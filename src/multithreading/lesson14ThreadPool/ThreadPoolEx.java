package multithreading.lesson14ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolEx {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();// создаёт один поток в пуле

        ExecutorService executorService = Executors.newFixedThreadPool(5); // создаём Thread Pool  с 5-ю потоками с помощью фактори метода

        for (int i = 0; i <10 ; i++) {
            executorService.execute(new RunImplEx()); // наши 5 потоков будут выполнять код
        }
        executorService.shutdown();// закрываем работу ExecutorService ( т.е. мы говорим ему, что задач больше не будет)
        executorService.awaitTermination(5, TimeUnit.SECONDS);// заставляет ждать поток в котором он вызывается(что раньше :либо 5 сек, либо пока выполнится)

        System.out.println("Main the end");

    }


}

class RunImplEx implements Runnable{

    @Override
    public void run() {
        System.out.println("Begins work");
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ends work!");

    }
}
