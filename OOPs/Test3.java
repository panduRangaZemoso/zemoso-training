public class Test3 {

    public static void main(String[] args) {
        Mobile m1 = new Iphone5s();
        Mobile m2 = new Iphone7s();

        m1.makeCall("100");
        m1.sendMessage("4223","Hello");
        m1.getProcessorBrand();
        m1.getProcessorType();
        m1.getRAM();


        m2.makeCall("108");
        m2.sendMessage("233","Hi");
        m2.getProcessorBrand();
        m2.getProcessorType();
        m2.getRAM();

    }
}

interface Mobile{
    void makeCall(String number);
    void sendMessage(String number, String text);
    void getProcessorBrand();
    void getProcessorType();
    void getRAM();
}

abstract class Apple implements Mobile{

    @Override
    public void makeCall(String number) {
        System.out.println("Calling :"+number);
    }

    @Override
    public void sendMessage(String number,String text) {
        System.out.println("Messaging :"+number+", text :"+text);
    }

    @Override
    public void getProcessorBrand(){
        System.out.println("SnapDragon");
    }

}

class Iphone5s extends Apple{
    public void getProcessorType(){
        System.out.println("Snapdragon450s");
    }
    public void getRAM(){
        System.out.println("4GB");
    }
}

class Iphone7s extends Apple{
    public void getProcessorType(){
        System.out.println("Snapdragon680s");
    }
    public void getRAM(){
        System.out.println("8GB");
    }
}