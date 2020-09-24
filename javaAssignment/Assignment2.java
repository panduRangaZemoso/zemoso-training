package javaAssignment;

public class Assignment2 {

    public static void main(String[] args){

        String test1 = "qWertYuiopasdfgHjklZxcvbnM";
        String test2 = "abcd";
        String test3 = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(test1+" : "+checkIfStringHasAllAlphabets(test1));
        System.out.println(test2+" : "+checkIfStringHasAllAlphabets(test2));
        System.out.println(test3+" : "+checkIfStringHasAllAlphabets(test3));

    }

    public static boolean checkIfStringHasAllAlphabets(String testString) {

        // CONSTANT EXTRA SPACE => O(1) SPACE COMPLEXITY
        return hasAllAlphabets(fillAlphabetPresence(testString, new boolean[26]));
    }


    private static boolean[] fillAlphabetPresence(String test, boolean[] alphabetPresence) {

        // VARIABLE TIME TAKING PROCESS => O(stringLength) TIME COMPLEXITY
        for(int i = 0; i< test.toLowerCase().length(); i++){
            if(test.charAt(i) >= 'a' && test.charAt(i) <= 'z'){
                alphabetPresence[test.charAt(i) - 'a'] = true;
            }
        }
        return alphabetPresence;
    }

    private static boolean hasAllAlphabets(boolean[] alphabetPresence) {
        boolean result = true;
        for(int i = 0; i< alphabetPresence.length; i++){
            result &= alphabetPresence[i];
        }
        return result;
    }
}
