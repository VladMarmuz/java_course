package multithreading.lesson15_callable_future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunnableFactorial {
    static int resultFactorial;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial factorial = new Factorial(5);
        executorService.execute(factorial);
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(resultFactorial);
    }


}


class Factorial implements Runnable {
    int countFactorial;

    public Factorial(int countFactorial) {
        this.countFactorial = countFactorial;
    }

    @Override
    public void run() {
        if (countFactorial <= 0) {
            System.out.println("You input isn't correct");
        }

        int result = 1;
        for (int i = 1; i <= countFactorial; i++) {
            result *= i;
        }
        RunnableFactorial.resultFactorial += result;

    }
}