import java.io.File;
import java.util.regex.Pattern;

public class Assignment1 {

    public static void main(String[] args){
        String path = "/home/ranga/";
        new FileFinder(path).findFile("demo.java");
    }
}

class FileFinder{
    String path;
    File directoryPath;

    public FileFinder(){
        //this.path = "/home/ranga/";
        this.path = System.getProperty("user.home");
    }

    public FileFinder(String path) {
        this.path = path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private void setDirectoryPath(File directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void findFile(String fileNamePattern){
        this.setDirectoryPath(new File(path));
        for(File file : directoryPath.listFiles()){

            if(matchFileNames(fileNamePattern, file.getName()) && !file.isDirectory()){
                System.out.println("MATCHING FILE FOUND: "+file.getAbsolutePath());
            }

            if(file.isDirectory()) {
                this.path = file.getAbsolutePath();
                findFile(fileNamePattern);
            }
        }
    }

    private static boolean matchFileNames(String patternToMatch, String fileNameToMatch){
        return Pattern.compile(patternToMatch, Pattern.CASE_INSENSITIVE).matcher(fileNameToMatch).find();
    }

}
