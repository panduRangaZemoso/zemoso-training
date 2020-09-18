package BehaviouralPatterns;

import java.util.ArrayList;
import java.util.List;

public class VisitorDemo {
    public static void main(String[] args){
        List<App> appsToTroubleShoot = new ArrayList<>();

        appsToTroubleShoot.add(new Pubg());
        appsToTroubleShoot.add(new Facebook());
        AppVisitor troubleShooter = new TroubleShooter();

        appsToTroubleShoot.forEach( app -> app.accept(troubleShooter));
    }
}


interface AppVisitor{
    void visit(Pubg app);
    void visit(Facebook app);
}

interface App{
    void accept(AppVisitor appVisitor);
}

class Pubg implements App{

    @Override
    public void accept(AppVisitor appVisitor) {
        appVisitor.visit(this);
    }
}

class Facebook implements App{

    @Override
    public void accept(AppVisitor appVisitor) {
        appVisitor.visit(this);
    }
}

class TroubleShooter implements AppVisitor{

    @Override
    public void visit(Pubg app) {
        System.out.println("Troubleshooting PUBG");
    }

    @Override
    public void visit(Facebook app) {
        System.out.println("Troubleshooting Facebook");
    }
}