package springDemoDependencyInjection;

public class Instagram implements Service{
    @Override
    public void sent(String ms) {
        System.out.println("Message Instagram: " + ms);
    }

    @Override
    public void call(String num) {
        System.out.println("Call via Instagram: " + num);
    }
}
