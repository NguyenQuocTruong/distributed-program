package exampleThread;

/*
* Viết 1 class kết thừa từ lớp Thread
* Tạo 2 Thread
* Sử dụng hàm join để bắt 1 thread chờ  --> đảm bảo 2 thread 1 và thread 2 chạy đúng thứ tự
* (thread nào start trước thì được thực hiện trước 1 cách nguyên tử)
* */

class MyThread extends Thread {
    @Override
    public void run(){
        for (int i = 0; i< 3 ; i++){
            System.out.println(Thread.currentThread().getName() + " ==== " + i );
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end ==================");
    }
}

class Main{
    public static void main(String[] args) throws InterruptedException {

        MyThread th1 = new MyThread();
        th1.getState();
        MyThread th2 = new MyThread();



        th1.start(); // Thread_1 start trước
        System.out.println("Thread start " + th1.getState());

        th1.join(); // Bắt Thread_2 chờ cho Thread_1 thực hiện xong công việc

        th2.start();

    }

}
