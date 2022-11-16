package multithreading.lesson16_semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore callBox = new Semaphore(2);
        new Person("Vlad", callBox);
        new Person("Egor", callBox);
        new Person("Valya", callBox);
        new Person("Nikita", callBox);
        new Person("Katya", callBox);
    }
}

class Person extends Thread{
    String name;
    private Semaphore callBox;

    public Person(String name, Semaphore callBox){
        this.name = name;
        this.callBox = callBox;
        this.start();
    }

    @Override
    public void run() {
        try {
            System.out.println(name+ " waiting");
            callBox.acquire();// попытка получить разрешение от Semaphore
            System.out.println(name+ " use the phone");
            Thread.sleep(2000);
            System.out.println(name+" ends call");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            callBox.release();// освобождаем семафор
        }
    }
}
