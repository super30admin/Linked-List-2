// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// Approach
// 1. find middle
// 2. reverse second half
// 3. merge


class ReorderList {

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

   System.out.println("\n========= Before reorder ========");
   ListNode temp = head;

   while(temp != null){
     System.out.print(temp.val + "->");
     temp = temp.next;
   }



   ListNode slow = head;
   ListNode fast = head;

   while(fast.next != null && fast.next.next != null){
     slow = slow.next;
     fast = fast.next.next;
   }

   fast = reverse(slow.next);
   slow.next = null;
    slow = head;

   while(fast != null){
    temp = slow.next;
     slow.next = fast;
     fast = fast.next;
     slow.next.next = temp;
     slow = temp;
   }

   System.out.println("\n========= After reorder ========");
   temp = head;

   while(temp != null){
     System.out.print(temp.val + "->");
     temp = temp.next;
   }
   System.out.println("\n");
 }

 private static ListNode reverse(ListNode head){
   ListNode prev = null;
   ListNode curr = head;

   while(curr != null){
     ListNode fast = curr.next;
     curr.next = prev;
     prev = curr;
     curr = fast;
   }

   return prev;
 }
}
