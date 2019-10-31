package springDemoDependencyInjection;

public class FaceBookSocial implements Service{
    @Override
    public void sent(String ms) {
        System.out.println("This message sent by facebook: "+ ms);
    }

    @Override
    public void call(String num) {
        System.out.println("Call via facebook: " + num);
    }
}
