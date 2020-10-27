public class Assignment10 {
    public static void main(String[] args){
        SList<Integer> list = new SList<>();

        list.remove(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(3);

        System.out.println(list);

        list.remove(3);

        System.out.println(list);

        list.insert(3);

        System.out.println(list);

        list.remove(10);
    }
}

class SList<T>{
    SListNode<T> head;
    SListNode<T> present;

    public SList() {
        this.head = new SListNode<>(null);
        this.present = head;
    }

    SListIterator<T> getIterator(){
        return new SListIterator(this);
    }

    void insert(T data){
        // EMPTY LIST
        if(head == null){
            head = new SListNode<>(data);
            present = head;
            return;
        }

        SListIterator<T> iterator = this.getIterator();
        while(iterator.hasNext()){
            present = iterator.getNext();
        }
        present.nextNode = new SListNode<T>(data);
        present = head;
    }

    void remove(T data){
        // EMPTY LIST
        if(head.nextNode == null){
            System.out.println("List is empty");
            return;
        }

        SListIterator<T> iterator = this.getIterator();
        present = head;
        SListNode<T> prev,next;

        //boolean foundFlag = false;

        while(iterator.hasNext()){
            prev = present;
            present = iterator.getNext();
            next = present.nextNode;

            if(present.data == data){
                prev.nextNode = next;

                // IF DELETE ALL OCCURENCES
                // present=prev;
                // foundFlag = true;

                // IF DELETE FIRST OCCURENCE
                present=head;
                return;
            }
        }
        present = head;
        //if(!foundFlag) {
        System.out.println("Not found in list");
        //}
    }

    @Override
    public String toString(){
        String s="";
        SListIterator<T> iterator = this.getIterator();
        while (iterator.hasNext()){
            s += iterator.getNextData()+" ";
        }
        return s.trim();
    }
}

class SListNode<T>{
    T data;
    SListNode<T> nextNode;

    public SListNode(T data) {
        this.data = data;
    }
}

class SListIterator<T>{
   SList<T> sList;

    public SListIterator(SList<T> sList) {
        this.sList = sList;
    }

    public boolean hasNext() {
        if(sList.present.nextNode != null){
            return true;
        }
        return false;
    }

    public SListNode<T> getNext() {
        sList.present = sList.present.nextNode;
        return sList.present;
    }

    public T getNextData() {
        return this.getNext().data;
    }

}
