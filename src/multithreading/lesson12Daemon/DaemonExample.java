package multithreading.lesson12Daemon;

public class DaemonExample {
    public static void main(String[] args) {
        System.out.println("Threads started");
        UserThread userThread = new UserThread();
        DaemonThread daemonThread = new DaemonThread();
        userThread.setName("User_Thread");
        daemonThread.setName("Daemon_Thread");
        // если основные потоки окончили работу, то программа не дожидается выполнения Демон -потока, а завершается
        daemonThread.setDaemon(true);// устанавливаем потоком- демоном
        userThread.start();
        daemonThread.start();

        System.out.println("Threads ended");
    }

}

class UserThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Is Daemon?" + isDaemon());
        for (char i = 'A'; i < 'J'; i++) {
            try {
                Thread.sleep(300);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class DaemonThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Is Daemon?" + isDaemon());
        for (int i = 1; i <1000; i++) {
            try {
                Thread.sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
