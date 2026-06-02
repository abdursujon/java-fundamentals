package concurrency;

import java.util.*;

/**
 * Threads in Java
 * <p>
 * 1. Extending Thread class
 * 2. Implementing Runnable interface
 * 3. Thread.sleep(ms)
 * 4. thread.join()
 * 5. thread.getName() / thread.setName()
 * 6. thread.getPriority() / thread.setPriority()
 * 7. thread.isAlive()
 * 8. Thread.currentThread()
 */
public class Threads {
    public static void main(String[] args) {
        // 1. Extending Thread class
        class MyThread extends Thread {
            // Override Thread run method
            public void run() {
                System.out.println("Thread running: " + getName());
            }
        }
        MyThread mt0 = new MyThread();
        mt0.start();
        MyThread mt1 = new MyThread();
        mt1.start();

        // 2. Implementing runnable interface
        Runnable r = () -> System.out.println("Runnable running: " + Thread.currentThread().getName());
        Thread t1 = new Thread(r);
        t1.start();

        class MyRunnable implements Runnable {
            public void run() {
                System.out.println("Runnable running: " + Thread.currentThread().getName());
            }
        }
        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        class Animal {
            String name;
        }

        class Dog extends Animal implements Runnable {

            @Override
            public void run() {
                System.out.println(name + " is running");
            }

        }

        Dog dog = new Dog();
        dog.name = "Jasper";
        Thread t = new Thread(dog);
        t.start();

    }
}
