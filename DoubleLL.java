import java.util.*;
public class DoubleLL {
    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //add first
    public void addFirst(int data){
       Node newNode = new Node(data);
       size++;
       if(head == null){
        head = tail = newNode;
        return;
       }
       
       newNode.next = head;
       head.prev = newNode;
       head = newNode;
    }

    //addlast
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    //print
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //remove first
    public int removeFirst(){
        if(head == null){
            System.out.println("DLL is Empty");
            return Integer.MIN_VALUE;
        }

        if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    //remove last
    
    public int removeLast(){
        if(size == 0){
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        //prev : i = size-2  //piche se 2nd last
        Node prev = head;
        for(int i=0; i<size-2; i++){
            prev = prev.next;
        }

        int val = prev.next.data;  //tail.data
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

    //reverse 
    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;  //new added in case of dll

            prev = curr;
            curr = next;
        }
        head = prev;
    }


    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        //add-first
        // dll.addFirst(3);
        // dll.addFirst(2);
        // dll.addFirst(1);
        // dll.print();
        // System.out.println(dll.size);

        //add-last
        dll.addLast(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addLast(5);
        dll.print();
        dll.reverse();
        dll.print();

        // dll.removeLast();
        // dll.print();


    }
}
