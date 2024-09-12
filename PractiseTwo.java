import java.util.*;
public class PractiseTwo {
    class Node{
        int data;
        Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}
Node head;
    public void insert(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode =  new Node(data);
        if(head == null){
            head = newNode;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void deleteFirst(){
        if(head == null){
            return;
        }
        head = head.next;
    }

    public void deleteLast(){
        if(head == null){
            return;
        }

        if(head.next == null){
            head = null;
            return;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp=temp.next;
        }
         temp.next = null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PractiseTwo list = new PractiseTwo();
        int n =  sc.nextInt();

        while(true){
            int next = sc.nextInt();
            if(next == -1){
                break;
            }
            list.insert(next);
        }
       // list.addFirst(10);
      // list.addLast(99);
     // list.deleteFirst();
     list.deleteLast();
        list.print();


    }
}
