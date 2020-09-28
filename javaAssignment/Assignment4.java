import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Assignment4 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());

        //LocalDate.parse("16-07-1998");

        while (t != 0){
            String[] dates = s.nextLine().split(" ");
            //System.out.println(Arrays.toString(dates));

            if(dates.length == 2) {
                getDateRange(dates[0], dates[1]);
            }
            else{
                System.out.println("Need two dates");
            }
            t--;
        }
    }

    private static void getDateRange(String signedDate, String presentDate) {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate signed = LocalDate.parse(signedDate, dateFormatter);
        LocalDate present = LocalDate.parse(presentDate, dateFormatter);

        // ANNIVERSARY IS AT LEAST AFTER AN YEAR
        if(signed.plusYears(1).minusDays(30).isAfter(present)){
            System.out.println("No Range");
            return;
        }

        LocalDate anniversary = LocalDate.of(present.getYear(),signed.getMonth(),signed.getDayOfMonth());

        LocalDate start = anniversary.minusDays(30);
        LocalDate end = anniversary.plusDays(30);

        if(present.isBefore(end)){
            end = present;
        }
        System.out.println(formatDate(start)+" "+formatDate(end));
    }

    private static String formatDate(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }


}
