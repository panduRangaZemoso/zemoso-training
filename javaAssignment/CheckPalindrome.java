public class CheckPalindrome {
    public static void main(String[] args){
        LinkedList list1 = new LinkedList();
        list1.insert('a');
        list1.insert('b');
        list1.insert('c');
        list1.insert('d');
        //list1.insert('e');
        list1.insert('c');
        list1.insert('b');
        list1.insert('a');
        System.out.println(list1+ " is a palindrome? :" +list1.isPalindrome());

    }
}

class LinkedList{
    Node head;
    int size;

    void insert(char data){
        if(head==null){
            head = new Node(data);
            size++;
            return;
        }
        Node now = head;
        Node prev;
        while(now.nextNode!=null){
            now = now.nextNode;
        }
        prev = now;
        now = new Node(data);
        prev.nextNode=now;
        size++;
    }

    @Override
    public String toString(){
        StringBuilder result= new StringBuilder();
        Node temp = head;
        while(temp != null){
            result.append(temp.data);
            temp = temp.nextNode;
        }
        return result.toString();
    }

    boolean isPalindrome(){
        Character[] stack = new Character[size/2];
        Node temp = head;
        int index=0;
        int top=0;
        while(temp != null){
            if(index<(size/2)){
                stack[index] = temp.data;
                index += 1;
                top += 1;
            }
            else if(top==(size/2)){
                if(size%2 == 0){
                    top -= 1;
                    if(stack[top] != temp.data){
                        return false;
                    }
                }
                // SKIP CENTER NODE IF ODD SIZED LIST
            }
            else{
                top -= 1;
                if(stack[top] != temp.data){
                    return false;
                }
            }
            //System.out.println(Arrays.asList(stack)+" "+top+" "+temp.data);
            temp = temp.nextNode;
        }
        return true;
    }

}

class Node{
    char data;
    Node nextNode;

    public Node(char data) {
        this.data = data;
    }
}
