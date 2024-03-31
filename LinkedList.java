class LinkedList{
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){  //O(1)
        //step-1 = create new node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        //step-2  newNode next = head
        newNode.next = head;

        //step-3  head = newNode
        head = newNode;
    } 

    public void addLast(int data){   //O(1)
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print(){    //O(N)
        if(head == null){
            System.out.println("LL is Empty");
            return;
        }
        
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //add at given index
    public void add(int index, int data){
        //handling the case when idx=0
        if(index==0){
            addFirst(data);
            return;
        }

       Node newNode = new Node(data);
       size++;
       Node temp = head;
       int i=0;

       while(i < index-1){
           temp = temp.next;
           i++;
       }

       //i = index-1  temp = prev
       newNode.next = temp.next;
       temp.next = newNode;
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

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
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int search(int key){  //O(N)
        Node temp = head;
        int idx = 0;

        while(temp != null){
            if(temp.data == key){   //key found
                return idx;
            }
            temp = temp.next;
            idx++;
        }
        return -1;   //key not found

    }

    //recursive search
    public int helper(Node head, int key){   //O(N)
        if(head == null){
            return -1;
        }

        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }

        return idx+1;
    }

    public int Rsearch(int key){
        return helper(head,key);
    }

    //reverse a LL
    public void reverse(){   //O(N)
        Node prev = null;
        Node curr = tail = head;
        Node next;

    while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;   //kyuki curr to null hogya
    }

    //delete nth node from end  -> size-n+1  
    public void deleteNthfromEnd(int n){
        //cal size
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }

        if(n == sz){
            head = head.next;
            return;
        }

        //sz - n  ->previous ko connect krnege previous.next.next se
        int i = 1; //node starting
        int iTOend = sz - n;
        Node prev = head;
        while(i < iTOend){
           prev = prev.next;
           i++;
        }

        prev.next = prev.next.next;
        return;
    }

    //middle of LL -> slow fast approach
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;  //+1
            fast = fast.next.next;  //+2
        }
        return slow;
    }

    //Palindrome
    public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true;
        }

        //step-1 find mid
        Node midNode = findMid(head);

        //step-2 reverse the 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;  //right half head
        Node left = head;

        //step-3 check left and right half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    //checking Cycle-> Floy's Cycle Finding Algorithm
    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;   //+1
            fast = fast.next.next;   //+2
            if(slow == fast){
                return true;    //cycle exists
            }
        }
        return false;   //cycle doesn't exists
    }

    //remove cycle
    public static void removeCycle(){
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }

        //find meeting point
        slow = head;
        Node prev = null;  //last node
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        //remove cycle -> last.next = null
        prev.next = null;
    }

    //merge sort on linked list

    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;  //mid node
    }

    private Node merge(Node head1, Node head2){
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while(head1 != null && head2 != null){
           if(head1.data <= head2.data){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
           }else{
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
           }
        }

        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }

    public Node mergerSort(Node head){  //(nlog(n))
        if(head == null || head.next == null){
            return head;
        }

        //find midNode
        Node mid = getMid(head);

        //left & right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergerSort(head);
        Node newRight = mergerSort(rightHead);

        //merge
        return merge(newLeft,newRight);
    }

    //print zig-zag LinkedList
  
    public void zigzag(){
      //find mid
      Node slow = head;
      Node fast = head.next;

      while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
      }
      Node mid = slow;

      //reverse 2nd half
      Node curr = mid.next;
      mid.next = null;
      Node prev = null;
      Node next;

      while(curr != null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }

      Node left = head;
      Node right = prev;
      Node nextL, nextR;

      //zig-zag merge
      while (left != null && right != null) {
        nextL = left.next;
        left.next = right;
        nextR = right.next;
        right.next = nextL;

        left = nextL;
        right = nextR;
      }
    }


    public static void main(String[] args) {
       LinkedList ll = new LinkedList();
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(3);
        // ll.addLast(2);
        // ll.addLast(1);
        //ll.add(4,100);
        //ll.print();
       // System.out.println(ll.size);

      //  ll.removeFirst();
        // ll.print();
        // ll.removeLast();
        // ll.print();
        // System.out.println(ll.Rsearch(4));
        // System.out.println(ll.Rsearch(100));
       // ll.reverse();
       //ll.deleteNthfromEnd(5);
    //    System.out.println(ll.checkPalindrome());

    //checking cycle
    // head = new Node(1);
    // Node temp = new Node(2);
    // head.next = temp;
    // head.next.next = new Node(3);
    // head.next.next.next = temp;
    //1->2->3->2

    // System.out.println(isCycle());
    // removeCycle();
    // System.out.println(isCycle());

    //merge sort on linkedlist
    // ll.addFirst(1);
    // ll.addFirst(2);
    // ll.addFirst(3);
    // ll.addFirst(4);
    // ll.addFirst(5);
    // //5-4-3-2-1
    // ll.print();
    // ll.head = ll.mergerSort(ll.head);
    // ll.print();

    //zig-zag
    ll.addLast(1);
    ll.addLast(2);
    ll.addLast(3);
    ll.addLast(4);
    ll.addLast(5);
    //1-2-3-4-5
    //after zig-zag -> 1-5-2-4-3
    ll.print();
    ll.zigzag();
    ll.print();


    }
}