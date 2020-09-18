package BehaviouralPatterns;

import java.util.ArrayList;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("star1");names.add("star2");names.add("star3");names.add("star4");

        Iterable nameCollection = new NameCollection(names);
        Iterator nameIterator = nameCollection.getIterator();

        while (nameIterator.hasNext()) {
            System.out.println(nameIterator.getNext());
        }
    }
}

// ITERATOR DESIGN PATTERN
interface Iterator<T>{
    boolean hasNext();
    T getNext();
}

interface Iterable<T>{
    Iterator<T> getIterator();
}

class NameCollection<T> implements Iterable<T>{

    List<T> names;
    int index = -1;

    public NameCollection(List<T> names) {
        this.names = names;
    }

    @Override
    public Iterator getIterator() {
        return new NameIterator(this);
    }

    public int size(){
        return this.names.size();
    }

    public T getNameAt(int index){
        return this.names.get(index);
    }

}

class NameIterator<T> implements Iterator<T>{

    private NameCollection<T> nameCollection;
    private int index = -1;

    NameIterator(NameCollection<T> nameCollection) {
        this.nameCollection = nameCollection;
    }

    @Override
    public boolean hasNext() {
        if(index+1<nameCollection.size()){
            return true;
        }
        return false;
    }

    @Override
    public T getNext() {
        index = index+1;
        return nameCollection.getNameAt(index);
    }
}

