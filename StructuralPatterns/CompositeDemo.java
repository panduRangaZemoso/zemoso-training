package StructuralPatterns;

import java.util.ArrayList;
import java.util.List;

public class CompositeDemo {

    public static void main(String[] args){
        RussianDoll doll1 = new SingleRussianDoll("doll1");
        RussianDoll doll2 = new SingleRussianDoll("doll2");


        RussianDollSet dollSet = new RussianDollSet();
        dollSet.addDoll(doll1);

        RussianDollSet dollSet1 = new RussianDollSet();
        dollSet1.addDoll(doll2);
        dollSet.addDoll(dollSet1);

        dollSet.open();
    }
}

interface RussianDoll{
    void open();
}

class SingleRussianDoll implements RussianDoll{
    String name;

    public SingleRussianDoll(String name) {
        this.name = name;
    }

    @Override
    public void open() {
        System.out.println("Opening russian doll : "+name);
    }
}


class RussianDollSet implements RussianDoll{
    private List<RussianDoll> dollList = new ArrayList<>();

    void addDoll(RussianDoll doll){
        dollList.add(doll);
    }

    void removeDoll(RussianDoll doll){
        dollList.remove(doll);
    }

    @Override
    public void open() {
        dollList.forEach( russianDoll -> russianDoll.open());
    }
}