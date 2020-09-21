package BehaviouralPatterns;

import java.util.ArrayList;
import java.util.List;

public class MementoDemo {

    public static void main(String[] args){
        FileWriter fileWriter = new FileWriter();

        FileUtils fileUtil = new FileUtils("text.txt");

        fileUtil.write("first text");
        fileWriter.save(fileUtil);
        System.out.println(fileUtil);

        System.out.println("*****************");

        /*fileUtil.write(" second text");
        fileWriter.save(fileUtil);
        System.out.println(fileUtil);*/

        fileWriter.undo(fileUtil);
        System.out.println(fileUtil);

        System.out.println("*****************");

        fileWriter.redo(fileUtil);
        System.out.println(fileUtil);

        System.out.println("*****************");

        fileWriter.redo(fileUtil);
        System.out.println(fileUtil);
    }

}

class FileUtils{
    private String fileName;
    private StringBuilder content;

    public FileUtils(String fileName) {
        this.fileName = fileName;
        this.content = new StringBuilder();
    }

    public void write(String content) {
        this.content.append(content);
    }

    public FileSave save(){
        return new FileSave(this.fileName,this.content);
    }

    public void moveToSave(Object obj){
        FileSave fileSave = (FileSave) obj;
        this.fileName = fileSave.fileName;
        this.content = fileSave.content;
    }

    @Override
    public String toString() {
        return this.fileName+" has content : "+this.content.toString();
    }

    public FileSave setEmptyFileState(){
        return new FileSave(this.fileName,new StringBuilder());
    }

    private class FileSave{
        private String fileName;
        private StringBuilder content;

        public FileSave(String fileName, StringBuilder content) {
            this.fileName = fileName;
            this.content = new StringBuilder(content);
        }

        @Override
        public String toString() {
            return "FileSave{" +
                    "fileName='" + fileName + '\'' +
                    ", content=" + content +
                    '}';
        }
    }
}



class FileWriter{
    private List<Object> fileSaves = new ArrayList<>();
    private int index = -1;

    public void save(FileUtils fileUtils){
        this.fileSaves.add(fileUtils.save());
        index++;
    }

    public void undo(FileUtils fileUtils){
        index--;
        if(index<=-1){
            System.out.println("Empty File");
            fileUtils.moveToSave(fileUtils.setEmptyFileState());
            return;
        }
        fileUtils.moveToSave(fileSaves.get(index));
    }

    public void redo(FileUtils fileUtils){

        if(index>=fileSaves.size()-1){
            System.out.println("Nothing to redo");
            return;
        }
        index++;
        fileUtils.moveToSave(fileSaves.get(index));
    }

}