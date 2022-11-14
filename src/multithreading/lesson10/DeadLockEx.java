package multithreading.lesson10;

public class DeadLockEx {

    // в этом примере 2 потока могут ждать друг друга до бесконечности - DeadLock-
    // т.к. они пытаются захватить монитор объектов, которые захвачены ими же (они ждут пока освободятся мониторы)
    // но иногда один потока может  оказаться быстрее другого и токой ситуации не произойдёт
    public static final Object lock1 = new Thread();
    public static final Object lock2 = new Thread();

    public static void main(String[] args) {

        Thread10 thread10 = new Thread10();
        Thread20 thread20 = new Thread20();
        thread10.start();
        thread20.start();
    }




}

class Thread10 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread10: Попытка завхватить монитор объекта lock1");
        synchronized (DeadLockEx.lock1) {
            System.out.println("Thread10: Монитор объекта lock1 захвачен");
            System.out.println();
            System.out.println("Thread10: Попытка завхватить монитор объекта lock2");
            synchronized (DeadLockEx.lock2) {
                System.out.println("Thread10: Монитор объектов lock2,lock1 захвачен");
            }

        }
    }
}

class Thread20 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread20: Попытка завхватить монитор объекта lock2");
        synchronized (DeadLockEx.lock2) {
            System.out.println("Thread20: Монитор объекта lock2 захвачен");
            System.out.println();
            System.out.println("Thread20: Попытка завхватить монитор объекта lock1");
            synchronized (DeadLockEx.lock1) {
                System.out.println("Thread20: Монитор объектов lock2,lock1 захвачен");
            }

        }
    }
}