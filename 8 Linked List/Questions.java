public class Questions {
    public static Node head;
    public static Node tail;        

    public static Node sawpNode(int k){
        int size=0;
        Node tri=head;
        //size LL
        while(tri.next!=null){
            tri=tri.next;
            size++;
        }
        int l=size-k;
        Node curr1=head;
        Node curr2=head;
        while(k-->1){
            curr1=curr1.next;
        }
        while(l-->1){
            curr2=curr2.next;
        }

        if(curr1==curr2) return head;

        int temp=curr1.data;
        curr1.data=curr2.data;
        
       
        return head;
    }
}
