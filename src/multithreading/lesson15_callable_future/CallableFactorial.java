package multithreading.lesson15_callable_future;

import java.util.concurrent.*;

public class CallableFactorial {
    static int resultFactorial;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial2 factorial2 = new Factorial2(5);
        Future<Integer> submit = executorService.submit(factorial2);//Для Callable используется метод submit;

        try {
            // вызов этого метода будет полюбому ждаь пока отработает поток, чтобы забрать результат из Future
            resultFactorial = submit.get(); // получаем наш результат из объекта Future
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            System.out.println((e.getCause()));
        }finally {
            executorService.shutdown();
        }
        System.out.println(resultFactorial);
    }

}


class Factorial2 implements Callable<Integer> {
    int f;

    public Factorial2(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        int result = 1;
        if (f <= 0) {
            throw new Exception("You input isn't correct number ");
        }
            for (int i = 1; i <= f; i++) {
                result *= i;

        }
        return result;

    }
}
