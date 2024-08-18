public class DoubleLL {
    class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //add
    public void addFirst(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }
    public void addLast(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.prev=tail;
        tail.next=newNode;
        tail=newNode;
    }
    //print
    public void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    //remove
    public int removeFirst(){
        if(head==null){
            System.out.println("DLL is empty");
            return Integer.MAX_VALUE;
        }
        size--;
        int val=head.data;
        if(size==1){
            head=tail=null;
            return val;
        }
        head=head.next;
        head.prev=null;
        return val;
    }
    public int removeLast(){
        if(head==null){
            System.out.println("DLL is empty");
            return Integer.MAX_VALUE;
        }
        size--;
        int val=tail.data;
        if(size==1){
            head=tail=null;
            return val;
        }
        tail=tail.prev;
        tail.next=null;
        return val;
    }

    //reverse
    public void reverse(){
        Node prev=null, curr=tail=head, next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public static void main(String[] args) {
        DoubleLL dll=new DoubleLL();
        dll.addFirst(5);
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print();
        dll.reverse();
        dll.print();
    }
}
