package springDemoDependencyInjection;

public class Main {
    private Service se;

    /*Constructor #1
    * Default Constructorer sẽ vẫn tạo ra sự phụ thuộc khi khởi tạo se = new Facebook
    * có thể sử dụng hàm tạo thứ #2 để thay thế(khắc phục) loại bỏ sự gắn kết
    * phụ thuộc giữa class Main và FaceBook*/
    public Main(){
        se = new FaceBookSocial();
    }

    /*Constructor #2
    * Truyền đối tượng cần khởi tạo thông qua parameter của hàm tạo*/
    public Main(Service service){
        se = service;
    }

    public void sender(String ms){
        se.sent(ms);
    }

    public void caller(String num){
        se.call(num);
    }

    public static void main(String[] args) {
        String noti = "notification you of discount program";
        String number = "0332898798";

        Main m = new Main();
        m.sender(noti);

        /*Khởi tạo đối tượng của class Instagram. sau đó truyền vào thông qua hàm tạo*/
        Instagram in = new Instagram();
        Main m2 = new Main(in);
        m2.caller(number);

    }
}
