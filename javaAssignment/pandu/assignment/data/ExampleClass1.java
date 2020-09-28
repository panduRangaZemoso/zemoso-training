package pandu.assignment.data;

public class ExampleClass1 {
    int a;
    char b;

    public void printDataMembers(){
        System.out.println("a : "+a+" b: "+ b);
    }

    public void exampleFunction(){
        int c; char d;
        // CANNOT WORK ON JAVA METHOD VARIABLES WHEN NOT-INITIALIZED
        //System.out.println(c+" "+d);
    }
}
