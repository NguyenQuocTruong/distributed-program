package exampleThread;

class Children extends Thread{
    @Override
    public void run() {
        for(int i = 0 ; i< 3; i++){
            System.out.println("hello "+ i);
        }
    }
}

public class Want {
    public boolean want[] = {false,false};

    public void requestCS(Children ch, int i){
        want[i] = true;
        while (want[1-i]){
            System.out.println("----");
        }
        ch.start();
    }

    public void releaseCS(int i){
        want[i] = false;
    }

    public static void main(String[] args) {
        Children ch0 = new Children();
        Children ch1 = new Children();

        Want w = new Want();
        w.requestCS(ch0, 0);
        w.releaseCS(0);

        w.requestCS(ch1, 1);
        w.releaseCS(1);
    }

}
