package exampleThread.OpenDoor;
/*
 * Algorithm 1:
 * Sử dụng 1 biến chia sẻ là openDoor nhằm mục đích để 1 luồng có thể được thực hiện 1 cách "NGUYÊN TỬ"
 * Ý TƯỞNG:
 *   + Kiểm tra xem 1 luồng có được phép đi vào khu vực CS không ( check biến openDoor )
 *   + Khi 1 luồng đang trong khu vực CS thì luồng khác không được nhảy vào
 * VẤN ĐỀ:
 *   + Khi 1 luồng vào được khu vực CS nhưng chưa kịp set lại giá trị cho biến openDoor = false ( waiting busy) .
 *   + Con trở điều khiển chuyển ngữ cảnh sang luồng còn lại : => luồng còn lại cũng vào được vùng CS
 *   ==> Lại sảy ra hiện tượng Race Condition - tranh đua
 * KẾT LUẬN:
 *   ==> Chưa giải quyết được loại trừ lẫn nhau
 * */
class ChildrenThread extends Thread{
    Thread t = new Thread();
    @Override
    public void run() {
        for(int i = 0; i<= 2; i++){
            System.out.println("thread " + i);
        }
    }
}

public class OpenDoor {
    public boolean openDoor = true;
    public void requestCS(ChildrenThread ch){
        while(!openDoor){
            System.out.println("waiting...");
        };
        openDoor = false;
        ch.start();
    }

    public void releaseCS(){
        openDoor = true;
    }

    public static void main(String[] args) {
        ChildrenThread ch1 = new ChildrenThread();
        ChildrenThread ch2 = new ChildrenThread();

        OpenDoor m = new OpenDoor();
        m.requestCS(ch1);
        m.releaseCS();

        m.requestCS(ch2);
        m.releaseCS();
    }

}
