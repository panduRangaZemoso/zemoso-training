package BehaviouralPatterns;

public class StrategyDemo {
  public static void main(String[] args) {
      // USE BINARY SEARCH STRATEGY
      Context context = new Context(new BinarySearch());
      context.executeSearch();

      // CHANGE TO LINEAR SEARCH STRATEGY
      context.setSearchStrategy(new LinearSearch());
      context.executeSearch();
  }
}

// STRATEGY DESIGN PATTERN
interface Search{
    void execute();
}

class BinarySearch implements Search{

    @Override
    public void execute() {
        System.out.println("Using Binary Search Strategy");
    }
}

class LinearSearch implements Search {

    @Override
    public void execute() {
        System.out.println("Using Linear Search Strategy");
    }
}


class Context{
    private Search search;

    Context(Search search){
        this.search = search;
    }

    public void setSearchStrategy(Search search) {
        this.search = search;
    }

    public void executeSearch(){
        search.execute();
    }
}