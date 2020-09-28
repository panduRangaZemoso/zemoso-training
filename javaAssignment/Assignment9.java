import java.util.regex.Pattern;

public class Assignment9 {
    public static void main(String[] args){
        //System.out.println(Pattern.matches("[A-Z]+[a-zA-Z]*?[.]","Abcd."));
        System.out.println(Pattern.matches("[A-Z].*[.]","ABcd."));
        System.out.println(Pattern.matches("[A-Z].*[.]","ABCD."));
        System.out.println(Pattern.matches("[A-Z].*[.]","Password@123."));
    }
}
