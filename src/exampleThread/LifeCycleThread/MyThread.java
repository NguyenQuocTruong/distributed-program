package exampleThread.LifeCycleThread;

public class MyThread extends Thread {
    @Override
    public void run() {
        DemoSynchronized.commonResource();
    }

    public static void main(String[] args) throws InterruptedException {
        //  New 2 thread created
        MyThread th1 = new MyThread();
        MyThread th2 = new MyThread();

        th1.start();
        System.out.println("Thread 1 started: " + th1.getState());
        th1.join();

        th2.start();
        System.out.println("Thread 1 run: " + th1.getState());

        System.out.println("Thread 2 started: " + th2.getState());
    }
}
