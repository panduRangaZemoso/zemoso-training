public class Assignment7 {
    public static void main(String[] args){

        // PART-A
        Rodent[] rodents = new Rodent[3];

        rodents[0] = new Gerbil();
        rodents[1] = new Mouse();
        rodents[2] = new Hamster();

        for(Rodent rodent : rodents){
            System.out.println("Rodent Type : "+rodent.getRodentType());
            System.out.println("Legs for rodent : "+rodent.getNumberOfLegs());
            System.out.println("Weight Range for rodent : "+rodent.weightRange());
        }

        System.out.println("*************************************");

        // PART-B
        Cycle[] cycles = new Cycle[3];
        cycles[0] = new UniCycle();
        cycles[1] = new BiCycle();
        cycles[2] = new TriCycle();

        // COMPILE TIME ERROR CYCLE HAS NO METHOD balance
        /*for(Cycle cycle : cycles){
            cycle.balance();
        }*/

        UniCycle uniCycle = (UniCycle)cycles[0];
        uniCycle.balance();

        BiCycle biCycle = (BiCycle)cycles[1];
        biCycle.balance();


        System.out.println("*************************************");

        // PART-C
        ConcreteClass obj = new ConcreteClass();
        exampleMethod1(obj);
        exampleMethod2(obj);
        exampleMethod3(obj);
        exampleMethod4(obj);

        System.out.println("*************************************");

        // PART-D
        new CycleFactory().getCycle("unicycle").ride();
        new CycleFactory().getCycle("bicycle").ride();
        new CycleFactory().getCycle("tricycle").ride();

        System.out.println("*************************************");

        // PART-E
        External1.Internal1 internal11 = new External1().new Internal1("random11");
        External1.Internal1 internal12 = new External2().new Internal2("random12");
        internal11.method();
        internal12.method();

    }

    static void exampleMethod1(Interface1 interfaceObj){
        interfaceObj.method1();
    }

    static void exampleMethod2(Interface2 interfaceObj){
        interfaceObj.method3();
    }

    static void exampleMethod3(Interface3 interfaceObj){
        interfaceObj.method5();
    }

    static void exampleMethod4(InterfaceChild interfaceObj){
        interfaceObj.extraMethod();
    }
}

abstract class Rodent{
    Rodent(){
        System.out.println("This is Rodent");
    }
    int getNumberOfLegs(){
        return 4;
    }
    abstract String getRodentType();
    abstract String weightRange();
}

class Mouse extends Rodent{
    public Mouse() {
        System.out.println("This is Mouse");
    }

    @Override
    String getRodentType() {
        return "Mouse";
    }

    @Override
    String weightRange() {
        return "150-350 grams";
    }
}

class Gerbil extends Rodent{

    public Gerbil() {
        System.out.println("This is Gerbil");
    }

    @Override
    String getRodentType() {
        return "Gerbil";
    }

    @Override
    String weightRange() {
        return "100-180 grams";
    }
}

class Hamster extends Rodent{

    public Hamster() {
        System.out.println("This is Hamster");
    }

    @Override
    String getRodentType() {
        return "Hamster";
    }

    @Override
    String weightRange() {
        return "400-50 grams";
    }
}



abstract class Cycle{
    abstract void ride();
}

class UniCycle extends Cycle{
    void balance(){
        System.out.println("Balancing unicycle");
    }

    @Override
    void ride(){
        System.out.println("Riding unicycle");
    }
}

class BiCycle extends Cycle{
    void balance(){
        System.out.println("Balancing bicycle");
    }

    @Override
    void ride(){
        System.out.println("Riding bicycle");
    }
}

class TriCycle extends Cycle{

    @Override
    void ride(){
        System.out.println("Riding tricycle");
    }
}


interface Interface1{
    void method1();
    void method2();
}

interface Interface2{
    void method3();
    void method4();
}

interface Interface3{
    void method5();
    void method6();
}

interface InterfaceChild extends Interface1, Interface2, Interface3{
    void extraMethod();
}

class ConcreteClass implements InterfaceChild{

    @Override
    public void method1() {
        System.out.println("method1");
    }

    @Override
    public void method2() {
        System.out.println("method2");
    }

    @Override
    public void method3() {
        System.out.println("method3");
    }

    @Override
    public void method4() {
        System.out.println("method4");
    }

    @Override
    public void method5() {
        System.out.println("method5");
    }

    @Override
    public void method6() {
        System.out.println("method6");
    }

    @Override
    public void extraMethod() {
        System.out.println("extraMethod");
    }
}



// CYCLE FACTORY
class CycleFactory{
    public Cycle getCycle(String type){
        if(type.equalsIgnoreCase("UNICYCLE")){
            return new UniCycle();
        }
        else if(type.equalsIgnoreCase("BICYCLE")){
            return new BiCycle();
        }
        else if(type.equalsIgnoreCase("TRICYCLE")){
            return new TriCycle();
        }
        else{
            return null;
        }
    }
}



// PART-E
class External1{
    class Internal1{
        String member;
        public Internal1(String member) {
            this.member = member;
        }

        void method(){
            System.out.println("External1->Internal1");
        }
    }
}

class External2{
    class Internal2 extends External1.Internal1 {
        public Internal2(String member) {
            // AS INTERNAL1 NEEDS AN INSTANCE OF EXTERNAL1 TO CREATE IT
            new External1().super(member);
        }

        @Override
        void method(){
            System.out.println("External2->Internal2");
        }
    }
}
