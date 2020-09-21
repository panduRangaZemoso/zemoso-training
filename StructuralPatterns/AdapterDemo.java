package StructuralPatterns;

public class AdapterDemo {
    public static void main(String[] args) {
        MongoDriver1 driver1 = new Driver1();
        driver1.search("field","value");

        MongoDriver1 driver2 = new MongoAdapter(new Driver2());
        driver2.search("field","value");
    }
}


interface MongoDriver1{
    void search(String field, String value);
}

interface MongoDriver2{
    void find(String field, String value);
}

class Driver1 implements MongoDriver1{

    @Override
    public void search(String field, String value) {
        System.out.println("Result from DB using driver1");
    }
}

class Driver2 implements MongoDriver2{

    @Override
    public void find(String field, String value) {
        System.out.println("Result from DB using driver2");
    }
}

class MongoAdapter implements MongoDriver1{

    private MongoDriver2 driver;

    public MongoAdapter(MongoDriver2 driver) {
        this.driver = driver;
    }

    @Override
    public void search(String field, String value) {
        this.driver.find(field,value);
    }
}