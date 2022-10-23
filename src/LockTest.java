package first.src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LockTest {

    public static void main(String[] args) {
        LockTest obj = new LockTest();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh-mm-ss");
        Thread thread1 = new Thread(() -> {
            System.out.println("start thread1 "+LocalDateTime.now().format(formatter));
            obj.print1("thread1");
            System.out.println("end thread1 "+LocalDateTime.now().format(formatter));
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("start thread2 "+LocalDateTime.now().format(formatter));
            obj.print2("thread2");
            System.out.println("end thread2 "+LocalDateTime.now().format(formatter));
        });
        thread1.start();
        thread2.start();
    }

    public synchronized void print1(String msg) throws RuntimeException {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void print2(String msg) throws RuntimeException {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
