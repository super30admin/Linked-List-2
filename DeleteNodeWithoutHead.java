//Time Complexity : O(1)
//Space Complexity : O(1)
/*Approach
-given position of node we have to delete so, copying value of its next node to this one
-we have our next node and then we will make the curr node point to next of next
 */
public class DeleteNodeWithoutHead{
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
   }
   public void delete(ListNode del){
       del.val = del.next.val;
       ListNode prev = del;
       del = del.next;
       prev.next = del.next;
   }
    public static void main(String args[]){
        ListNode newNode = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        newNode.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        DeleteNodeWithoutHead obj = new DeleteNodeWithoutHead();
        obj.delete(n3);
        while(newNode != null){System.out.print(newNode.val+" "); newNode= newNode.next;}

    }   

}