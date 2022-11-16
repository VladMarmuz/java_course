package multithreading.lesson14ThreadPool;

import java.util.concurrent.*;

public class ThreadPoolEx2 {
    public static void main(String[] args) throws InterruptedException {
        // создаёт потоки по надобности и если через 60 сек новое задание не пришло то незадействованные потоки удаляются
        ExecutorService executorService1 = Executors.newCachedThreadPool();


        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);

        // говорит, что выполни этот класс через 5 минут
       // executorService.schedule(new RunImplEx2(),5, TimeUnit.SECONDS);

        // впервые задача выполнится через 3 секунды,а 1 cек - это время с начала выполнения первого таска до начала выполнения 2-го таска
        // executorService.scheduleAtFixedRate(new RunImplEx2(),3,1,TimeUnit.SECONDS);

        // впервые задача выполнится через 3 секунды,а затем будет выполняться через 1 секунду
        executorService.scheduleWithFixedDelay(new RunImplEx2(),3,1,TimeUnit.SECONDS);
        Thread.sleep(20000);

        executorService.shutdown();// прекращает работу ExecutorService
    }

}
class RunImplEx2 implements Runnable{


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"Begins work");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+"Ends work!");

    }
}