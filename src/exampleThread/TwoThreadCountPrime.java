package exampleThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*
* Random 1 mảng số nguyên
* Tạo 2 thread:
* Thread 1 tìm các số nguyên trong khoảng từ 0 -> 1/2 mảng vừa tạo
* Thread 2 tìm các số nguyên trong khoảng từ 1/2 mảng -> hết
* Đếm xem có bao nhiêu số nguyên tố được tìm thấy trong mảng
* */

// Class : 2 luồng đếm số nguyên tố
public class TwoThreadCountPrime extends Thread {
    private static int n = 50;
    private static int[] arr = new int[n];

    private static List<Integer> lst = new ArrayList<>();

    public void run(){
        if(Thread.currentThread().getName().equals("thread_1")){
             for(int i = 0; i < arr.length/2 ; i++ ){
                 if(arr[i] > 2){
                     if(find(arr[i])){
                         lst.add(arr[i]);
                         System.out.println("T1:" + arr[i]);
                     }
                 }
            }
        }else{
            for(int i = arr.length/2; i < arr.length; i++ ){
                if(arr[i] > 2){
                    if(find(arr[i])){
                        lst.add(arr[i]);
                        System.out.println("T2:" + arr[i]);
                    }
                }
            }
        }
    }

    // Hàm tìm số nguyên tố
    private boolean find(int x){
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;

    }

    private static void CreateArray(){
        Random random = new Random();
        for(int i = 0; i< n; i++){
            arr[i] = random.nextInt(30);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        CreateArray();

        TwoThreadCountPrime t1 = new TwoThreadCountPrime();
        TwoThreadCountPrime t2 = new TwoThreadCountPrime();

        t1.setName("thread_1");
        t2.setName("thread_2");

        t1.start();
        t2.start();

        // join method waiting for complete thread t1 and t2 before print "Tong"
        t1.join();
        t2.join();

        System.out.println("Tổng = " + lst.size());


    }
}
