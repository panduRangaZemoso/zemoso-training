package BehaviouralPatterns;

public class TemplateDemo {
    public static void main(String[] args){
        Sub classicSub = new ClassicSub();
        Sub classicMexicanSub = new ClassicMexicabSub();

        classicSub.makeSub();
        System.out.println("************");
        classicMexicanSub.makeSub();
    }
}

abstract class Sub{
    abstract void addBreadType();
    abstract void addVeggies();
    abstract void addCheeseType();
    abstract void addSauceType();
    abstract void bakeSub();

    public void makeSub(){
        addBreadType();
        addVeggies();
        addCheeseType();
        addSauceType();
        bakeSub();
    }
}

class ClassicSub extends Sub{

    @Override
    void addBreadType() {
        System.out.println("Adding WhiteBread");
    }

    @Override
    void addVeggies() {
        System.out.println("Adding Veggies");
    }

    @Override
    void addCheeseType() {
        System.out.println("Adding Mozzarella Cheese");
    }

    @Override
    void addSauceType() {
        System.out.println("Adding mustard honey sauce");
    }

    @Override
    void bakeSub() {
        System.out.println("Baking");
    }
}

class ClassicMexicabSub extends Sub{

    @Override
    void addBreadType() {
        System.out.println("Adding Oregano Bread");
    }

    @Override
    void addVeggies() {
        System.out.println("Adding veggies");
    }

    @Override
    void addCheeseType() {
        System.out.println("Adding Mozzarella Cheese");
    }

    @Override
    void addSauceType() {
        System.out.println("Adding spicy tomato sauce");
    }

    @Override
    void bakeSub() {
        System.out.println("Baking");
    }
}