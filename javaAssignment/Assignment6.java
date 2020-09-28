import java.util.ArrayList;
import java.util.List;

public class Assignment6 {

    public static void main(String[] args) {

        // PART-A
        int nVampires = 100;
        System.out.println(findVampires(nVampires));

        // PART -B
        Student student = new Student("Praneeth");
        System.out.println(student.standard);

        // PART-C
        Example[] examples = new Example[5];


        // PART-D
        for (int i = 0; i < examples.length; i++) {
            examples[i] = new Example();
        }
    }

    private static List<Integer> findVampires(int nVampires) {
        List<Integer> arrVampires = new ArrayList<>();
        int i = 0, num= 10, end = 100;

        while(i < nVampires && num<end){
            if(isVampire(num)) {
                arrVampires.add(num);
                i++;
            }
            num++;

            // ONLY BETWEEN ODD TO EVEN POWER OF 10(LIKE 10 TO 100, 1000 TO 10000)
            if(num == end){
                end = num*(10*10);
                num = num*(10);
            }
        }
        return arrVampires;
    }

    private static boolean isVampire(int num) {
        List<String> permutations = getPermutations(String.valueOf(num));

        for(String number : permutations){
            if(Integer.parseInt(number.substring(0,number.length()/2)) * Integer.parseInt(number.substring(number.length()/2)) == num){
                return true;
            }
        }
        return false;
    }

    private static List<String> getPermutations(String str) {
        // If string is empty
        if (str.length() == 0) {
            // Return an empty arraylist
            List<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }

        char ch = str.charAt(0);

        // Rest of the string after excluding
        // the first character
        String restStr = str.substring(1);

        // Recurvise call
        List<String> prevRes = getPermutations(restStr);

        // Store the generated sequence into
        // the resultant Arraylist
        List<String> Res = new ArrayList<>();
        for (String s : prevRes) {
            for (int i = 0; i <= s.length(); i++) {
                String f = s.substring(0, i) + ch + s.substring(i);

                // If the generated string is not
                // already present in the Arraylist
                if (!isPresent(f, Res))

                    // Add the generated string to the Arraylist
                    Res.add(f);
            }
        }

        // Return the resultant arraylist
        return Res;
    }

    static boolean isPresent(String s, List<String> Res)
    {

        // If present then return true
        for (String str : Res) {

            if (str.equals(s))
                return true;
        }

        // Not present
        return false;
    }
}

class Student{
    String name;
    int standard;

    public Student(String name) {
        this(name,1);
    }

    public Student(String name, int standard) {
        this.name = name;
        this.standard = standard;
    }
}

class Example{
    public Example() {
        System.out.println("Instance of Example is being created");
    }
}

