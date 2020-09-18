public class Test1 {

    public static void main(String[] args) {
        Furniture f1 = new Table(4, "circles", false, "wood", 10000);

        System.out.println(f1);
        System.out.println(f1.getDescription());
    }
}


class Table extends Furniture {

    private int legs;
    private String design;
    private boolean desk;

    public Table(int legs, String design, boolean desk, String material, int price) {
        super(material, price);
        this.legs = legs;
        this.design = design;
        this.desk = desk;
    }

    @Override
    public String getDescription() {
        return "This is a TABLE";
    }

    public int getLegs(){
        return legs;
    }

    public void setLegs(int legs){
        this.legs = legs;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public boolean isDesk() {
        return desk;
    }

    public void setDesk(boolean desk) {
        this.desk = desk;
    }

    @Override
    public String toString() {
        return "Table{" +
                "legs=" + legs +
                ", design='" + design + '\'' +
                ", desk=" + desk +
                ", material=" + this.getMaterial() +
                ", price=" + this.getPrice() +
                '}';
    }
}

abstract class Furniture {
    private String material;
    private int price;

    abstract String getDescription();
    public abstract String toString();

    public Furniture(String material, int price){
        this.material = material;
        this.price = price;
    }
    public String getMaterial(){
        return this.material;
    }

    public void setMaterial(String material){
        this.material = material;
    }

    public int getPrice(){
        return this.price;
    }

    public void setPrice(int price){
        this.price = price;
    }

}