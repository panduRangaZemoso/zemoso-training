import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Assignment11 {
    public static void main(String[] args) throws IOException {

        System.out.println("Enter File Name : ");
        Scanner s = new Scanner(System.in);
        String fileName = s.nextLine();
        s.close();

        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));

        Map<Character, Integer> charMap = new HashMap<>();
        String st;
        while ((st = br.readLine()) != null) {
            for (int i = 0; i < st.length(); i++) {
                if(charMap.containsKey(st.charAt(i))){
                    charMap.put(st.charAt(i), charMap.get(st.charAt(i))+1);
                }
                else{
                    charMap.put(st.charAt(i), 1);
                }
            }
        }
        br.close();

        String newFileName = file.getAbsolutePath().split("[.]")[0]+"CharMap.txt";
        FileWriter newFile = new FileWriter(newFileName);
        for(Character ch : charMap.keySet()){
            String line = ch+" : "+charMap.get(ch);
            newFile.write(line+"\n");
        }
	System.out.println("Character Frequency mappings written to "+newFileName);
        newFile.close();
    }
}
