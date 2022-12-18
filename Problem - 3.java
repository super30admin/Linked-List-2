// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :no


// Copy data from next node and delete the next node


public class Main {
    public static void main(String[] args) {
        
        ListNode head = new ListNode(1);
        ListNode current = head;
        ListNode del = new ListNode(-1);
        current.next = new ListNode(2);
        current = current.next;
        current.next = del;
        current = current.next;
        current.next = new ListNode(3);
        current = current.next;
        
        ListNode p = head;
        // printing before deleting
        while(p!=null){
            System.out.println(p.data);
            p = p.next;
        }
        
        
        deleteNode(del);
        
        p = head;
        //printing after deleting
        while(p!=null){
            System.out.println(p.data);
            p = p.next;
        }
        
        
    }
    
    public static void deleteNode(ListNode node){
        
        // since the node is not tail node, that means we can copy the data from the next node and then make this node's next to next.next
        node.data = node.next.data;
        node.next = node.next.next; // since its not a tail node, so it has next next
    }
}

class ListNode{
    public ListNode next;
    public int data;
    public ListNode(int d){
        data =d;
    }
}