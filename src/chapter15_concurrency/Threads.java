import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Thread: a single path of execution that runs independently and at the same time as
 * other threads. The main method runs on one thread; you can start more to do work in parallel.
 * <p>
 * Significance of thread: one thread does tasks one after another. Multiple threads let work
 * happen at once - download files, play music, and auto-save together instead of waiting.
 * This file covers the two ways to make a thread and the common controls on one.
 * <p>
 * 1. Extending Thread - subclass Thread, override run(), call start()
 * 2. Implementing Runnable - pass a task to a Thread (preferred, doesn't use up your one superclass)
 * 3. Thread.sleep(ms) - pause the current thread for given milliseconds
 * 4. thread.join() - make the caller wait until that thread finishes
 * 5. getName() / setName() - read or label a thread
 * 6. getPriority() / setPriority() - hint at scheduling order, 1(low) to 10(high), default 5
 * 7. thread.isAlive() - true if the thread has started and not yet finished
 * 8. Thread.currentThread() - the thread running this line right now
 * 9. Two threads running at the same time
 */
public class Threads {
    public static void main(String[] args) throws InterruptedException {

        /**
         * Below we have design two inner class to demonstrate how two thread runs at the same time.
         * One class is responsible for writing details to a file and one is responsible for reading that content
         * and both task happens at the same time.
         * Both class also extends Thread built in class
         */
        class WriteCustomerDetails extends Thread {
            // this class gets Thread-0

            void writeFile() throws IOException {
                Path writeCustomerDetails = Path.of("src/resource/concurrency/customer.txt");
                Files.write(writeCustomerDetails, List.of("name, order-number, cost",
                        "iki, 783, 789",
                        "oliver, 89, 673"));
            }

            @Override
            public void run() {
                for (int i = 0; i <= 5; i++) {
                    System.out.println("WriteCustomerDetails running " + getName() + " step " + i);
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    writeFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        WriteCustomerDetails writeCustomerDetails = new WriteCustomerDetails();
        writeCustomerDetails.start();


        class ReadCustomerDetails extends Thread {
            // this class gets Thread-1

            List<String> readFile() throws IOException {
                Path customerDetails = Path.of("src/resource/concurrency/customer.txt");
                List<String> list = Files.readAllLines(customerDetails);
                System.out.println(list);
                return list;
            }

            @Override
            public void run() {
                for (int i = 0; i <= 5; i++) {
                    System.out.println("ReadCustomerDetails running " + getName() + " step " + i);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    readFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        ReadCustomerDetails readCustomerDetails = new ReadCustomerDetails();
        readCustomerDetails.start();


        // 2. Implementing Runnable interface
        int[] cost = {1, 892, 44, 22, 82, 7};
        int totalCost = Arrays.stream(cost).sum();
        Runnable printOrderTotal = () -> System.out.println("Order total: "+ totalCost + " by " + Thread.currentThread().getName());
        // this object gets Thread-2
        Thread order = new Thread(printOrderTotal);
        order.start();

        // 3. Thread.sleep(ms)
        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Woke up after 5 second");
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
        // note: in general purpose OS like windows, mac this is mostly ignored
        Thread t5 = new Thread(() -> System.out.println("Priority: " + Thread.currentThread().getPriority()));
        t5.setPriority(Thread.MAX_PRIORITY);
        t5.start();

        // 7. thread.isAlive()
        Thread t6 = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t6.start();
        System.out.println("t6 alive: " + t6.isAlive());
        t6.join();
        System.out.println("t6 alive after join: " + t6.isAlive());

        // 8. Thread.currentThread()
        System.out.println("Main thread: " + Thread.currentThread().getName());

        // 9. Two threads running at the same time [countTask is a variable of type Runnable]
        Runnable countTask = new Runnable() {
            public void run() {
                String name = Thread.currentThread().getName();
                for (int i = 1; i <= 5; i++) {
                    System.out.println(name + " count: " + i);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread counterA = new Thread(countTask, "A");
        Thread counterB = new Thread(countTask, "B");
        counterA.start();
        counterB.start();
    }
}