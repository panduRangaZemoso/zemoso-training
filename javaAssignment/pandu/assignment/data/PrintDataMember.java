package pandu.assignment.data;

public class PrintDataMember {
    int a;
    char b;

    public void printDataMembers(){
        System.out.println("a : "+a+" b: "+ b);
    }

    public void printMethodDataMembers(){
        int c; char d;
        // CANNOT WORK ON JAVA METHOD VARIABLES WHEN NOT-INITIALIZED
        //System.out.println(c+" "+d);
    }
}
