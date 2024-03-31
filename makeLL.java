import java.util.*;
class makeLL{
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
        Node head;

       public void insert(int data){
            Node newNode = new Node(data);
            if(head==null){
                head = newNode;
            }else{
                Node temp = head;
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=newNode;
            }
        }

        public void print(){
             Node curr = head;
             while(curr != null){
                System.out.print(curr.data+" ");
                curr=curr.next;
             }
             System.out.println();
        }
        
        public void middle(){
           Node slow = head;
           Node fast = head;
           while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast=fast.next.next;
           }
           System.out.println(slow.data);
        }

        public void reverse(){
            Node curr = head;
            Node prev = null;
            Node next;
            while(curr!=null){
                next = curr.next;
                curr.next = prev;
                prev=curr;
                curr=next;
            }
            head = prev;
        }
        

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        makeLL list = new makeLL();
        int n = sc.nextInt();
        while(n!=-1){
            list.insert(n);
            n=sc.nextInt();
        }

         list.reverse();
         list.print();

    }
}