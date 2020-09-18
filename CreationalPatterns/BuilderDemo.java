package CreationalPatterns;

public class BuilderDemo {

    public static void main(String[] args) {
        CricketKit kit1 = new CricketKitBuilder().getCricketKit("Mongoose","SG");

        if(kit1 != null){
            kit1.showKitItems();
        }
    }
}

// BUILDER PATTERN
interface Item{
    public String name();
    public Grip grip();
    public int price();
}

interface Grip{
    public String gripType();
}

class Rubber implements Grip{
    @Override
    public String gripType() {
        return "Rubber";
    }
}

class Threads implements Grip{
    @Override
    public String gripType() {
        return "Threads";
    }
}

abstract class Bat implements Item{
    public Grip grip(){
        return new Rubber();
    }
}

abstract class Ball implements Item{
    public Grip grip(){
        return new Threads();
    }
}

class Dukes extends Ball{

    @Override
    public String name() {
        return "Dukes Cricket Ball";
    }

    @Override
    public int price() {
        return 800;
    }
}

class SG extends Ball{

    @Override
    public String name() {
        return "SG Cricket Ball";
    }

    @Override
    public int price() {
        return 600;
    }
}

class Kookaburra extends Bat{

    @Override
    public String name() {
        return "KookaBurra Cricket Bat";
    }

    @Override
    public int price() {
        return 8500;
    }
}

class Mongoose extends Bat{

    @Override
    public String name() {
        return "Mongoose Cricket Bat";
    }

    @Override
    public int price() {
        return 10000;
    }
}

class CricketKit{
    private Bat bat;
    private Ball ball;

    public Bat getBat() {
        return bat;
    }

    public void setBat(Bat bat) {
        this.bat = bat;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public int getCost(){
        return bat.price()+ ball.price();
    }

    public void showKitItems(){
        System.out.println("bat: "+bat.name()+", ball: "+ball.name()+", price:"+getCost());
    }
}

class CricketKitBuilder{

    public CricketKit getCricketKit(String batType,String ballType){
        CricketKit kit = new CricketKit();

        // BAT SELECTION
        if(batType.equalsIgnoreCase("KOOKABURRA")) {
            kit.setBat(new Kookaburra());
        }
        else if(batType.equalsIgnoreCase("MONGOOSE")) {
            kit.setBat(new Mongoose());
        }
        else{
            kit.setBat(null);
        }

        // BALL SELECTION
        if(ballType.equalsIgnoreCase("SG")) {
            kit.setBall(new SG());
        }
        else if(ballType.equalsIgnoreCase("DUKES")) {
            kit.setBall(new Dukes());
        }
        else{
            kit.setBall(null);
        }

        return kit;
    }
}
