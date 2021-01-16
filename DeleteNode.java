// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this :
// Approach : copy value of next node to the node which is to be deleted and change next pointer
// Approach fails when we want to delete a last node.
class DeleteNode {


  public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

 public static void main(String[] args){
   ListNode head = new ListNode(1);
   head.next = new ListNode(2);
   head.next.next = new ListNode(3);
   head.next.next.next = new ListNode(4);
   head.next.next.next.next = new ListNode(5);

   ListNode toDelete = head.next.next;
   System.out.println("Item to be deleted "+ toDelete.val);
   System.out.println("\n========= Before delete ========");
   ListNode temp = head;

   while(temp != null){
     System.out.print(temp.val + "->");
     temp = temp.next;
   }

   if(toDelete.next != null){
     toDelete.val = toDelete.next.val;
     toDelete.next = toDelete.next.next;
   }else{
     toDelete.val = toDelete.next.val;

   }

   System.out.println("\n========= After delete ========");
   temp = head;

   while(temp != null){
     System.out.print(temp.val + "->");
     temp = temp.next;
   }

   System.out.println("");
 }
}
