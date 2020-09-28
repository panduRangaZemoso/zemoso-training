package pandu.assignment.main;

import pandu.assignment.data.ExampleClass1;
import pandu.assignment.singleton.ExampleClass2;

// PART-C
public class Assignment5 {

    public static void main(String[] args){

        // PART-A
        ExampleClass1 eg1 = new ExampleClass1();
        eg1.printDataMembers();
        // ERROR OCCURS HERE
        eg1.exampleFunction();

        // PART-B
        System.out.println(ExampleClass2.staticInitializer("pandu").getMember());
        System.out.println(ExampleClass2.staticInitializer("pallav").getMember());

    }
}
