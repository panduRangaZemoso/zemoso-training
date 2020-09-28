package pandu.assignment.singleton;

public class ExampleClass2 {
    String member;

    public ExampleClass2(String member) {
        this.member = member;
    }

    public String getMember() {
        return member;
    }

    public static ExampleClass2 staticInitializer(String member){
        return new ExampleClass2(member);
    }
}
