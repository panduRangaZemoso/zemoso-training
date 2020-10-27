package pandu.assignment.singleton;

public class Member {
    String member;

    public Member(String member) {
        this.member = member;
    }

    public String getMember() {
        return member;
    }

    public static Member staticInitializer(String member){
        return new Member(member);
    }
}
