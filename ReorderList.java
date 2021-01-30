//TimeComplexity O(n)
//SpaceComplexity O(1)

public class ReorderList {
    public void reorderList(ListNode head) {
        
        if(head==null || head.next==null){
            return;
        }
        
        ListNode currNode=head;
        ListNode forwardNode=head;
        
        while(forwardNode.next!=null && forwardNode.next.next!=null){
            currNode=currNode.next;
            forwardNode=forwardNode.next.next;
            
        }
        
        List<ListNode> ln=new ArrayList<>();
        
        ListNode temp=currNode.next;
        ln.add(temp);
        
        while(temp.next!=null){
            temp=temp.next;
            ln.add(temp);
            
        }
        
        
        
        ListNode hd=head;
        
        ListNode end=currNode;
        end.next=null;
        int size=ln.size()-1;
        
        while(size>=0) {
            
            ListNode addElement=ln.get(size);
            ListNode nextElement=hd.next;
  
            hd.next=addElement;
            addElement.next=nextElement;
            hd=nextElement;
            size--;
            

            
        }
        
        
    }
    
}
