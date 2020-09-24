package StructuralPatterns;

public class DecoratorDemo {

    public static void main(String[] args){
        Reader fileReader = new FileReader("/home/pandu/documents/file.txt");
        fileReader.read();


        Reader compressedFileReader = new CompressedFileReader(fileReader);
        compressedFileReader.read();

        Reader encryptedFileReader = new EncryptedFileReader(fileReader);
        encryptedFileReader.read();

    }
}

interface Reader{
    void read();
}

class FileReader implements  Reader{
    String filePath;

    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void read() {
        System.out.println("Reading file at "+filePath);
    }
}

abstract class FileReaderDecorator implements Reader{
    Reader fileReader;

    public FileReaderDecorator(Reader fileReader) {
        this.fileReader = fileReader;
    }
}

class CompressedFileReader extends FileReaderDecorator{

    public CompressedFileReader(Reader fileReader) {
        super(fileReader);
    }

    @Override
    public void read() {
        System.out.println("DeCompressing file");
        this.fileReader.read();
    }
}


class EncryptedFileReader extends FileReaderDecorator{

    public EncryptedFileReader(Reader fileReader) {
        super(fileReader);
    }

    @Override
    public void read() {
        System.out.println("DeCrypting file");
        this.fileReader.read();
    }
}

