import java.util.*;

/**
 * Thread: a single path of execution that runs independently and at the same time as
 * other threads. The main method runs on one thread; you can start more to do work in parallel.
 *
 * Significance of thread: one thread does tasks one after another. Multiple threads let work
 * happen at once - download files, play music, and auto-save together instead of waiting.
 * This file covers the two ways to make a thread and the common controls on one.
 *
 * 1. Extending Thread - subclass Thread, override run(), call start()
 * 2. Implementing Runnable - pass a task to a Thread (preferred, doesn't use up your one superclass)
 * 3. Thread.sleep(ms) - pause the current thread for given milliseconds
 * 4. thread.join() - make the caller wait until that thread finishes
 * 5. getName() / setName() - read or label a thread
 * 6. getPriority() / setPriority() - hint at scheduling order, 1(low) to 10(high), default 5
 * 7. thread.isAlive() - true if the thread has started and not yet finished
 * 8. Thread.currentThread() - the thread running this line right now
 */
public class Threads {
    public static void main(String[] args) throws InterruptedException {

        // 1. Extending Thread class
        class MyThread extends Thread {
            public void run() {
                System.out.println("Thread running: " + getName());
            }
        }
        MyThread t1 = new MyThread();
        t1.start();

        // 2. Implementing Runnable interface
        Runnable r = () -> System.out.println("Runnable running: " + Thread.currentThread().getName());
        Thread t2 = new Thread(r);
        t2.start();

        // 3. Thread.sleep(ms)
        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Woke up after 1 second");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t3.start();

        // 4. thread.join() - main thread waits for t3 to finish
        t3.join();
        System.out.println("t3 finished");

        // 5. thread.getName() / thread.setName()
        Thread t4 = new Thread(() -> System.out.println("My name is: " + Thread.currentThread().getName()));
        t4.setName("FactorioThread");
        t4.start();

        // 6. thread.getPriority() / thread.setPriority() - 1(low) to 10(high), default 5
        Thread t5 = new Thread(() -> System.out.println("Priority: " + Thread.currentThread().getPriority()));
        t5.setPriority(Thread.MAX_PRIORITY);
        t5.start();

        // 7. thread.isAlive()
        Thread t6 = new Thread(() -> {
            try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
        });
        t6.start();
        System.out.println("t6 alive: " + t6.isAlive());
        t6.join();
        System.out.println("t6 alive after join: " + t6.isAlive());

        // 8. Thread.currentThread()
        System.out.println("Main thread: " + Thread.currentThread().getName());
    }
} 