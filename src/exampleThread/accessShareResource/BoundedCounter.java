package exampleThread.accessShareResource;

import java.util.Random;

/*
* Viết 2 luồng cùng sử dụng tài nguyên chia sẻ là biến: count
* count:  chạy từ min đến max
* num : là đại lượng tăng hoặc giảm ngẫu nhiên cho mỗi lần truy cập vào biến count
* Khi 1 luồng đang truy cập vào count thì luồng còn lại phải chờ và
* +> count - num < min --> luồng này phải chờ
* +> count + num > max --> cũng phải chờ
* */

public class BoundedCounter{
    private int min = 5, max = 30, count = 10, num = 0;
    private Random random = new Random();

    private synchronized void increment() {
        num = random.nextInt(10);
        if(count + num > max)
            notify();

        while (count + num > max)
            Util.myWait(this);

        count += num;
        System.out.println("increment = "+ num);
        System.out.println("count_in = "+ count);
    }

    private synchronized void decrement() {
        num = random.nextInt(10);
        if(count - num < min)
            notify();

        while (count - num < min)
            Util.myWait(this);

        count -= num;
        System.out.println("decrement = "+ num);
        System.out.println("count_de = "+ count);
    }

    public static void main(String[] args) {
        BoundedCounter b = new BoundedCounter();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    b.increment();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    b.decrement();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
