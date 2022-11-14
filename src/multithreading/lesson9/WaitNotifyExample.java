package multithreading.lesson9;

public class WaitNotifyExample {
    public static void main(String[] args) {
        Market market = new Market();
        Consumer consumer = new Consumer(market);
        Producer producer = new Producer(market);
        Thread threadConsumer = new Thread(consumer);
        Thread threadProducer = new Thread(producer);
        threadConsumer.start();
        threadProducer.start();


    }
}

class Market {
    private int breadCount = 0;

    public synchronized void getBread() {
        while (breadCount < 1) {
            try {
                wait(); // можем написать сколько секунд нужно ждать wait(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        breadCount--;
        System.out.println("Потребитель купил 1 булку хлеба");
        System.out.println("Количество хлеба = " + breadCount);
        notify();
    }

    public synchronized void putBread() {
        while (breadCount >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        breadCount++;
        System.out.println("Производитель положил одну булку хлеба ");
        System.out.println("Колличество хлеба в магазине " + breadCount);
        notify();
    }

}

class Producer implements Runnable {
    Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putBread();
        }
    }
}


class Consumer implements Runnable {
    Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {


    }
}

