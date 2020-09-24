package StructuralPatterns;

public class ProxyDemo {
    public static void main(String[] args){
        Chef chef1 = new ChefProxy("Samuel");
        Chef chef2 = new ChefProxy("Prithvi");

        chef1.makeRecipe("Sushi");
        chef2.makeRecipe("Pasta");
        chef2.makeRecipe("Sushi");
    }
}


interface Chef{
    void makeRecipe(String name);
}

class ChefImpl implements Chef{

    @Override
    public void makeRecipe(String name) {
        System.out.println("Cooking recipe "+name);
    }
}

class ChefProxy implements Chef{
    boolean isHeadCook=false;
    Chef chef;

    public ChefProxy(String cookName) {
        if(cookName.equalsIgnoreCase("SAMUEL")) { this.isHeadCook = true;}
        this.chef = new ChefImpl();
    }


    @Override
    public void makeRecipe(String name) {
        if(isHeadCook){
            chef.makeRecipe(name);
        }
        else{
            if(name.trim().equalsIgnoreCase("SUSHI")){
                System.out.println("Cook is not allowed to prepare this dish");
            }
            else{
                chef.makeRecipe(name);
            }
        }
    }
}