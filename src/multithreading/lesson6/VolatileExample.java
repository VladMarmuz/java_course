package multithreading.lesson6;

public class VolatileExample extends Thread {
    volatile boolean  b = true; //volatile означает , что значение переменной будет храниться в основной память(main memory)
    // Но использовать его можно только тогда, когда только 1 поток изменяет переменную ,а другие только читают

    @Override
    public void run() {
        int i = 0;
        while (b) {
            i++;
        }
        System.out.println("Loop si finished i = " + i);
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileExample thread = new VolatileExample();
        thread.start();

        Thread.sleep(3000);
        System.out.println("After 3 seconds it is time for wake up");
        thread.b = false;
        thread.join();
        System.out.println("The programme is finished ");


    }
}
