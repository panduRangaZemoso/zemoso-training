package pandu.assignment.main;

import pandu.assignment.data.PrintDataMember;
import pandu.assignment.singleton.Member;

// PART-C
public class Assignment5 {

    public static void main(String[] args){

        // PART-A
        PrintDataMember eg1 = new PrintDataMember();
        eg1.printDataMembers();
        // ERROR OCCURS HERE
        eg1.printMethodDataMembers();

        // PART-B
        System.out.println(Member.staticInitializer("pandu").getMember());
        System.out.println(Member.staticInitializer("pallav").getMember());

    }
}
