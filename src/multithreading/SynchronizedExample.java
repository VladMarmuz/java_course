package multithreading;

public class SynchronizedExample {

    //Если мы хотим сделать синхронизацию нескольких методов, то мы должны все эти методы синхронизировать по одному объекту
    //нельзя синхронизировать конструктор, он и так обрабатывается только одним потоком( так заложено в JWM)
    static final Object lock = new Object(); // создали объект, монитор которого, будем захватытвать (т.е. локать -  вешать замок)


    void mobileCall() {
        synchronized (lock) {
            System.out.println("Mobile call start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Mobile call end!");
        }
    }

    void skypeCall() {
        synchronized (lock) {
            System.out.println("Skype call start");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Skype call end!");
        }
    }

    void whatsappCall() {
        synchronized (lock) {
            System.out.println("Whatsapp call start");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Whatsapp call end!");
        }
    }


    public static void main(String[] args) {

        Thread thread1 = new Thread(new MobileRunnable());
        Thread thread2 = new Thread(new SkypeRunnable());
        Thread thread3 = new Thread(new WhatsappRunnable());
        thread1.start();
        thread2.start();
        thread3.start();


    }
}

class MobileRunnable implements Runnable {

    @Override
    public void run() {
        new SynchronizedExample().mobileCall();
    }
}

class SkypeRunnable implements Runnable {

    @Override
    public void run() {
        new SynchronizedExample().skypeCall();
    }
}

class WhatsappRunnable implements Runnable {

    @Override
    public void run() {
        new SynchronizedExample().whatsappCall();
    }
}
