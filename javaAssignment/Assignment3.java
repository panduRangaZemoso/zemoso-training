import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Assignment3 {
    public static void main(String[] args) {

        String url = "www.google.com";
        //String url = "192.168.43.147";
        int pingCount = 5;

        try {
            UrlPinger.ping(url, pingCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class UrlPinger{

     static void ping(String url, int pingCount) throws IOException {

        ProcessBuilder build = new ProcessBuilder(buildCommandList(url,pingCount));
        Process process = build.start();

        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader Error = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        // INITIALIZE UTILITY VARIABLES
        String s = null;
        int pingCountIter = pingCount;
        List<Double> tatList = new ArrayList<>();

        // READ COMMAND OUTPUT
        while ((s = input.readLine()) != null && pingCountIter > 0) {
            //System.out.println(s);
            if (s.contains("time=") && s.length() > 7) {
                tatList.add(Double.parseDouble(s.substring(s.length() - 7, s.length() - 3)));
                pingCountIter--;
            }

            if(s.contains("statistics")){
                pingCountIter=0;
            }
        }

        //System.out.println(tatList);
        if(!tatList.isEmpty()) {
            System.out.println(String.format("Median time for pinging %s after %d hits : %.2f ms",url ,pingCount, getMedian(tatList)));
        }
        else{
            System.out.println("Pinging failed!!!");
        }

        // READ COMMAND THROWING ERRORS
        boolean errorHead = true;
        while ((s = Error.readLine()) != null) {
            if (errorHead)
                System.out.println("Error Occured Executing Command: ");
            errorHead = false;

            System.out.println(s);
        }
    }

    private static List<String> buildCommandList(String url, int pingCount) {
        List<String> commandList = new ArrayList<>();

        // CONSTRUCT COMMAND STRUCTURE
        commandList.add("ping");
        commandList.add("-c");
        commandList.add(String.valueOf(pingCount));
        commandList.add(url);

        return commandList;
    }

    private static Double getMedian(List<Double> tatList) {
        Collections.sort(tatList);

        int size = tatList.size();
        if(size%2 == 0){
            return (tatList.get(size/2)+tatList.get((size/2)-1))/2 ;
        }
        return tatList.get(size/2);
    }
}
