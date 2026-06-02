## Concurrency
Multiple tasks running at the same time (or appearing to).

**Example:**
Someone playing Factorio. At the same time:
- Music is playing
- Game is auto-saving
- Enemies are attacking

All happening simultaneously — that's concurrency.

---

## Thread
A single unit of execution that runs independently and simultaneously with other threads.

**Example:**
```java
class DownloadThread extends Thread {
    String file;
    DownloadThread(String file) { this.file = file; }
    public void run() {
        System.out.println("Downloading: " + file);
    }
}

DownloadThread t1 = new DownloadThread("song.mp3");
DownloadThread t2 = new DownloadThread("video.mp4");
t1.start();
t2.start();
```
Instead of downloading one file at a time, both download at the same time.

```java
import java.util.*;

/**
 * Threads in Java
 *
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
```