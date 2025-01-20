public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;
    
    public void addFirst(int data){//O(1)
        // Creating new node with data
        Node newNode=new Node(data);
        size++;
        if (head==null) {
            head=tail=newNode;
            return;
        }
        // newNode.next points to current head
        newNode.next=head;
        // head points to newNode
        head=newNode;
    }
    public void addLast(int data){//O(1)
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public void print(){//O(n)
        if(head==null){
            System.out.println("Linked list is emplty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public void add(int idx, int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode=new Node(data);
        size++;
        int i=0;
        Node temp=head;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public int removeFirst(){
        int val;
        if(size==0){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        } else if(size==1){
            val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        val=head.data;
        head=head.next;
        size--;
        return val;
    }
    public int removeLast(){
        int val;
        if(size==0){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        } else if(size==1){
            val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        val=prev.next.data;//tail.data
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }
    public int itrSearch(int key){//O(n)
        int idx=0;
        Node temp=head;
        while(temp!=null){
            if(temp.data==key)
                return idx;
            idx++;
            temp=temp.next;
        }
        return -1;
    }
    public int helper(Node head, int key){
        if(head==null)
            return-1;
        if(head.data==key)
            return 0;
        int idx=helper(head.next, key);
        if(idx==-1)
            return -1;
        return idx+1;
    }
    public int recSearch(int key){//O(n)
        return helper(head, key);
    }
    public void itrReverse(){//O(n)
        Node prev=null, curr=tail=head, next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    

    //Find and remove Nth node from end


    public int removeNthEnd(int n){
        if(n==size){
            int data=head.data;
            head=head.next;
            return data;
        }
        int idx=size-n-1;
        Node curr=head, prev=null;
        for(int i=0;i<=idx;i++){
            prev=curr;
            curr=curr.next;
        }
        int data=curr.data;
        prev.next=curr.next;
        return data;
    }
 

    //Check give Linked List is palindrome or not


    public boolean isPalinddrome(){
        if(head==null||head.next==null){
            return true;
        }
        //Find mid ----> slow-fast method
        Node fast=head, slow=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow;
        //Reverse second half
        Node prev=null, curr=tail=mid, next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        //Check fist half==second half
        Node right=prev;
        Node left=head;
        while (right!=null) {
            if(left.data!=right.data)
                return false;
            right=right.next;
            left=left.next;
        }
        return true;
    }


    /*
    Check the Linked List is Cyclic/Loop or not
      1-2-3-4-5
          |   |  ---------> Cyclic LL
          8-7-6 
    */


    public boolean isCyclic(){
        if(head==null||head.next==null)
            return false;
        Node slow=head, fast=head;
        //loop tiversal in linked list
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;//in cyclic atleast one time slow fast meet at same node
            if(slow==fast)
                return true;
        }
        return false;
    }


    //Remove a loop or cyclic in linked list


    public void removeCycle(){
        //find last node by slow and fast method
        Node slow=head, fast=head, prev=null;
        while(fast!=null&&fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast&&slow==head&&fast==head){//corner case
                prev.next=null;
                return;
            }
            if(slow==fast){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    prev=fast;
                    fast=fast.next;
                }
                break;
            }
        }
        //now last node.next = null
        prev.next=null;
    }


    //Merge sorting in Linked List


    private Node getMid(Node head){
        Node slow=head, fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private Node merge(Node left, Node right){
        Node mergeLL=new Node(-1);
        Node temp=mergeLL;
        while (left!=null&&right!=null) {
            if (left.data<=right.data) {
                temp.next=left;
                left=left.next;
                temp=temp.next;
            } else {
                temp.next=right;
                right=right.next;
                temp=temp.next;
            }
        }
        while (left!=null) {
            temp.next=left;
            left=left.next;
            temp=temp.next;
        }
        while (right!=null) {
            temp.next=right;
            right=right.next;
            temp=temp.next;
        }
        return mergeLL.next;
    }
    public Node mergeSort(Node head)    {
        if(head==null||head.next==null)
            return head;
        //Find Mid----->slow-fast methd
        Node mid=getMid(head);
        
        //MS in left LL and right LL
        Node rightHead=mid.next;
        mid.next=null;
        Node newLeft=mergeSort(head);
        Node newRight=mergeSort(rightHead);
        //merge
        return merge(newLeft,newRight);
    }


    /*
     Convert Linked list into zigzag form
     input = 1-2-3-4-5-null
     output = 1-5-2-4-3-null
     */

    public void zigZag(){
        if(head==null||head.next==null)
            return;
        //Find Mid
        Node fast=head, slow=head;//slow->Mid
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //Reverse 2nd half
        Node prev=null, curr=slow.next, next;
        slow.next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node left=head, right=prev, nextL, nextR;
        //Alternate merge
        while (left!=null&&right!=null) {
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;
            left=nextL;
            right=nextR;
        }
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();
        ll.zigZag();
        ll.print();
    }
}
