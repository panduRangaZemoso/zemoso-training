package CreationalPatterns;

public class SingletonDemo {
    public static void main(String[] args){
        for(int i=0;i<10;i++){
            SomeClass.getInstance().call();
        }
    }
}

class SomeClass {
    private SomeClass() {} // PRIVATE CONSTRUCTOR

    public static int i=0;

    private static SomeClass someClass = new SomeClass();
    public static SomeClass getInstance() {
        i += 1;
        return someClass;
    }

    public void call(){
        System.out.println("SomeClass's same Instance called for "+i+"th time");
    }

}
