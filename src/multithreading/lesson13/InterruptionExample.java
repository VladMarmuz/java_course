package multithreading.lesson13;

public class InterruptionExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Thread starts");
        InterruptedThread thread = new InterruptedThread();
        thread.sleep(3000);
        thread.join();
        thread.interrupt(); // с помощью этого метода посылаем сигнал потоку, что мы хотим его прервать
        System.out.println("Thread ends");

    }

}

class InterruptedThread extends Thread{
    double sumSqrt = 0;

    @Override
    public void run() {

        for (int i = 0; i < 1_000_000_000; i++) {

            if (isInterrupted()){// проверяем хотят ли прервать наш поток
                System.out.println("They want to interrupt our Thread");
                return; // завершаем работу потока
            }
            sumSqrt+=Math.sqrt(i);
            System.out.println(sumSqrt);

        }
    }
}
